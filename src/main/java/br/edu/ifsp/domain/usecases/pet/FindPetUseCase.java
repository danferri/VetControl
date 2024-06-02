package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;

public class FindPetUseCase {
    private PetRepository petRepository;

    public FindPetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet visualizarPet(int id) {
        return petRepository.findById(id);
    }
}
