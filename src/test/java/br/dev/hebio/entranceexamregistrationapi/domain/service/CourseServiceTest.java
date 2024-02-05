package br.dev.hebio.entranceexamregistrationapi.domain.service;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.CreateCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.DetailsCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    CreateCourseDto createCourseDto1 = new CreateCourseDto("Direito", "Graduação", "5 anos", "Presencial", "HebIO Dev", "Noturno", "R$ 780,00", "O curso de Direito da HebIO Dev tem como objetivo geral o desenvolvimento de um curso de Ciências Jurídicas, voltado para o conhecimento jurídico com formação humanista.");
    CreateCourseDto createCourseDto2 = new CreateCourseDto("Pedagogia", "Graduação", "4 anos", "Presencial", "HebIO Dev", "Noturno", "R$ 620,00", "O Curso de de Pedagogia da Faculdade de Miguel Pereira tem como objetivo formar o Pedagogo para atuação em diferentes ramos do mundo do trabalho, que corresponda às exigências de uma formação de qualidade e que demonstre uma postura que faça frente às expectativas e demandas sociais.");

    @Test
    public void testFindCourseById() {
        Course course = new Course(createCourseDto1);
        course.setId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        DetailsCourseDto detailsCourseDto = courseService.findCourseById(1L);

        assertEquals(course.getId(), detailsCourseDto.id());

        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteCourse() {
        Course course = new Course(createCourseDto1);
        course.setId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.deleteCourse(1L);

        verify(courseRepository, times(1)).findById(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testListAllCourses() {
        Course course1 = new Course(createCourseDto1);
        course1.setId(1L);
        Course course2 = new Course(createCourseDto2);
        course2.setId(2L);

        when(courseRepository.findAll()).thenReturn(List.of(course1, course2));

        List<DetailsCourseDto> result = courseService.listAllCourses();

        assertEquals(2, result.size());
        assertEquals(course1.getId(), result.get(0).id());
        assertEquals(course2.getId(), result.get(1).id());

        verify(courseRepository, times(1)).findAll();
    }

    @Test
    public void testSaveCourse() {
        Course course = new Course(createCourseDto1);
        course.setId(1L);

        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Long resultId = courseService.saveCourse(createCourseDto1);

        assertEquals(course.getId(), resultId);

        verify(courseRepository, times(1)).save(any(Course.class));
    }
}
