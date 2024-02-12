package br.dev.hebio.entranceexamregistrationapi.api.closed;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.CreateCourseDto;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/private/course")
public class CoursePrivateController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity saveCourse(@RequestBody @Valid CreateCourseDto createCourseDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(courseService.saveCourse(createCourseDto)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCourse(@PathVariable Long id, @RequestBody @Valid CreateCourseDto createCourseDto) {
        courseService.updateCourse(id, createCourseDto);
        return ResponseEntity.noContent().build();
    }

}
