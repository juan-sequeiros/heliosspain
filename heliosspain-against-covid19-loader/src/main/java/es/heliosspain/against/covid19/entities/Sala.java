package es.heliosspain.against.covid19.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class Sala {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    public Sala() {
    }

    public Sala(String type) {
        this.type = type;
    }
}
