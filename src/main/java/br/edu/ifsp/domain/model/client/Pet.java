package br.edu.ifsp.domain.model.client;

public class Pet {
    private int id;
    private String name;
    private String breed;
    private String species;
    private Client tutor;

    public Pet(int id, String name, String breed, String species, Client tutor) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.tutor = tutor;
        this.species = species;
    }


}
