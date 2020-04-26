package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.relations.Has;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HasRepository extends Neo4jRepository<Has, Long> {

}