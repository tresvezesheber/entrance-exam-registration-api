package br.dev.hebio.entranceexamregistrationapi.api.closed;

import br.dev.hebio.entranceexamregistrationapi.domain.exception.CourseNotFoundException;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.CreateCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class CoursePrivateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private JacksonTester<CreateCourseDto> jsonCreateCourseDto;

    @Test
    @DisplayName("Should return http code 400 when trying to register a course with invalid data")
    void shouldReturnHttpCode400WhenRegisterCourseWithInvalidData() throws Exception {
        var response = mockMvc.perform(post("/private/course"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return http code 201 and location header when trying to register a course with valid data")
    void shouldReturnHttpCode201AndLocationWhenRegisterCourseWithValidData() throws Exception {
        CreateCourseDto createCourseDto = new CreateCourseDto(
                "Direito",
                "Graduação",
                "5 anos",
                "Presencial",
                "HebIO Dev",
                "Noturno",
                "R$ 1.220,00",
                "O curso de Direito da Faculdade de Miguel Pereira tem como objetivo geral o desenvolvimento de um curso de Ciências Jurídicas, voltado para o conhecimento jurídico com formação humanista."
        );

        var response = mockMvc
                .perform(
                        post("/private/course")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonCreateCourseDto.write(createCourseDto).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getHeader("Location")).containsPattern(".*/private/course/\\d+");
    }

    @Test
    @DisplayName("Should return http code 400 when trying to update a course with invalid data")
    void shouldReturnHttpCode400WhenUpdateCourseWithInvalidData() throws Exception {
        var response = mockMvc.perform(put("/private/course/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return http code 204 when trying to update a course with valid data")
    void shouldReturnHttpCode204WhenUpdateCourseWithValidData() throws Exception {
        CreateCourseDto createCourseDto = new CreateCourseDto(
                "Direito",
                "Graduação",
                "5 anos",
                "Presencial",
                "HebIO Dev",
                "Noturno",
                "R$ 1.220,00",
                "O curso de Direito da Faculdade de Miguel Pereira tem como objetivo geral o desenvolvimento de um curso de Ciências Jurídicas, voltado para o conhecimento jurídico com formação humanista."
        );

        var response = mockMvc
                .perform(
                        put("/private/course/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonCreateCourseDto.write(createCourseDto).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @DisplayName("Should return http code 404 when trying to update a course with invalid id")
    void shouldReturnHttpCode404WhenUpdateCourseWithInvalidId() throws Exception {
        CreateCourseDto createCourseDto = new CreateCourseDto(
                "Direito",
                "Graduação",
                "5 anos",
                "Presencial",
                "HebIO Dev",
                "Noturno",
                "R$ 1.220,00",
                "O curso de Direito da Faculdade de Miguel Pereira tem como objetivo geral o desenvolvimento de um curso de Ciências Jurídicas, voltado para o conhecimento jurídico with formação humanista."
        );

        doThrow(new CourseNotFoundException("Course with id: 1 not found")).when(courseService).updateCourse(eq(1L), any(CreateCourseDto.class));

        var response = mockMvc
                .perform(
                        put("/private/course/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonCreateCourseDto.write(createCourseDto).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}