package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class PaymentValidator extends Validator<Payment> {
    @Override
    public Notification validate(Payment type) {
        return null;
    }
}
