package ua.mk.kovalchuk.healthcare.web.facade.appointment.impl;

import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.core.service.appointment.AppointmentService;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.AppointmentFacade;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.view.AppointmentView;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultAppointmentFacade implements AppointmentFacade {
    private final AppointmentService appointmentService;
    private final AppintmentToViewConverter appintmentToViewConverter;

    public DefaultAppointmentFacade(AppointmentService appointmentService, AppintmentToViewConverter appintmentToViewConverter) {
        this.appointmentService = appointmentService;
        this.appintmentToViewConverter = appintmentToViewConverter;
    }

    @Override
    public Optional<Appointment> createAppointment(Long patientId, AppointmentView appointmentView) {
        return appointmentService.create(
                Appointment.builder()
                        .note(appointmentView.getNote())
                        .timestamp(Instant.now().toEpochMilli())
                        .build());
    }

    @Override
    public List<AppointmentView> getLastAppointments(Long patientId, Integer size) {
        return appointmentService.getLastAppointments(patientId, size).stream()
                .map(appintmentToViewConverter::convert)
                .collect(Collectors.toList());
    }

}
