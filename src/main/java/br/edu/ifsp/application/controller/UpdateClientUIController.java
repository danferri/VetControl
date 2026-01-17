package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.UpdateClientView;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.usecases.client.UpdateClientUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateClientUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtCPF;

    private UpdateClientView updateClientView;
    private UpdateClientUseCase updateClientUseCase;
    private Client currentClient;

    public void init(UpdateClientView updateClientView, UpdateClientUseCase updateClientUseCase, Client client) {
        this.updateClientView = updateClientView;
        this.updateClientUseCase = updateClientUseCase;
        this.currentClient = client;
        loadClientData();
    }

    private void loadClientData() {
        txtName.setText(currentClient.getName());
        txtAddress.setText(currentClient.getAddress());
        txtCPF.setText(currentClient.getCpf().toString());
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        try {
            updateClientUseCase.updateClient(new CPF(txtCPF.getText()), txtName.getText(), txtAddress.getText());
            updateClientView.showSuccess();
            updateClientView.close();
        } catch (IllegalArgumentException e) {
            updateClientView.showError(e.getMessage());
        }
    }

    @FXML
    private void backToPreviousScene(ActionEvent event) {
        updateClientView.close();
    }
}

