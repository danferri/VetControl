package br.edu.ifsp.domain.model.client;

import br.edu.ifsp.domain.usecases.client.AddClientUseCase;

public class ClientServices {

    private ClientRepository clienteRepository;

    public ClientServices(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void insert(String nome, String endereco, String cpf) {
        AddClientUseCase addClientUseCase = new AddClientUseCase(clienteRepository);
        addClientUseCase.cadastrarCliente(nome, endereco,cpf);
    }

    public Client buscarClientePorCPF(String cpf) {
        return clienteRepository.findByCPF(new CPF(cpf));
    }
}
