package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class AppointmentValidator extends Validator<Appointment> {
    @Override
    public Notification validate(Appointment appointment) {
        return null;
    }
}
