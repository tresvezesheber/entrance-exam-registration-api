package br.dev.hebio.entranceexamregistrationapi.domain.model.course;

public record DetailsCourseDto(
        Long id,
        String name,
        String modality,
        String duration,
        String mode,
        String unit,
        String period,
        String monthlyFee,
        String description,
        Boolean active) {

    public DetailsCourseDto (Course course) {
        this(course.getId(), course.getName(), course.getModality(), course.getDuration(), course.getMode(), course.getUnit(), course.getPeriod(), course.getMonthlyFee(), course.getDescription(), course.getActive());
    }
}
