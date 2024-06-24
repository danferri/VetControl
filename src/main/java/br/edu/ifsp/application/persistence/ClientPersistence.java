package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientPersistence implements ClientRepository {
    private List<Client> clients = new ArrayList<>();
    @Override
    public boolean save(Client cliente) {
        clients.add(cliente);
        return true;
    }

    @Override
    public Optional<Client> findByCPF(CPF cpf) {
        return clients.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    @Override
    public void update(Client client) {

    }
}
