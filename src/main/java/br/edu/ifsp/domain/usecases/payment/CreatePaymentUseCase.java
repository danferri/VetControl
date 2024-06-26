package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;

public class CreatePaymentUseCase {
    private PaymentRepository paymentRepository;

    public CreatePaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void cadastrarPagamento(Appointment appointment, String method, double amount) {
        Payment payment = new Payment(appointment, method, amount);
        paymentRepository.save(payment);
    }
}
