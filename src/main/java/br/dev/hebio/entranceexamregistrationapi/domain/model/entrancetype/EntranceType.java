package br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype;

import br.dev.hebio.entranceexamregistrationapi.domain.exception.InvalidEntranceTypeException;

public enum EntranceType {

    VESTIBULAR("Vestibular Digital 2024.1 Prova Online"),
    BOLETIM_ENEM("Boletim do ENEM (2020, 2021, 2022 ou 2023)"),
    TRANSFERENCIA("Transferência"),
    REINTEGRACAO("Reintegração (Aproveitamento de Estudos)"),
    REINGRESSO("Reingresso (2ª Graduação)");

    private String description;

    private EntranceType(String description) {
        this.description = description;
    }

    public static EntranceType fromString(String value) {
        for (EntranceType type : EntranceType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new InvalidEntranceTypeException("Invalid EntranceType: " + value);
    }

    public String getdescription() {
        return description;
    }
}
