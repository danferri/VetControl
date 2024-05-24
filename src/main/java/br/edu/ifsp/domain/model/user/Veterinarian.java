package br.edu.ifsp.domain.model.user;

public class Veterinarian {
    private String login;
    private String name;
    private String address;
    private String specialty;
    private String contact;

    public Veterinarian(String login, String name, String address, String specialty, String contact) {
        this.login = login;
        this.name = name;
        this.address = address;
        this.specialty = specialty;
        this.contact = contact;
    }
}
