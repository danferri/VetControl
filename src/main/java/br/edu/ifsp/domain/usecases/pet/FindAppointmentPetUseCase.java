package br.edu.ifsp.domain.usecases.pet;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;

import java.util.List;

public class FindAppointmentPetUseCase {
    private AppointmentRepository appointmentRepository;

    public FindAppointmentPetUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> listarConsultasPorPet(Pet pet) {
        return appointmentRepository.findByPet(pet);
    }
}
