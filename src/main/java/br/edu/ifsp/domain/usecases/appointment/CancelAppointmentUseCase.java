package br.edu.ifsp.domain.usecases.appointment;


import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.appointment.AppointmentStatus;

public class CancelAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public CancelAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void CancelAppointment(int id) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment != null && appointment.getStatus() != AppointmentStatus.CANCELED) {
            appointment.setStatus(AppointmentStatus.CANCELED);
            appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Consulta não encontrada ou já cancelada.");
        }
    }
}
