package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.appointment.AppointmentStatus;

public class PerformAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public PerformAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void performAppointment(int id) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment != null && appointment.getStatus() != AppointmentStatus.CANCELED) {
            appointment.setStatus(AppointmentStatus.COMPLETED);
            appointmentRepository.update(appointment);
        } else {
            throw new IllegalArgumentException("Appointment not found or cannot be marked as completed.");
        }
    }
}
