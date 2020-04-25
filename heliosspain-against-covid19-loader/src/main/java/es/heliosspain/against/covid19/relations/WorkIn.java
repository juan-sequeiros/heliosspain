package es.heliosspain.against.covid19.relations;


import es.heliosspain.against.covid19.entities.Doctor;
import es.heliosspain.against.covid19.entities.Hospital;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "WORK_IN")
public class WorkIn {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Doctor person;

    @EndNode
    private Hospital movie;

    private String property;

    public WorkIn(Doctor person, Hospital movie, String property) {
        this.person = person;
        this.movie = movie;
        this.property = property;
    }
}
