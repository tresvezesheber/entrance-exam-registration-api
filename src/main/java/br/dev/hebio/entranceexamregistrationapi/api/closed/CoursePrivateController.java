package br.dev.hebio.entranceexamregistrationapi.api.closed;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.CreateCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/private/course")
public class CoursePrivateController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity saveCourse(@RequestBody CreateCourseDto createCourseDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(courseService.saveCourse(createCourseDto)).toUri();
        return ResponseEntity.created(uri).build();
    }
}
