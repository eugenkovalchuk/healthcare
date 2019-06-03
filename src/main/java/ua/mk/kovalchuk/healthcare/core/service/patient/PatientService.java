package ua.mk.kovalchuk.healthcare.core.service.patient;

import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.web.facade.patient.view.PatientView;

import java.util.List;
import java.util.Optional;

public interface PatientService {


    Optional<Patient> createPatient(Patient patient);

    List<Patient> getPatientList(Integer size);
}
