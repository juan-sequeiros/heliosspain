package es.heliosspain.against.covid19.dto;

public enum SpecialtyType {

    MEDICA_GENERAL("Medicina general"),
    MEDICA_INTERNA("Medicina interna");

    SpecialtyType(String type) {
        this.type = type;
    }

    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
