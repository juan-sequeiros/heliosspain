package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.relations.BeingIn;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BeingInRepository extends Neo4jRepository<BeingIn, Long> {

}