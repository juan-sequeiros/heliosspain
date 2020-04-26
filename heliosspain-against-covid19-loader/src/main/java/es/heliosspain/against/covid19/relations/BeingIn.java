package es.heliosspain.against.covid19.relations;


import es.heliosspain.against.covid19.entities.Paciente;
import es.heliosspain.against.covid19.entities.Sala;
import org.neo4j.ogm.annotation.*;

import java.time.Instant;

@RelationshipEntity(type = "BEING_IN")

public class BeingIn {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Paciente paciente;

    @EndNode
    private Sala sala;

    private Instant ts;

    public BeingIn(Paciente paciente, Sala sala, Instant ts) {
        this.paciente = paciente;
        this.sala = sala;
        this.ts = ts;
    }
}
