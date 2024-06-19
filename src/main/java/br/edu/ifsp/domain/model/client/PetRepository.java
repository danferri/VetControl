package br.edu.ifsp.domain.model.client;

import java.util.List;

public interface PetRepository {
    boolean save(Pet animal);
    Pet findById(int id);
    List<Pet> findAll();
    void update(Pet pet);
}
