package br.edu.ifsp.domain.model.client;

import br.edu.ifsp.domain.usecases.client.AddClientUseCase;
import br.edu.ifsp.domain.usecases.client.FindClientUseCase;

public class ClientServices {

    private ClientRepository clienteRepository;

    public ClientServices(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void insert(String nome, String endereco, String cpf) {
        AddClientUseCase addClientUseCase = new AddClientUseCase(clienteRepository);
        addClientUseCase.cadastrarCliente(nome, endereco,cpf);
    }

    public Client FindOne(String cpf) {
        FindClientUseCase findOne = new FindClientUseCase(clienteRepository);
        return  findOne.FindClientByCPF(cpf);
    }
}
