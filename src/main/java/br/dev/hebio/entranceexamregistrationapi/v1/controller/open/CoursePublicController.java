package br.dev.hebio.entranceexamregistrationapi.v1.controller.open;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.DetailsCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/course")
public class CoursePublicController {

    @Autowired
    private CourseService courseService;

    public ResponseEntity<List<DetailsCourseDto>> listAll() {
        return ResponseEntity.ok(courseService.listAllCourses());
    }
}
