package es.heliosspain.against.covid19.providers;

import es.heliosspain.against.covid19.dto.NodeDto;
import es.heliosspain.against.covid19.entities.Doctor;
import es.heliosspain.against.covid19.entities.Hospital;
import es.heliosspain.against.covid19.mappers.IHospitalMapper;
import es.heliosspain.against.covid19.repositories.DoctorRepository;
import es.heliosspain.against.covid19.repositories.HospitalRepository;
import es.heliosspain.against.covid19.service.IHospitalProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;

@Repository
public class HospitalProvider implements IHospitalProvider {

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    IHospitalMapper hospitalMapper;


    @Override
    public NodeDto getAll() {
        ArrayList<Hospital> hospitalArrayList = (ArrayList<Hospital>) hospitalRepository.findAll();
        ArrayList<Doctor> doctors = (ArrayList<Doctor>) doctorRepository.getPersonsWhoActAndDirect();
        return null;
    }
}
