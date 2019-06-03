package ua.mk.kovalchuk.healthcare.web.facade.patient.impl;

import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.core.service.patient.PatientService;
import ua.mk.kovalchuk.healthcare.web.facade.patient.PatientFacade;
import ua.mk.kovalchuk.healthcare.web.facade.patient.view.PatientView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultPatientFacade implements PatientFacade {
    private final PatientService patientService;
    private final PatientToViewConverter patientToViewConverter;

    public DefaultPatientFacade(PatientService patientService, PatientToViewConverter patientToViewConverter) {
        this.patientService = patientService;
        this.patientToViewConverter = patientToViewConverter;
    }


    @Override
    public Optional<Patient> createPatient(PatientView patientView) {
        return patientService.createPatient(
                Patient.builder()
                        .name(patientView.getName())
                        .surname(patientView.getSurname())
                        .email(patientView.getEmail())
                        .build());
    }

    @Override
    public List<PatientView> getPatientList(Integer size) {
        return patientService.getPatientList(size)
                .stream()
                .map(patientToViewConverter::convert)
                .collect(Collectors.toList());
    }
}
