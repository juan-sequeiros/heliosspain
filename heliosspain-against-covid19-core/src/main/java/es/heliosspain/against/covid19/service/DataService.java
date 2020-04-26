package es.heliosspain.against.covid19.service;


import es.heliosspain.against.covid19.dto.NodeDto;

import java.util.List;

public interface DataService {

    List<NodeDto> getAllData();
    String getAllMocks();
}
