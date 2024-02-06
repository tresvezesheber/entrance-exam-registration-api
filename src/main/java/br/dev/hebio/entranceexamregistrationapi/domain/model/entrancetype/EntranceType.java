package br.dev.hebio.entranceexamregistrationapi.domain.model.entrancetype;

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

    public String getdescription() {
        return description;
    }
}
