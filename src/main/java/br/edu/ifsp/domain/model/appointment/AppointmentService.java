package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.appointment.*;
import br.edu.ifsp.domain.usecases.payment.ProcessPaymentUseCase;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void Insert(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, Payment payment, double value) {
        AddAppointmenteUseCase addApointment = new AddAppointmenteUseCase(appointmentRepository);
        Appointment appointment = addApointment.AddAppointment(data, hora, historico, veterinario, pet, AppointmentStatus.SCHEDULED, payment, value);
    }

    public Appointment findOne(int id) {
        FindAppointmentUseCase findAppointment = new FindAppointmentUseCase(appointmentRepository);
        return findAppointment.SearchAppointmentById(id);
    }

    public void cancel(int id) {
        CancelAppointmentUseCase cancelAppointment = new CancelAppointmentUseCase(appointmentRepository);
        cancelAppointment.CancelAppointment(id);
    }

    public void Perform(int id) {
        PerformAppointmentUseCase perform = new PerformAppointmentUseCase(appointmentRepository);
        perform.performAppointment(id);
    }

    public List<Appointment> viewAppointments(Veterinarian veterinarian) {
        FindAppointmentUseCase findAppointment = new FindAppointmentUseCase(appointmentRepository);
        return findAppointment.searchAppointmentsByVeterinarian(veterinarian);
    }
}
