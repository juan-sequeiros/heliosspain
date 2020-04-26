package es.heliosspain.against.covid19.repositories;

import es.heliosspain.against.covid19.entities.Doctor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Repository
public interface DoctorRepository extends Neo4jRepository<Doctor, Long> {

    List<Doctor> findByName(String name);


    @Query("MATCH (d:Doctor)-[r:ATTEND]->(p:Paciente) where r.ts>={0} and r.ts<={1}  return d,r,p;")
    List<Doctor> findByTs(Instant start, Instant end);

    @Transactional
    @Override
    Iterable<Doctor> findAll();

    @Query("MATCH (d:Doctor)-[r:ATTEND]->(p:Paciente),\n" +
            "     (d:Doctor)-[w:WORK_IN]->(h:Hospital)\n" +
            "     where r.ts>={0} and r.ts<={1}\n" +
            "     return d,r,p,w,h;")
    List<Doctor> getModelInformation(Instant start, Instant end);

}