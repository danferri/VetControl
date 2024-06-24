package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class PetValidator extends Validator<Pet> {
    @Override
    public Notification validate(Pet type) {
        return null;
    }
}
