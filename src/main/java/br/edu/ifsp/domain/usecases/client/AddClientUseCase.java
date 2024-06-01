package br.edu.ifsp.domain.usecases.client;

//CDU006

import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientFactory;
import br.edu.ifsp.domain.model.client.ClientRepository;

public class AddClientUseCase {
    ClientRepository clientRepository;
    public AddClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public void cadastrarCliente(String nome, String endereco, CPF cpf) {
        Client client = ClientFactory.createClient(nome, endereco, cpf);
        clientRepository.save(client);
    }
}
