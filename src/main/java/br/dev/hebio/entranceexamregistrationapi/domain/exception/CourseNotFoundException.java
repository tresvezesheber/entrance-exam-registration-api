package br.dev.hebio.entranceexamregistrationapi.domain.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
