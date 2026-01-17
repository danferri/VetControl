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

    public boolean cadastrarPet(int id, String name, String breed, String species, Client owner, PetStatus status) {
        Pet pet = new Pet(id, name, breed, species, owner, status);
        return petRepository.save(pet);
    }

    public boolean cadastrarPet(String name, String breed, String species, Client owner) {
        Pet pet = new Pet(name, breed, species, owner);
        return petRepository.save(pet);
    }

    public boolean cadastrarPet(int id, String name, String breed, String species) {
        Pet pet = new Pet(id, name, breed, species);
        return petRepository.save(pet);
    }

}
