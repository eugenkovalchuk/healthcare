package ua.mk.kovalchuk.healthcare.core.store;

import ua.mk.kovalchuk.healthcare.core.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientStore {
    Optional<Patient> create(Patient patient);

    List<Patient> findLimited(Integer size);
}
