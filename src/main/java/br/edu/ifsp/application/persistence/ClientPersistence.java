package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientPersistence implements ClientRepository {
    private static List<Client> clients = new ArrayList<>();

    @Override
    public boolean save(Client cliente) {
        clients.add(cliente);
        return true;
    }

    @Override
    public Client findByCPF(CPF cpf) {
        Optional<Client> cliente = clients.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
        return cliente.orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    @Override
    public void update(Client client) {

    }
}
