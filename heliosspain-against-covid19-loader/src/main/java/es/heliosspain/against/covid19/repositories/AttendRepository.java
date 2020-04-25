package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.relations.Attend;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AttendRepository extends Neo4jRepository<Attend, Long> {

}