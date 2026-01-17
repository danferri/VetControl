package br.edu.ifsp.domain.model.client;

public class PetFactory {
    public static Pet createAnimal(Integer id, String nome, String raca, String especie, Client cliente, PetStatus status) {
        return new Pet( id, nome, raca, especie, cliente, status );
    }
}
