package br.dev.hebio.entranceexamregistrationapi.api.open;

import br.dev.hebio.entranceexamregistrationapi.domain.exception.CourseNotFoundException;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CoursePublicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    @DisplayName("Should return http status code 200 when trying to get a course with valid id")
    void shouldReturnHttpStatus200WhenGetCourseWithValidId() throws Exception {
        var response = mockMvc.perform(get("/public/course/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Should return http status code 404 when trying to get a course with invalid id")
    void shouldReturnHttpStatus404WhenGetCourseWithInvalidId() throws Exception {
        doThrow(new CourseNotFoundException("Course with id: 1 not found")).when(courseService).findCourseById(eq(1L));

        var response = mockMvc.perform(get("/public/course/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}