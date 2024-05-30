package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class VeterinarianAddRequestValidator extends Validator<Veterinarian> {

    @Override
    public Notification validate(Veterinarian veterinarian) {
        Notification notification = new Notification();

        if (veterinarian == null) {
            notification.addError("Veterinarian is null");
            return notification;
        }

        if(nullOrEmpty(veterinarian.getAddress())) {
            notification.addError("Veterinarian address is null or empty");
        }

        if(nullOrEmpty(veterinarian.getSpecialty())) {
            notification.addError("Veterinarian specialty is null or empty");
        }

        if(nullOrEmpty(veterinarian.getContact())) {
            notification.addError("Veterinarian contact is null or empty");
        }

        if(nullOrEmpty(veterinarian.getCrmv())) {
            notification.addError("Veterinarian CRMV is null or empty");
        }

        return notification;
    }
}
