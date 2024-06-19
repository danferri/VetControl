package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.view.AddPetView;
import br.edu.ifsp.domain.usecases.pet.AddPetUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddPetUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtBreed;
    //@FXML private TextField txtId;
    @FXML private TextField txtSpecies;
    //@FXML private TextField txtOwner;
    //@FXML private TextField txtStatus;

    private AddPetView addPetView;
    private AddPetUseCase addPetUseCase;

    public void init(AddPetView addPetView, PetPersistence petPersistence) {
        this.addPetView = addPetView;
        this.addPetUseCase = new AddPetUseCase(petPersistence);

    }

    public void saveOrUpdate(ActionEvent actionEvent) {
        String name = txtName.getText();
        String breed = txtBreed.getText();
        //int id = Integer.parseInt(txtId.getId());
        String species = txtSpecies.getText();
        //String owner = txtOwner.getText().getOwner().toString();
        //String status = txtStatus.getText().getStatus().toString();

        try {
            boolean retorno = addPetUseCase.cadastrarPet(name, breed, species);
            if (retorno) {
                if (addPetView != null) {
                    alertSuccessCadastro();
                    addPetView.close();
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
        alert.setContentText( "Erro no cadastro :(" );

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
        if (addPetView != null) {
            addPetView.close();
        }
    }

}

