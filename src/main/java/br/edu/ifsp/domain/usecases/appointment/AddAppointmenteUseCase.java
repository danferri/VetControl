package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class AddAppointmenteUseCase {
    private final AppointmentRepository consultaRepository;

    public AddAppointmenteUseCase(AppointmentRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Appointment AddAppointment(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, AppointmentStatus agendada, Payment payment, double value) {
        Appointment appointment = AppointmentFactory.CreateAppointment(data, hora, historico, veterinario, pet, agendada, payment, value);
        consultaRepository.save(appointment);
        return appointment;
    }
}
