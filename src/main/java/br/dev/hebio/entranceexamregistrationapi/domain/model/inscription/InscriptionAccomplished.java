package br.dev.hebio.entranceexamregistrationapi.domain.model.inscription;

public record InscriptionAccomplished(
        String name,
        String cpf,
        String address,
        String city,
        String courseName,
        String coursePeriod,
        String courseDuration
) {

    public InscriptionAccomplished(Inscription inscription) {
        this(inscription.getName(), formatCPF(inscription.getCpf()), inscription.getAddress(), inscription.getCity(), inscription.getCourse().getName(), inscription.getCourse().getPeriod(), inscription.getCourse().getDuration());
    }

    private static String formatCPF(String cpf) {
        return String.format("***.%s.%s-**", cpf.substring(3, 6), cpf.substring(6, 9));
    }
}
