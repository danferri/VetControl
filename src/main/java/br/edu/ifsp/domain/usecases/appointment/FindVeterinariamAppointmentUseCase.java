package br.edu.ifsp.domain.usecases.appointment;

//CDU018

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.util.List;

public class FindVeterinariamAppointmentUseCase {
    private  final AppointmentRepository appointmentRepository;

    public FindVeterinariamAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public  List<Appointment> searchAppointmentsByVeterinarian(Veterinarian veterinarian) {
        return appointmentRepository.findByVeterinarian(veterinarian);
    }
}
