package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.client.PetStatus;

public class AddPetUseCase {
    private PetRepository petRepository;

    public AddPetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void cadastrarPet(int id, String name, String breed, String species, Client owner, PetStatus status) {
        Pet pet = new Pet(id, name, breed, species, owner, status);
        petRepository.save(pet);
    }
}
