package br.edu.ifsp.domain.usecases.pet;

import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class RegisterPetToClientUseCase {
    private PetRepository petRepository;
    private ClientRepository clientRepository;

    public RegisterPetToClientUseCase(PetRepository petRepository, ClientRepository clientRepository) {
        this.petRepository = petRepository;
        this.clientRepository = clientRepository;
    }

    public void cadastrarPet( CPF clientCpf, Pet pet) {
        Validator<Pet> validator = new PetValidator();
        Notification notification = validator.validate(pet);

        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.errorMessage());
        if (clientRepository.findByCPF(clientCpf).isPresent()) {
            Client owner = clientRepository.findByCPF(clientCpf).get();
            owner.addPet(pet);
            clientRepository.update(owner);
            petRepository.save(pet);
        }
        throw new IllegalArgumentException("Cliente não encontrado com o CPF fornecido.");
    }
}
