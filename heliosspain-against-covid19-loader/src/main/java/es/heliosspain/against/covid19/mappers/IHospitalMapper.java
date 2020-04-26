package es.heliosspain.against.covid19.mappers;

import es.heliosspain.against.covid19.dto.NodeDto;
import es.heliosspain.against.covid19.entities.Doctor;

import java.util.ArrayList;

public interface IHospitalMapper {

    public ArrayList<NodeDto> ModelToDtoDoctors(ArrayList<Doctor> doctors);
}
