package br.edu.ifsp.domain.model.payment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.usecases.payment.*;

public class PaymentServices {
    private PaymentRepository paymentRepository;

    public PaymentServices(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addPayment(Appointment appointment, String method, double amount) {
        CreatePaymentUseCase addPaymentUseCase = new CreatePaymentUseCase(paymentRepository);
        addPaymentUseCase.cadastrarPagamento(appointment, method,  amount);
    }
}
