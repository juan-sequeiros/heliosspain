package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.entities.Doctor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DoctorRepository extends Neo4jRepository<Doctor, Long> {

}