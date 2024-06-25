package br.edu.ifsp.domain.usecases.payment;

//CDU022

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;

public class FindPaymentUseCase {
    private PaymentRepository paymentRepository;

    public FindPaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment visualizarPagamento(int id) {

        return paymentRepository.findById(id);
    }
}