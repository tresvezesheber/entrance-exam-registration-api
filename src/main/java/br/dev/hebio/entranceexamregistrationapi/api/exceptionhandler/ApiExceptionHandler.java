package br.dev.hebio.entranceexamregistrationapi.api.exceptionhandler;

import br.dev.hebio.entranceexamregistrationapi.domain.exception.CourseNotFoundException;
import br.dev.hebio.entranceexamregistrationapi.domain.exception.InscriptionNotFoundException;
import br.dev.hebio.entranceexamregistrationapi.domain.exception.InvalidEntranceTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(InscriptionNotFoundException.class)
    public ProblemDetail handlerInscriptionNotFound(InscriptionNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Inscription not found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("https://hebio.dev/errors/inscription-not-found"));
        return problemDetail;
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ProblemDetail handleCourseNotFound(CourseNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Course not found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("https://hebio.dev/errors/course-not-found"));
        return problemDetail;
    }

    @ExceptionHandler(InvalidEntranceTypeException.class)
    public ProblemDetail handleInvalidEntranceType(InvalidEntranceTypeException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Invalid entrance type");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("https://hebio.dev/errors/invalid-entrance-type"));
        return problemDetail;
    }
}
