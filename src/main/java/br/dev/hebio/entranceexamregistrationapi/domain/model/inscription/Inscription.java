package br.dev.hebio.entranceexamregistrationapi.domain.model.inscription;

import br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype.EntranceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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

    public String getEntranceType() {
        return entranceType.getdescription();
    }
}
