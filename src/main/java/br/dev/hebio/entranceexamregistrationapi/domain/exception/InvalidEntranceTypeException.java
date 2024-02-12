package br.dev.hebio.entranceexamregistrationapi.domain.exception;

public class InvalidEntranceTypeException extends RuntimeException {
    public InvalidEntranceTypeException(String message) {
        super(message);
    }
}
