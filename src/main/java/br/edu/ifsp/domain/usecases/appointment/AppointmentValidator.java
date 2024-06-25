package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentStatus;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetStatus;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianStatus;
import br.edu.ifsp.domain.usecases.payment.PaymentValidator;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentValidator extends Validator<Appointment> {
    @Override
    public Notification validate(Appointment appointment) {
        Notification notification = new Notification();

        if(appointment == null) {
            notification.addError("Appointment is null");
            return notification;
        }

        if(nullOrEmpty(appointment.getDate()))
            notification.addError("Appointment date scheduled is invalid");
        if(nullOrEmpty(appointment.getHour()))
            notification.addError("Appointment hour scheduled is invalid");
        if(nullOrEmpty(appointment.getDescription()))
            notification.addError("Appointment description is null or empty");
        if(nullOrEmpty(appointment.getCost()))
            notification.addError("Appointment cost is null or empty");

        return notification;

    }
}
