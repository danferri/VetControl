package br.edu.ifsp.domain.usecases.client;

//CDU008

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class FindClientUseCase {
    ClientRepository clientRepository;

    public FindClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client FindClientByCPF(CPF cpf) {

        if(clientRepository.findByCPF(cpf).isPresent())
            return clientRepository.findByCPF(cpf).get();
        throw new EntityNotFoundException("CPF não encontrado.");
    }

}
