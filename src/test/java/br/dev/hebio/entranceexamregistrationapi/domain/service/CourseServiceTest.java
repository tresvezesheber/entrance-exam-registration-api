package br.dev.hebio.entranceexamregistrationapi.domain.service;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
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

    @Test
    public void testFindCourseById() {
        Course course = new Course();
        course.setId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        DetailsCourseDto detailsCourseDto = courseService.findCourseById(1L);

        assertEquals(course.getId(), detailsCourseDto.id());

        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteCourse() {
        Course course = new Course();
        course.setId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.deleteCourse(1L);

        verify(courseRepository, times(1)).findById(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testListAllCourses() {
        Course course1 = new Course();
        course1.setId(1L);
        Course course2 = new Course();
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
        Course course = new Course();
        course.setId(1L);

        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course result = courseService.saveCourse(course);

        assertEquals(course.getId(), result.getId());

        verify(courseRepository, times(1)).save(course);
    }
}
