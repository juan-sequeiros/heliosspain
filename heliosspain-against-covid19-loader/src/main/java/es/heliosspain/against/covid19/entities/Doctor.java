package es.heliosspain.against.covid19.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class Doctor {

    @Id @GeneratedValue private Long id;

    private String name;

    private Doctor() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Doctor(String name) {
        this.name = name;
    }

    @Relationship(type = "ATTEND")
    private Set<Attend> attends;

    @Relationship(type = "WORK_IN")
    private Set<WorkIn> workIns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Attend> getAttends() {
        return attends;
    }

    public void setAttends(Set<Attend> attends) {
        this.attends = attends;
    }

    public Set<WorkIn> getWorkIns() {
        return workIns;
    }

    public void setWorkIns(Set<WorkIn> workIns) {
        this.workIns = workIns;
    }



    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attends=" + attends +
                '}';
    }
}