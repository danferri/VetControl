package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.client.PetStatus;

public class DeactivatePetUseCase {
    private PetRepository petRepository;

    public DeactivatePetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void inativarPet(int id) {
        Pet pet = petRepository.findById(id);
        if (pet != null) {
            pet.setStatus(PetStatus.INACTIVE);
            petRepository.update(pet);
        } else {
            throw new IllegalArgumentException("Pet não encontrado com o ID fornecido.");
        }
    }
}
