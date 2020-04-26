package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.entities.Paciente;
import es.heliosspain.against.covid19.relations.WorkIn;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PacienteRepository extends Neo4jRepository<Paciente, Long> {

}