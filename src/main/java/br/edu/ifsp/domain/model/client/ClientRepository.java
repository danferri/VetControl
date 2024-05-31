package br.edu.ifsp.domain.model.client;

import java.util.List;

public interface ClientRepository {
    void save(Client cliente);
    Client findByCPF(CPF cpf);
    List<Client> findAll();
}
