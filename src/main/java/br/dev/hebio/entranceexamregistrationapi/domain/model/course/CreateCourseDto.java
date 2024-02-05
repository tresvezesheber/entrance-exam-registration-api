package br.dev.hebio.entranceexamregistrationapi.domain.model.course;

public record CreateCourseDto(
        String name,
        String modality,
        String duration,
        String mode,
        String unit,
        String period,
        String monthlyFee,
        String description) {
}
