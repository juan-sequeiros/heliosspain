package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.relations.Attend;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AttendRepository extends Neo4jRepository<Attend, Long> {

}