package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.payment.PaymentStatus;

public class CreatePaymentUseCase {
    private PaymentRepository paymentRepository;

    public CreatePaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void cadastrarPagamento(int id, String method, PaymentStatus status, double amount) {
        Payment payment = new Payment(id, method, status, amount);
        paymentRepository.save(payment);
    }
}
