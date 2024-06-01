package br.edu.ifsp.domain.model.payment;

import br.edu.ifsp.domain.usecases.payment.*;

public class PaymentServices {
    private PaymentRepository paymentRepository;

    public PaymentServices(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addPayment(int id, String method, PaymentStatus status, double amount) {
        CreatePaymentUseCase addPaymentUseCase = new CreatePaymentUseCase(paymentRepository);
        addPaymentUseCase.cadastrarPagamento(id, method, status, amount);
    }

    public Payment findPayment(int id) {
        FindPaymentUseCase findPaymentUseCase = new FindPaymentUseCase(paymentRepository);
      return  findPaymentUseCase.visualizarPagamento(id);
    }

    public void processPayment(int id) {
        ProcessPaymentUseCase processPaymentUseCase = new ProcessPaymentUseCase(paymentRepository);
        processPaymentUseCase.processarPagamento(id);
    }
}
