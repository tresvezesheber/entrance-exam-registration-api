package br.dev.hebio.entranceexamregistrationapi.domain.model.inscription;

import br.dev.hebio.entranceexamregistrationapi.domain.model.course.Course;
import br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype.EntranceType;
import br.dev.hebio.entranceexamregistrationapi.domain.service.CourseService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String gender;

    private String phone;

    @NotBlank
    private String cellPhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EntranceType entranceType;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String state;

    @NotBlank
    private String howDidYouKnow;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    @JoinColumn(name = "course_id")
    private Course course;

    public Inscription(InscriptionInput inscriptionInput) {
        this.name = inscriptionInput.name();
        this.email = inscriptionInput.email();
        this.cpf = inscriptionInput.cpf();
        this.gender = inscriptionInput.gender();
        this.phone = inscriptionInput.phone();
        this.cellPhone = inscriptionInput.cellPhone();
        this.entranceType = inscriptionInput.entranceType();
        this.address = inscriptionInput.address();
        this.number = inscriptionInput.number();
        this.complement = inscriptionInput.complement();
        this.neighborhood = inscriptionInput.neighborhood();
        this.city = inscriptionInput.city();
        this.postalCode = inscriptionInput.postalCode();
        this.state = inscriptionInput.state();
        this.howDidYouKnow = inscriptionInput.howDidYouKnow();
        this.course = inscriptionInput.course();
    }
}
