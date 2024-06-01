package br.edu.ifsp.domain.model.client;

public class ClientFactory {
    public static Client createClient(String nome, String address, CPF cpf) {
        return new Client(nome, address, cpf);
    }
}


