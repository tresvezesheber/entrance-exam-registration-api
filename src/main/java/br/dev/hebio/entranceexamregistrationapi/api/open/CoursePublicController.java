package br.dev.hebio.entranceexamregistrationapi.api.open;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.DetailsCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/course")
public class CoursePublicController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<DetailsCourseDto>> listAll() {
        return ResponseEntity.ok(courseService.listAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsCourseDto> findCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }
}
