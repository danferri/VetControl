package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;

import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.edu.ifsp.domain.model.payment.Payment;

public class AppointmentFactory {
    public static Appointment CreateAppointment(Integer id, LocalDate data, LocalTime hora, String historico, Veterinarian veterinario, Pet pet, Payment payment, double value) {
        return new Appointment(id, data, hora, historico, veterinario, pet, value, payment);
    }
}
