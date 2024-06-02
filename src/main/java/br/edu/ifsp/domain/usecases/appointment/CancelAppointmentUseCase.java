package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.appointment.AppointmentStatus;

public class CancelAppointmentUseCase {
    private AppointmentRepository appointmentRepository;

    public CancelAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void cancelarConsulta(int id) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment == null) {
            throw new IllegalArgumentException("Consulta não encontrada com o ID fornecido.");
        }
        appointment.setStatus(AppointmentStatus.CANCELED);
        appointmentRepository.update(appointment);
    }
}
