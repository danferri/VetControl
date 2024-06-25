package br.edu.ifsp.domain.usecases.appointment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.payment.PaymentValidator;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddAppointmentUseCase {
    private AppointmentRepository appointmentRepository;
    private PaymentRepository paymentRepository;

    public AddAppointmentUseCase(AppointmentRepository appointmentRepository, PaymentRepository paymentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
    }

    public Appointment cadastrarConsulta(int id, LocalDate date, LocalTime hour, String description, Veterinarian veterinarian, Pet pet, double cost, Payment payment) {
        Appointment appointment = new Appointment(id, date, hour, description, veterinarian, pet, cost, payment);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public boolean cadastrarConsulta(LocalDate date, LocalTime hour, String description, Veterinarian veterinarian, Pet pet, double cost) {
        Appointment appointment = new Appointment(date, hour, description, veterinarian, pet, cost);
        return appointmentRepository.save(appointment);

    }

    // Cadastro de consulta com banco e atrelando Payment e Appointment
//    public boolean cadastrarConsulta(int id, LocalDate date, LocalTime hour, String description,
//                                     Veterinarian veterinarian, Pet pet, double cost, String method){
//
//        Appointment appointment = new Appointment(date, hour, description, veterinarian, pet, cost);
//        Payment payment = new Payment(appointment, method, cost);
//        appointment.setPayment(payment);
//
//        Validator<Payment> validatorPayment = new PaymentValidator();
//        Validator<Appointment> validatorAppointment = new AppointmentValidator();
//        Notification notificationPayment = validatorPayment.validate(payment);
//        Notification notificationAppointment = validatorAppointment.validate(appointment);
//
//        if(notificationAppointment.hasErrors())
//            throw new IllegalArgumentException(notificationAppointment.errorMessage());
//        if(notificationPayment.hasErrors())
//            throw new IllegalArgumentException(notificationPayment.errorMessage());
//
//        paymentRepository.save(payment);
//        return appointmentRepository.save(appointment);
//
//    }
}
