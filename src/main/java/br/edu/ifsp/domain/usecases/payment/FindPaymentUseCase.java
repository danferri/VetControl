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

        Payment payment = paymentRepository.findById(id);
        if (payment == null) {
            throw new IllegalArgumentException("Pagamento não encontrado com o ID fornecido.");
        }
        return payment;
    }
}