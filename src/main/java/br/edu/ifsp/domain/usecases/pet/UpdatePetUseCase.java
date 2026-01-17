package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;

public class UpdatePetUseCase {
    private PetRepository petRepository;


    public UpdatePetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void alterarPet(int id, String newName, String newBreed, String newSpecies, Client newOwner) {
        Pet pet = petRepository.findById(id);
        if (pet != null) {
            if (newName != null && !newName.isEmpty()) pet.setName(newName);
            if (newBreed != null && !newBreed.isEmpty()) pet.setBreed(newBreed);
            if (newSpecies != null && !newSpecies.isEmpty()) pet.setSpecies(newSpecies);
            if (newOwner != null) pet.setOwner(newOwner);
            petRepository.update(pet);
        } else {
            throw new IllegalArgumentException("Pet não encontrado com o ID fornecido.");
        }
    }
}
