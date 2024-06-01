package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;

import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class AppointmentFactory {
    public static Appointment CreateAppointment(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, AppointmentStatus status, Payment payment, double value) {
        return new Appointment(data, hora, historico, veterinario, pet, status, payment, value);
    }
}
