package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class VeterinarianValidator extends Validator<Veterinarian> {
    @Override
    public Notification validate(Veterinarian veterinarian) {
        Notification notification = new Notification();

        if(veterinarian == null){
            notification.addError("Veterinarian is null!");
            return notification;
        }

        if(nullOrEmpty(veterinarian.getName()))
            notification.addError("Veterinarian name is empty!");
        if(nullOrEmpty(veterinarian.getAddress()))
            notification.addError("Veterinarian adress is empty!");
        if(nullOrEmpty(veterinarian.getSpecialty()))
            notification.addError("Veterinarian specialty is empty!");
        if(nullOrEmpty(veterinarian.getPhone()))
            notification.addError("Veterinarian phone is empty!");
        if(nullOrEmpty(veterinarian.getCrmv()))
            notification.addError("Veterinarian CRMV is empty!");
        if(nullOrEmpty(veterinarian.getContact()))
            notification.addError("Veterinarian contact is empty!");

        return notification;
    }
}