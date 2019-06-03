package ua.mk.kovalchuk.healthcare.core.store.impl;

import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.core.store.PatientStore;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultPatientStore implements PatientStore {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<Patient> create(Patient patient) {
        entityManager.persist(patient);
        return Optional.ofNullable(entityManager.find(Patient.class, patient));
    }

    @Override
    public List<Patient> findLimited(Integer size) {
        Query query = entityManager.createNativeQuery("SELECT em.* FROM public.patient as em " +
                " LIMIT ?", Patient.class);
        query.setParameter(1, size);
        return query.getResultList();
    }
}
