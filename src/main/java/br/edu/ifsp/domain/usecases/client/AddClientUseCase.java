package br.edu.ifsp.domain.usecases.client;

//CDU006

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class AddClientUseCase {
    private final ClientRepository clientRepository;

    public AddClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean cadastrarCliente(String nome, String endereco, CPF cpf) {
        Client client = new Client (nome, endereco, cpf);

        Validator<Client> validator = new ClientValidator();
        Notification notification = validator.validate(client);

        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.errorMessage());

        if(clientRepository.findByCPF(cpf).isPresent())
            throw new EntityAlreadyExistsException("This CPF is already in use");
        return clientRepository.save(client);
    }
}
