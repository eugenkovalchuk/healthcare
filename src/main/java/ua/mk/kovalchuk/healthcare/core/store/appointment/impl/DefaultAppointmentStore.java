package ua.mk.kovalchuk.healthcare.core.store.appointment.impl;

import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.core.store.appointment.AppointmentStore;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultAppointmentStore implements AppointmentStore {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Appointment> create(Appointment appointment) {
        entityManager.persist(appointment);
        return Optional.ofNullable(entityManager.find(Appointment.class, appointment));
    }

    @Override
    public List<Appointment> getLastAppointments(Long patientId, Integer size) {
        Query query = entityManager.createNativeQuery("SELECT em.* FROM public.appointment as em " +
                " LIMIT ?", Appointment.class);
        query.setParameter(1, size);
        return query.getResultList();
    }
}
