package br.edu.ifsp.domain.model.user;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class Attendant implements User {
    private String login;

    public Attendant(String login) {
        this.login = login;
    }

    @Override
    public boolean authenticateUser() {
        return login.equals("masterCredentials");
    }

    @Override
    public boolean accessLevel() {
        return true;
    }

}
