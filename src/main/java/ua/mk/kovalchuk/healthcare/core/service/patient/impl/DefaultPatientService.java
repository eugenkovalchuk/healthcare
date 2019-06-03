package ua.mk.kovalchuk.healthcare.core.service.patient.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.core.service.patient.PatientService;
import ua.mk.kovalchuk.healthcare.core.store.PatientStore;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DefaultPatientService implements PatientService {
    private final PatientStore patientStore;

    public DefaultPatientService(PatientStore patientStore) {
        this.patientStore = patientStore;
    }



    @Override
    public Optional<Patient> createPatient(Patient patient) {
        return patientStore.create(patient);
    }

    @Override
    public List<Patient> getPatientList(Integer size) {
        return patientStore.findLimited(size);
    }
}
