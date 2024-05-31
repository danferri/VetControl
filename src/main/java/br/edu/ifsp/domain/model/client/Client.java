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

    public CPF getCpf (){
        return this.cpf;
    }
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
