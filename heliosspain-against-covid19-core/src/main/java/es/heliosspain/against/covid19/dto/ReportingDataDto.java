package es.heliosspain.against.covid19.dto;

import java.io.Serializable;

/**
 * DTO to use for generating a report. The front-end must send an object like this.
 */
public class ReportingDataDto implements Serializable {

    private static final long serialVersionUID = 8962808495180079959L;

    private String id;
    private String name;
    private String department;
    private String email;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
