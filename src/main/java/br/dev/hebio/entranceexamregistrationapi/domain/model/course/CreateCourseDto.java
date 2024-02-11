package br.dev.hebio.entranceexamregistrationapi.domain.model.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCourseDto(
        @NotBlank
        @Size(max = 150)
        String name,
        @NotBlank
        @Size(max = 50)
        String modality,
        @NotBlank
        @Size(max = 50)
        String duration,
        @NotBlank
        @Size(max = 50)
        String mode,
        @NotBlank
        @Size(max = 150)
        String unit,
        @NotBlank
        @Size(max = 50)
        String period,
        @NotBlank
        @Size(max = 50)
        String monthlyFee,
        @NotBlank
        @Size(max = 500)
        String description) {
}
