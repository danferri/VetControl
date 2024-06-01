package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.util.List;


public class FindAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public FindAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment SearchAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }
    public List<Appointment> searchAppointmentsByVeterinarian(Veterinarian veterinarian) {
        return appointmentRepository.findByVeterinarian(veterinarian);
    }
}
