package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentPersistence implements PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    @Override
    public void save(Payment payment) {
        payments.add(payment);
    }

    @Override
    public Payment findById(int id) {
        for (Payment payment : payments) {
            if (payment.getId() == id) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }

    @Override
    public void update(Payment payment) {
        Payment existingPayment = findById(payment.getId());
        if (existingPayment != null) {
            existingPayment.setMethod(payment.getMethod());
            existingPayment.setStatus(payment.getStatus());
            existingPayment.setAmount(payment.getAmount());
        }
    }

}
