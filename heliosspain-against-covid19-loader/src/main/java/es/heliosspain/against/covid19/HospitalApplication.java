package es.heliosspain.against.covid19;

import es.heliosspain.against.covid19.entities.Doctor;
import es.heliosspain.against.covid19.entities.Hospital;
import es.heliosspain.against.covid19.entities.Paciente;
import es.heliosspain.against.covid19.entities.Sala;
import es.heliosspain.against.covid19.relations.Attend;
import es.heliosspain.against.covid19.relations.BeingIn;
import es.heliosspain.against.covid19.relations.Has;
import es.heliosspain.against.covid19.relations.WorkIn;
import es.heliosspain.against.covid19.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
@EnableNeo4jRepositories
public class HospitalApplication {

	private final static Logger log = LoggerFactory.getLogger(HospitalApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(PacienteRepository pacienteRepository,
						   DoctorRepository doctorRepository,
						   HospitalRepository hospitalRepository,
						   SalaRepository salaRepository,
						   HasRepository hasRepository,
						   BeingInRepository beingInRepository,
						   AttendRepository attendRepository,
						   WorkInRepository workInRepository) {
		return args -> {

			doctorRepository.deleteAll();
			hospitalRepository.deleteAll();
			pacienteRepository.deleteAll();
			salaRepository.deleteAll();
			workInRepository.deleteAll();
			attendRepository.deleteAll();
			hasRepository.deleteAll();
			beingInRepository.deleteAll();


			Doctor greg = new Doctor("Andres");

			Hospital hos = new Hospital("Puerta de hierro");
			Hospital hos2 = new Hospital("Infanta sofia");

			WorkIn workIn = new WorkIn(greg, hos, "");
			WorkIn workIn2 = new WorkIn(greg, hos2, "una valor");

			workInRepository.save(workIn);
			workInRepository.save(workIn2);

			Paciente pa1 = new Paciente("Loreto");
			Paciente pa2 = new Paciente("Antonio");

			Attend att1 = new Attend(greg,pa1, Instant.now());
			Attend att2 = new Attend(greg,pa2, Instant.now());

			attendRepository.save(att1);
			attendRepository.save(att2);

			Sala sala = new Sala("Sala espera");

			BeingIn beingIn = new BeingIn(pa1, sala, Instant.now());
			BeingIn beingIn2 = new BeingIn(pa2, sala, Instant.now());

			beingInRepository.saveAll(Arrays.asList(beingIn, beingIn2));

			Has has1 = new Has(hos, sala, "una propiedad");

			hasRepository.save(has1);












		};
	}

}
