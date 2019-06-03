package ua.mk.kovalchuk.healthcare.core.service.appointment.impl;

import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.core.service.appointment.AppointmentService;
import ua.mk.kovalchuk.healthcare.core.store.appointment.AppointmentStore;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAppointmentService implements AppointmentService {
    private final AppointmentStore appointmentStore;

    public DefaultAppointmentService(AppointmentStore appointmentStore) {
        this.appointmentStore = appointmentStore;
    }

    @Override
    public Optional<Appointment> create(Appointment appointment) {
        return appointmentStore.create(appointment);
    }
    @Override
    public List<Appointment> getLastAppointments(Long patientId, Integer size) {
        return appointmentStore.getLastAppointments(patientId, size);
    }
}
