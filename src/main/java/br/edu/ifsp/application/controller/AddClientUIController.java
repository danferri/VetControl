package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.view.AddClientView;
import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.usecases.client.AddClientUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddClientUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtCPF;


    private AddClientView addClientView;
    private AddClientUseCase addClientUseCase;

    public void init(AddClientView addClientView, ClientPersistence clientPersistence) {
        this.addClientView = addClientView;
        this.addClientUseCase = new AddClientUseCase(clientPersistence);
    }

    public void saveOrUpdate(ActionEvent actionEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String textCpf = txtCPF.getText();

        CPF cpf = new CPF(textCpf);

        try {
            boolean retorno = addClientUseCase.cadastrarCliente(name, address, cpf);
            if (retorno) {
                if (addClientView != null) {
                    alertSuccessCadastro();
                    addClientView.close();
                }
            } else {
                alertFailCadastro();
            }
        } catch (IllegalArgumentException e) {
            alertException(e);
        }
    }

    private void alertSuccessCadastro() {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( "Cadastro realizado com sucesso!" );
        alert.setHeaderText( "Cadastro realizado com sucesso!" );
        alert.setContentText( "Cadastro realizado com sucesso! :)" );

        alert.showAndWait();
    }

    private void alertFailCadastro() {
        Alert alert = new Alert( Alert.AlertType.ERROR );
        alert.setTitle( "Erro no Cadastro" );
        alert.setHeaderText( "Erro" );
        alert.setContentText( "Erro :(" );

        alert.showAndWait();
    }

    private void alertException(Exception e) {
        Alert alert = new Alert( Alert.AlertType.ERROR );
        alert.setTitle( "Erro no Cadastro" );
        alert.setHeaderText( "Erro" );
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if (addClientView != null) {
            addClientView.close();
        }
    }


    public void addPet(ActionEvent actionEvent) {
    }
}
