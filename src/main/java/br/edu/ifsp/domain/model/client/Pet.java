package br.edu.ifsp.domain.model.client;

public class Pet {
    private int id;
    private String name;
    private String breed;
    private String species;
    private Client owner;
    private PetStatus status = PetStatus.ACTIVE;

    public Pet(int id, String name, String breed, String species, Client owner,PetStatus status) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.species = species;
        this.owner = owner;
        this.status = status;
    }

    public Pet(String name, String breed, String species, Client owner) {
        this.name = name;
        this.breed = breed;
        this.species = species;
        this.owner = owner;
    }

    public Pet(int id, String name, String breed, String species) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.species = species;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Pet(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Client getOwner() {
        return owner;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }

    public PetStatus getStatus() {
        return status;
    }

    public String getStatusString() {
        return status.getStatus();
    }


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed +
                '}';
    }


}
