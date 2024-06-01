package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.appointment.*;
import br.edu.ifsp.domain.usecases.pet.FindAppointmentPetUseCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void Insert(Integer id , LocalDate data, LocalTime hora, String historico, Veterinarian veterinario, Pet pet, Payment payment, double value) {
        AddAppointmentUseCase addApointment = new AddAppointmentUseCase(appointmentRepository);
        Appointment appointment = addApointment.cadastrarConsulta(id, data, hora, historico, veterinario, pet,value);
    }

    public Appointment findOne(int id) {
        FindAppointmentUseCase findAppointment = new FindAppointmentUseCase(appointmentRepository);
        return findAppointment.visualizarConsulta(id);
    }

    public void cancel(int id) {
        CancelAppointmentUseCase cancelAppointment = new CancelAppointmentUseCase(appointmentRepository);
        cancelAppointment.cancelarConsulta(id);
    }

    public void Perform(int id) {
        PerformAppointmentUseCase perform = new PerformAppointmentUseCase(appointmentRepository);
        perform.performAppointment(id);
    }

    public List<Appointment> viewAppointments(Veterinarian veterinarian) {
       FindVeterinariamAppointmentUseCase findVetAppoint = new FindVeterinariamAppointmentUseCase(appointmentRepository);
        return findVetAppoint.searchAppointmentsByVeterinarian(veterinarian);
    }

    public List<Appointment> listAppointmentsByPet(Pet pet) {
        FindAppointmentPetUseCase listAppointmentsByPetUseCase = new FindAppointmentPetUseCase(appointmentRepository);
        return listAppointmentsByPetUseCase.listarConsultasPorPet(pet);
    }
}
