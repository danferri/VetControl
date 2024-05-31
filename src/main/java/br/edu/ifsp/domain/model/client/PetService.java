package br.edu.ifsp.domain.model.client;

public class PetService {
    private PetRepository animalRepository;

    public PetService(PetRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void cadastrarAnimal(String nome, String raca, String especie, Client cliente) {
        Pet animal = PetFactory.createAnimal(nome, raca, especie, cliente);
        animalRepository.save(animal);
    }

    public Pet buscarAnimalPorId(int id) {
        return animalRepository.findById(id);
    }
}
