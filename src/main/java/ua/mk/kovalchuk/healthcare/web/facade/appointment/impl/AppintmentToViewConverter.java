package ua.mk.kovalchuk.healthcare.web.facade.appointment.impl;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Appointment;
import ua.mk.kovalchuk.healthcare.web.facade.appointment.view.AppointmentView;

@Component
public class AppintmentToViewConverter implements Converter<Appointment, AppointmentView> {
    @Override
    public AppointmentView convert(Appointment appointment) {
        AppointmentView view = new AppointmentView();
        view.setNote(appointment.getNote());
        view.setTime(appointment.getTimestamp());
        return view;
    }
}
