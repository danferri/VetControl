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

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialty() {
        return specialty;
    }

    public CRMV getCrmv() {
        return crmv;
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
