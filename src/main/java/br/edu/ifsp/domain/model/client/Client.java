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

    public CPF getCpf() {
        return this.cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
