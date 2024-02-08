package br.dev.hebio.entranceexamregistrationapi.domain.model.inscription;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype.EntranceType;

public record InscriptionInput(
        String name,
        String email,
        String cpf,
        String gender,
        String phone,
        String cellPhone,
        String entranceType,
        String address,
        String number,
        String complement,
        String neighborhood,
        String city,
        String postalCode,
        String state,
        String howDidYouKnow,
        Course course
) {
}
