package br.dev.hebio.entranceexamregistrationapi.api.closed;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
}