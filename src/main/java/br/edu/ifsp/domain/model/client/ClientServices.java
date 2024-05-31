package br.edu.ifsp.domain.model.client;

public class ClientServices {

    private ClientRepository clienteRepository;

    public ClientServices(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(String nome, String endereco, String cpf) {
        Client cliente = ClientFactory.createClient(nome, endereco, cpf);
        clienteRepository.save(cliente);
    }

    public Client buscarClientePorCPF(String cpf) {
        return clienteRepository.findByCPF(new CPF(cpf));
    }
}
