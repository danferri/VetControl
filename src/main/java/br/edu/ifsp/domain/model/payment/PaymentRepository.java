package br.edu.ifsp.domain.model.payment;
import br.edu.ifsp.domain.model.payment.Payment;

public interface PaymentRepository {
    void save(Payment payment);
    Payment findById(int id);
    void update(Payment payment);
}