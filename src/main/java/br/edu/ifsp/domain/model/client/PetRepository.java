package br.edu.ifsp.domain.model.client;

import java.util.List;

public interface PetRepository {
    void save(Pet animal);
    Pet findById(int id);
    List<Pet> findAll();
}
