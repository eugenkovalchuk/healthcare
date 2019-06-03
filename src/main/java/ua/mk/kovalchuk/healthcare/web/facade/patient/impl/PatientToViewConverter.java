package ua.mk.kovalchuk.healthcare.web.facade.patient.impl;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.mk.kovalchuk.healthcare.core.model.Patient;
import ua.mk.kovalchuk.healthcare.web.facade.patient.view.PatientView;

@Component
public class PatientToViewConverter implements Converter<Patient, PatientView> {
    @Override
    public PatientView convert(Patient patient) {
        PatientView view = new PatientView();
        view.setEmail(patient.getEmail());
        view.setName(patient.getName());
        view.setSurname(patient.getSurname());
        view.setPatientId(patient.getId());
        return null;
    }
}
