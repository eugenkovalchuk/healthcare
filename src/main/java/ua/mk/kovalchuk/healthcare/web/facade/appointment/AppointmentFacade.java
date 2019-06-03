package ua.mk.kovalchuk.healthcare.web.facade.appointment;

import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.view.AppointmentView;

import java.util.List;
import java.util.Optional;

public interface AppointmentFacade {
    Optional<Appointment> createAppointment(Long patientId, AppointmentView appointmentView);

    List<AppointmentView> getLastAppointments(Long patientId, Integer size);
}
