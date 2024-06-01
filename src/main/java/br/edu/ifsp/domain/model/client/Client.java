package br.edu.ifsp.domain.model.client;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String address;
    private CPF cpf;
    private List<Pet> pets;

    public Client(String name, String address, CPF cpf) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.pets = new ArrayList<>();
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

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cpf=" + cpf +
                ", pets=" + pets.size() +
                '}';
    }
}