package br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype;

public record EntranceTypeResponse(String value, String description) {
    public EntranceTypeResponse(EntranceType entranceType) {
        this(entranceType.name(), entranceType.getdescription());
    }
}
