package br.edu.ifsp.domain.model.client;

public class ClientFactory {
    public static Client createClient(String nome, String address, String cpf) {
        return new Client(nome, address, new CPF(cpf));
    }
}


