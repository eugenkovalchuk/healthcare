package ua.mk.kovalchuk.healthcare.web.facade.patient;

import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.web.facade.patient.view.PatientView;

import java.util.List;
import java.util.Optional;

public interface PatientFacade {
    Optional<Patient> createPatient(PatientView patientView);

    List<PatientView> getPatientList(Integer size);
}
