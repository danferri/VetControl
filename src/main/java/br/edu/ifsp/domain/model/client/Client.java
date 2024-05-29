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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
}
