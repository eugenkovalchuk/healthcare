package ua.mk.kovalchuk.healthcare.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.AppointmentFacade;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.view.AppointmentView;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class AppointmentController {
    private final AppointmentFacade appointmentFacade;

    public AppointmentController(AppointmentFacade appointmentFacade) {
        this.appointmentFacade = appointmentFacade;
    }

    @RequestMapping(value = "/patient/{patientId}/appointments", method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable(value = "patientId") Long patientId,
                                 @Valid @RequestBody AppointmentView appointmentView) {
        final Optional<Appointment> appointment = appointmentFacade.createAppointment(patientId, appointmentView);
        if (appointment.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/patients/{patientsId}/appointment", method = RequestMethod.GET)
    public ResponseEntity find(@PathVariable(value = "patientsId") Long patientsId,
                               @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return ResponseEntity.ok(appointmentFacade.getLastAppointments(patientsId, size));
    }
}
