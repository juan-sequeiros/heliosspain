package es.heliosspain.against.covid19.service;

import es.heliosspain.against.covid19.dto.DataNodeDto;
import es.heliosspain.against.covid19.dto.NodeDto;
import es.heliosspain.against.covid19.util.MockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class DataServiceImpl implements DataService{

    @Value("${mock.json.location}")
    private String mockJsonLcation;

    private static Logger logger = LogManager.getLogger(DataService.class.getName());

    public List<NodeDto> getAllData(){
        logger.info("Devolvemos todos los datos consultados");
        return null;
    }

    public String getAllMocks(){
        logger.info("Devolvemos todos los mocks");
        return MockUtil.readJsonFile(mockJsonLcation);
    }
}
