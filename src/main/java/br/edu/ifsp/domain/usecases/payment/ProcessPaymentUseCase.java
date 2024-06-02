package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.payment.PaymentStatus;

public class ProcessPaymentUseCase {
    private PaymentRepository paymentRepository;

    public ProcessPaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processarPagamento(int id) {
        Payment payment = paymentRepository.findById(id);
        if (payment != null) {
            payment.setStatus(PaymentStatus.CONCLUIDO);
            paymentRepository.update(payment);
        } else {
            throw new IllegalArgumentException("Pagamento não encontrado com o ID fornecido.");
        }
    }
}
