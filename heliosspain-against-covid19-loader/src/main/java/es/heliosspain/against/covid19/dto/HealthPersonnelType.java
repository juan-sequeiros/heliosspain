package es.heliosspain.against.covid19.dto;

public enum HealthPersonnelType {

    doctor("DOCTOR"),
    nurse("NURSE"),
    patient("PATIENT");


    HealthPersonnelType(String type) {
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
