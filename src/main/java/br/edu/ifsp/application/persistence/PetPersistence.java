package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;

import java.util.ArrayList;
import java.util.List;

public class PetPersistence implements PetRepository {
    private List<Pet> animais = new ArrayList<>();
    private int currentId = 1;

    @Override
    public boolean save(Pet animal) {
        animais.add(animal);
        return true;
    }

    @Override
    public Pet findById(int id) {
        for (Pet pet : animais) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(animais);
    }

    @Override
    public void update(Pet pet) {
        Pet existingPet = findById(pet.getId());
        if (existingPet != null) {
            existingPet.setName(pet.getName());
            existingPet.setBreed(pet.getBreed());
            existingPet.setSpecies(pet.getSpecies());
        }
    }
}
