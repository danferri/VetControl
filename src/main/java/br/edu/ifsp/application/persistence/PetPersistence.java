package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;

import java.util.ArrayList;
import java.util.List;

public class PetPersistence implements PetRepository {
    private List<Pet> animais = new ArrayList<>();
    private int currentId = 1;
    @Override
    public void save(Pet animal) {
        animais.add(animal);
    }

    @Override
    public Pet findById(int id) {
        return animais.get(id-1);
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(animais);
    }
}
