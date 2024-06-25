package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetStatus;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class PetValidator extends Validator<Pet> {
    @Override
    public Notification validate(Pet pet) {
        Notification notification = new Notification();

        if(pet == null) {
            notification.addError("Pet is null");
            return notification;
        }
        if(nullOrEmpty(pet.getName()))
            notification.addError("Pet name is null or empty");
        if(nullOrEmpty(pet.getBreed()))
            notification.addError("Pet breed is null or empty");
        if(nullOrEmpty(pet.getSpecies()))
            notification.addError("Pet species is null or empty");
        if(!pet.getOwner().getPets().isEmpty())
            notification.addError("Pet already has an owner");
        if(pet.getStatus() == PetStatus.INACTIVE)
            notification.addError("Pet is no longer avilable");

        return notification;
    }
}
