package es.heliosspain.against.covid19.service;

import es.heliosspain.against.covid19.dto.NodeDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IHospitalProvider {

    public ArrayList<NodeDto> getAll();
}
