package es.heliosspain.against.covid19.controller;

import es.heliosspain.against.covid19.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/email/send", method = RequestMethod.GET)
    public ResponseEntity generatePDF() {
        this.emailService.sendExampleEmail();
        return new ResponseEntity(HttpStatus.MULTI_STATUS.OK);
    }

}
