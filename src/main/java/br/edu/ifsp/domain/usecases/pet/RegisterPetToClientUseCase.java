package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.*;

public class RegisterPetToClientUseCase {
    private PetRepository petRepository;
    private ClientRepository clientRepository;

    public RegisterPetToClientUseCase(PetRepository petRepository, ClientRepository clientRepository) {
        this.petRepository = petRepository;
        this.clientRepository = clientRepository;
    }

    public void cadastrarPet( CPF clientCpf, Pet pet) {
        if (clientRepository.findByCPF(clientCpf).isPresent()) {
            Client owner = clientRepository.findByCPF(clientCpf).get();
            owner.addPet(pet);
            clientRepository.update(owner);
            petRepository.save(pet);
        }
        throw new IllegalArgumentException("Cliente não encontrado com o CPF fornecido.");
    }
}
