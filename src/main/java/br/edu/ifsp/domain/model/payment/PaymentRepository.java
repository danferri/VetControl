package br.edu.ifsp.domain.model.payment;
import br.edu.ifsp.domain.model.payment.Payment;

import java.util.List;

public interface PaymentRepository {
    void save(Payment payment);
    Payment findById(int id);

    List<Payment> findAll();

    void update(Payment payment);
}