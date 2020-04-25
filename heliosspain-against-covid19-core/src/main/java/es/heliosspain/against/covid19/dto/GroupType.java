package es.heliosspain.against.covid19.dto;

public enum GroupType {


    NODES("nodes"),
    EDGES("edges");

    GroupType(String type) {
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
