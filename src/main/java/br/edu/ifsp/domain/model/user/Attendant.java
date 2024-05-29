package br.edu.ifsp.domain.model.user;

public class Attendant implements User {
    private String login;

    public Attendant(String login) {
        this.login = login;
    }

    @Override
    public boolean authenticateUser() {
        return false;
    }

    @Override
    public boolean accessLevel() {
        return false;
    }
}
