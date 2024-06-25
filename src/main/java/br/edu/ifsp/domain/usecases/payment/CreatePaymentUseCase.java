package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;


public class CreatePaymentUseCase {
    private PaymentRepository paymentRepository;

    public CreatePaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void cadastrarPagamento(int id, String method,  double amount) {
        Payment payment = new Payment(id, method, amount);

        Validator<Payment> validator = new PaymentValidator();
        Notification notification = validator.validate(payment);

        if (notification.hasErrors())
            throw new IllegalArgumentException(notification.errorMessage());


        paymentRepository.save(payment);
    }
}
