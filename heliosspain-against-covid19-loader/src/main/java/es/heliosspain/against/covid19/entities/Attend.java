package es.heliosspain.against.covid19.entities;


import es.heliosspain.against.covid19.entities.Doctor;
import es.heliosspain.against.covid19.entities.Paciente;
import org.neo4j.ogm.annotation.*;

import java.time.Instant;

@RelationshipEntity(type = "ATTEND")
public class Attend {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Doctor doctor;

    @EndNode
    private Paciente paciente;

    private Instant ts;

    public Attend(Doctor doctor, Paciente paciente, Instant ts) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.ts = ts;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Attend{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", ts=" + ts +
                '}';
    }
}
