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

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
