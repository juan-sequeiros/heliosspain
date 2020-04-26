package es.heliosspain.against.covid19.controller;

import es.heliosspain.against.covid19.dto.NodeDto;
import es.heliosspain.against.covid19.service.DataService;

import es.heliosspain.against.covid19.service.IHospitalProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

@RestController
public class ServiceController {

    private static Logger logger = LogManager.getLogger(ServiceController.class.getName());

    private DataService dataService;

    @Autowired
    IHospitalProvider iHospitalProvider;

    @Autowired
    public ServiceController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/allData")
    public String allData(){
        logger.info(" return allData");
        return null;
    }

    @PostMapping(value="/mocks",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMock(@RequestParam(value = "id",required = false) Integer id){

        //Si no está presente, devuelve todos los datos .
        if (id == null){
            logger.info(" requested all mocks ");
            //dataService.getAllData();
            return dataService.getAllMocks();
        }else{
            logger.info(" requested mock: " + id);
            return " requested mock: " + id;
        }
    }

    @GetMapping(value="/getAllDataHospital",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<NodeDto> getAllDataHospital(@RequestParam(value = "id",required = false) Integer id){
        iHospitalProvider.getAll();
        return null;
    }
}
