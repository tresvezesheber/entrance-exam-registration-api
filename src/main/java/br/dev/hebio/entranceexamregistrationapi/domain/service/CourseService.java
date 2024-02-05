package br.dev.hebio.entranceexamregistrationapi.domain.service;

import br.dev.hebio.entranceexamregistrationapi.domain.exception.CourseNotFoundException;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.CreateCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.model.course.DetailsCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<DetailsCourseDto> listAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(DetailsCourseDto::new)
                .toList();
    }

    public Long saveCourse(CreateCourseDto createCourseDto) {
        return courseRepository.save(new Course(createCourseDto)).getId();
    }

    public DetailsCourseDto findCourseById(Long id) {
        Course courseFound = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course with id: " + id + " not found"));
        return new DetailsCourseDto(courseFound);
    }

    public void deleteCourse(Long id) {
        DetailsCourseDto course = findCourseById(id);
        courseRepository.deleteById(course.id());
    }
}
