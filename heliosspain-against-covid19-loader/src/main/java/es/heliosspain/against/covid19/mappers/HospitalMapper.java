package es.heliosspain.against.covid19.mappers;

import es.heliosspain.against.covid19.dto.*;
import es.heliosspain.against.covid19.entities.Attend;
import es.heliosspain.against.covid19.entities.Doctor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class HospitalMapper implements IHospitalMapper{

    @Override
    public ArrayList<NodeDto> ModelToDtoDoctors(ArrayList<Doctor> doctors){
        ArrayList<NodeDto> nodeDtos = new ArrayList<>();

        for (Doctor doctor : doctors){

            for (Attend attend : doctor.getAttends()) {
                DataNodeDto pacienteDto = new DataNodeDto();
                DataNodeDto doctorDto = new DataNodeDto();
                DataNodeDto relacionDto = new DataNodeDto();

                NodeDto nodeDtoDoctor = new NodeDto();

                doctorDto.setId(doctor.getId().toString());
                doctorDto.setName(doctor.getName());
                doctorDto.setSpecialty(SpecialtyType.MEDICA_GENERAL);
                doctorDto.setType(HealthPersonnelType.doctor);
                doctorDto.setCovid19(new BigDecimal("10"));
                nodeDtoDoctor.setData(doctorDto);
                nodeDtoDoctor.setGroup(GroupType.nodes);

                NodeDto nodeDtoPaciente = new NodeDto();

                pacienteDto.setName(attend.getPaciente().getName());
                pacienteDto.setType(HealthPersonnelType.patient);
                pacienteDto.setId(attend.getPaciente().getId().toString());
                nodeDtoPaciente.setData(pacienteDto);
                nodeDtoPaciente.setGroup(GroupType.nodes);

                NodeDto nodeDtoRelacion = new NodeDto();
                relacionDto.setSource(doctorDto.getId());
                relacionDto.setTarget(pacienteDto.getId());
                relacionDto.setId(doctorDto.getId()+pacienteDto.getId()+"attend");
                nodeDtoRelacion.setData(relacionDto);
                nodeDtoRelacion.setGroup(GroupType.edges);

                nodeDtos.add(nodeDtoDoctor);
                nodeDtos.add(nodeDtoPaciente);
                nodeDtos.add(nodeDtoRelacion);

            }
        }
        return nodeDtos;

    }
}
