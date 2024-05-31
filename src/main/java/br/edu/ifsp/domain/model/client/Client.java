package br.edu.ifsp.domain.model.client;

public class Client {
    private String name;
    private String address;
    private CPF cpf;

    public Client(String name, String address, CPF cpf) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
    }

}
