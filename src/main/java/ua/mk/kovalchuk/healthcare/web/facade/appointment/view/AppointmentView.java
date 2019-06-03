package ua.mk.kovalchuk.healthcare.web.facade.appointment.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentView {
    @NotEmpty
    private String note;
    private long time;
}
