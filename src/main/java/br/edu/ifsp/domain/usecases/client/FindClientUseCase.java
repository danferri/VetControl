package br.edu.ifsp.domain.usecases.client;

//CDU008

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

public class FindClientUseCase {
    ClientRepository clientRepository;

    public FindClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client FindClientByCPF(CPF cpf) {
        return clientRepository.findByCPF(cpf);
    }

}
