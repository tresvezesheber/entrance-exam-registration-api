package br.dev.hebio.entranceexamregistrationapi.domain.model.course;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String modality;

    @NotBlank
    private String duration;

    @NotBlank
    private String mode;

    @NotBlank
    private String unit;

    @NotBlank
    private String period;

    @NotBlank
    private String monthlyFee;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    private Boolean active;
}
