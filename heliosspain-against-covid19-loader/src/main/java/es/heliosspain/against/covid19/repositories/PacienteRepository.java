package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.entities.Paciente;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PacienteRepository extends Neo4jRepository<Paciente, Long> {

}