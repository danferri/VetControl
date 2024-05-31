package br.edu.ifsp.domain.model.client;

public class PetFactory {
    public static Pet createAnimal(String nome, String raca, String especie, Client cliente) {
        return new Pet(nome, raca, especie, cliente);
    }
}
