package br.edu.ifsp.domain.usecases.client;

import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class ClientValidator extends Validator<Client> {

    @Override
    public Notification validate(Client client) {
        Notification notification = new Notification();

        if(client == null) {
            notification.addError("Client is null");
            return notification;
        }
        if(nullOrEmpty(client.getName()))
            notification.addError("Client name is null or empty");
        if(nullOrEmpty(client.getAddress()))
            notification.addError("Client address is null or empty");
        if(nullOrEmpty(client.getCpf()))
            notification.addError("Client CPF is null or empty");

        return notification;
    }
}
