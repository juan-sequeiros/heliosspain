package es.heliosspain.against.covid19.relations;


import es.heliosspain.against.covid19.entities.Hospital;
import es.heliosspain.against.covid19.entities.Sala;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HAS")
public class Has {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Hospital hospital;

    @EndNode
    private Sala sala;

    private String property;

    public Has(Hospital hospital, Sala sala, String property) {
        this.hospital = hospital;
        this.sala = sala;
        this.property = property;
    }
}
