package ua.mk.kovalchuk.healthcare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mk.kovalchuk.healthcare.web.facade.patient.PatientFacade;

@RestController
@RequestMapping(value = "/api/v1")
public class PatientsController {

    private final PatientFacade patientFacade;

    @Autowired
    public PatientsController(PatientFacade patientFacade) {
        this.patientFacade = patientFacade;
    }

}
