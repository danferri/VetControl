package br.edu.ifsp.domain.model.user;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.usecases.appointment.FindVeterinariamAppointmentUseCase;
import br.edu.ifsp.domain.usecases.appointment.PerformAppointmentUseCase;
import br.edu.ifsp.domain.usecases.pet.FindAppointmentPetUseCase;
import br.edu.ifsp.domain.usecases.pet.FindPetUseCase;
import br.edu.ifsp.domain.usecases.veterinarian.FindVeterinarianUseCase;

import java.util.List;

public class VeterinarianServices {
    private PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;
    private VeterinarianRepository veterinarianRepository;

    public VeterinarianServices(PetRepository petRepository, AppointmentRepository appointmentRepository,
                                VeterinarianRepository veterinarianRepository) {
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
        this.veterinarianRepository = veterinarianRepository;
    }

    public Pet findPet(int id) {
        FindPetUseCase findPetUseCase = new FindPetUseCase(petRepository);
        return findPetUseCase.visualizarPet(id);
    }

    public List<Appointment> viewAppointments(Veterinarian veterinarian) {
        FindVeterinariamAppointmentUseCase findVetAppoint = new FindVeterinariamAppointmentUseCase(appointmentRepository);
        return findVetAppoint.searchAppointmentsByVeterinarian(veterinarian);
    }

    public List<Appointment> listAppointmentsByPet(Pet pet) {
        FindAppointmentPetUseCase listAppointmentsByPetUseCase = new FindAppointmentPetUseCase(appointmentRepository);
        return listAppointmentsByPetUseCase.listarConsultasPorPet(pet);
    }

    public void perform(int id) {
        PerformAppointmentUseCase perform = new PerformAppointmentUseCase(appointmentRepository);
        perform.performAppointment(id);
    }
    public Veterinarian findVeterinarian(CRMV crmv) {
        FindVeterinarianUseCase findVeterinarianUseCase = new FindVeterinarianUseCase(veterinarianRepository);
        return findVeterinarianUseCase.visualizarVeterinario(crmv);
    }
}