package es.heliosspain.against.covid19.controller;

import es.heliosspain.against.covid19.dto.NodeDto;
import es.heliosspain.against.covid19.service.DataService;
import es.heliosspain.against.covid19.service.IHospitalProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
public class ServiceController {


    private DataService dataService;

    @Autowired
    IHospitalProvider iHospitalProvider;

    @Autowired
    public ServiceController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/allData")
    public String allData(){

        return null;
    }



    @PostMapping(value="/getAllDataHospital",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<NodeDto> getAllDataHospital(@RequestParam(value = "id",required = false) Integer id){
        return iHospitalProvider.getAll();
    }
}
