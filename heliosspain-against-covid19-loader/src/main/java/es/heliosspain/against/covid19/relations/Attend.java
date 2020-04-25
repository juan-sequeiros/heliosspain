package es.heliosspain.against.covid19.relations;


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
    private Doctor person;

    @EndNode
    private Paciente paciente;

    private Instant ts;

    public Attend(Doctor person, Paciente paciente, Instant ts) {
        this.person = person;
        this.paciente = paciente;
        this.ts = ts;
    }
}
