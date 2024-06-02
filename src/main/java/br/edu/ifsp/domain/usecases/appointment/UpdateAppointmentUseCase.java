package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateAppointmentUseCase {
    private AppointmentRepository appointmentRepository;

    public UpdateAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void alterarConsulta(int id, LocalDate newDate, LocalTime newHour, String newDescription) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment == null) {
            throw new IllegalArgumentException("Consulta não encontrada com o ID fornecido.");
        }
        if (newDate != null) {
            appointment.setDate(newDate);
        }
        if (newHour != null) {
            appointment.setHour(newHour);
        }
        if (newDescription != null && !newDescription.isEmpty()) {
            appointment.setDescription(newDescription);
        }
        appointmentRepository.update(appointment);
    }
}
