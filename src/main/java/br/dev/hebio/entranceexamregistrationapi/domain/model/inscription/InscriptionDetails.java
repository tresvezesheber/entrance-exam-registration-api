package br.dev.hebio.entranceexamregistrationapi.domain.model.inscription;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype.EntranceType;

public record InscriptionDetails(
        Long id,
        String name,
        String email,
        String cpf,
        String gender,
        String phone,
        String cellPhone,
        EntranceType entranceType,
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
    public InscriptionDetails(Inscription inscription) {
        this(inscription.getId(), inscription.getName(), inscription.getEmail(), inscription.getCpf(), inscription.getGender(), inscription.getPhone(), inscription.getCellPhone(), inscription.getEntranceType(), inscription.getAddress(), inscription.getNumber(), inscription.getComplement(), inscription.getNeighborhood(), inscription.getCity(), inscription.getPostalCode(), inscription.getState(), inscription.getHowDidYouKnow(), inscription.getCourse());
    }
}
