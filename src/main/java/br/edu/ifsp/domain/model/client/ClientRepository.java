package br.edu.ifsp.domain.model.client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    boolean save(Client cliente);
    Optional<Client> findByCPF(CPF cpf);
    List<Client> findAll();
    void update(Client client);
}
