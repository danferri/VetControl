package br.edu.ifsp.domain.usecases.client;

//CDU006

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

public class AddClientUseCase {
    private ClientRepository clientRepository;

    public AddClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean cadastrarCliente(String nome, String endereco, CPF cpf) {
        Client client = new Client (nome, endereco, cpf);
        return clientRepository.save(client);
    }
}
