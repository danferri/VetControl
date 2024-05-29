package br.edu.ifsp.domain.model.user;

public class Veterinarian implements User {
    private String login;
    private String name;
    private String address;
    private String specialty;
    private String contact;
    private CRMV crmv;

    public Veterinarian(String login, String name, String address, String specialty, String contact, CRMV crmv) {
        this.login = login;
        this.name = name;
        this.address = address;
        this.specialty = specialty;
        this.contact = contact;
        this.crmv = crmv;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean authenticateUser() {
        return false;
    }

    @Override
    public boolean accessLevel() {
        return false;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", specialty='" + specialty + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
