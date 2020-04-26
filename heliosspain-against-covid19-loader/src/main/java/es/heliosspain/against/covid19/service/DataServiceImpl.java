package es.heliosspain.against.covid19.service;

import es.heliosspain.against.covid19.dto.NodeDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    @Value("${mock.json.location}")
    private String mockJsonLcation;



    public List<NodeDto> getAllData(){

        return null;
    }

    public String getAllMocks(){

        return null;
    }
}
