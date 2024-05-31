package br.edu.ifsp.domain.model.client;

public class Pet {
    private String name;
    private String breed;
    private String species;
    private Client tutor;

    public Pet( String name, String breed, String species, Client tutor) {
        this.name = name;
        this.breed = breed;
        this.tutor = tutor;
        this.species = species;
    }
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", breed='" + breed+ '\'' +
                ", species='" + species + '\'' +
                ", tutor='" + tutor + '\'' +
                '}';
    }

}
