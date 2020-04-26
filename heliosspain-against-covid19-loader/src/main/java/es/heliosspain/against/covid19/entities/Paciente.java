package es.heliosspain.against.covid19.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class Paciente {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Paciente() {
    }

    public Paciente(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
