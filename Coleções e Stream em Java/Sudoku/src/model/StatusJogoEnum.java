package model;

public enum StatusJogoEnum {

    NAO_INICIADO("Nao iniciado"),
    INCOMPLETO("Incompleto"),
    COMPLETO("Finalizado");

    private String status;

    StatusJogoEnum(String message) {
        this.status = message;
    }

    public String getStatus() {
        return status;
    }
}
