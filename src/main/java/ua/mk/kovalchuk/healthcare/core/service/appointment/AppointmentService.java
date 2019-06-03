package ua.mk.kovalchuk.healthcare.core.service.appointment;

import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.view.AppointmentView;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface AppointmentService {

    Optional<Appointment> create(Appointment appointment);

    List<Appointment> getLastAppointments(Long patientId, Integer size);
}
