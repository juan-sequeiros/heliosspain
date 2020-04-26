package es.heliosspain.against.covid19.service;

import es.heliosspain.against.covid19.dto.NodeDto;
import org.springframework.stereotype.Repository;

@Repository
public interface IHospitalProvider {

    public NodeDto getAll();
}
