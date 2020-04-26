package es.heliosspain.against.covid19.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Hospital {

    @Id @GeneratedValue private Long id;

    private String name;

    private Hospital() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Hospital(String name) {
        this.name = name;
    }

}