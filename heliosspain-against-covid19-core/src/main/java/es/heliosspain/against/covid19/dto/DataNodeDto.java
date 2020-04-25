package es.heliosspain.against.covid19.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DataNodeDto implements Serializable {

    String id;
    String name;
    String surname;
    HealthPersonnelType type;
    String typeDescription;
    SpecialtyType specialty;
    BigDecimal covid19;

    String source;
    String cited;
    String target;
    Boolean isdirected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HealthPersonnelType getType() {
        return type;
    }

    public void setType(HealthPersonnelType type) {
        this.type = type;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public SpecialtyType getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyType specialty) {
        this.specialty = specialty;
    }

    public BigDecimal getCovid19() {
        return covid19;
    }

    public void setCovid19(BigDecimal covid19) {
        this.covid19 = covid19;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCited() {
        return cited;
    }

    public void setCited(String cited) {
        this.cited = cited;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Boolean getIsdirected() {
        return isdirected;
    }

    public void setIsdirected(Boolean isdirected) {
        this.isdirected = isdirected;
    }
}
