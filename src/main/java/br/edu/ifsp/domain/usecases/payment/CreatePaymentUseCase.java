//package br.edu.ifsp.domain.usecases.payment;
//
//import br.edu.ifsp.domain.model.appointment.Appointment;
//import br.edu.ifsp.domain.model.payment.Payment;
//import br.edu.ifsp.domain.model.payment.PaymentRepository;
//import br.edu.ifsp.domain.usecases.appointment.AppointmentValidator;
//import br.edu.ifsp.domain.usecases.utils.Notification;
//import br.edu.ifsp.domain.usecases.utils.Validator;
//
//
//public class CreatePaymentUseCase {
//    private PaymentRepository paymentRepository;
//
//    public CreatePaymentUseCase(PaymentRepository paymentRepository) {
//        this.paymentRepository = paymentRepository;
//    }
//
//    public Payment cadastrarPagamento(Appointment appointment, String method, double amount) {
//        Payment payment = new Payment(appointment, method, amount);
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
//        return payment;
//    }
//}
