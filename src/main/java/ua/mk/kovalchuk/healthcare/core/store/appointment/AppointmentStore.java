package ua.mk.kovalchuk.healthcare.core.store.appointment;

import ua.mk.kovalchuk.healthcare.core.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentStore {
    Optional<Appointment> create(Appointment appointment);

    List<Appointment> getLastAppointments(Long patientId, Integer size);
}
