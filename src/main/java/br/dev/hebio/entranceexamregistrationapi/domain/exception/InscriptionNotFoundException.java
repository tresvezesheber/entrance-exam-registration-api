package br.dev.hebio.entranceexamregistrationapi.domain.exception;

public class InscriptionNotFoundException extends RuntimeException {
    public InscriptionNotFoundException(String message) {
        super(message);
    }
}
