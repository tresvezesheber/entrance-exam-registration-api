package br.dev.hebio.entranceexamregistrationapi.domain.repository;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
