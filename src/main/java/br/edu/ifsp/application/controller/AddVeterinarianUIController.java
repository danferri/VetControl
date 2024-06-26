package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.SQLite.SQLVeterinarianPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddVeterinarianView;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.veterinarian.AddVeterinarianUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class AddVeterinarianUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtSpecialty;
    @FXML private TextField txtCRMV;
    @FXML private TextField txtContact;
    @FXML private TextField txtPhone;

    private AddVeterinarianView addVeterinarianView;
    private AddVeterinarianUseCase addVeterinarianUseCase;

    private final VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();

    public void init(AddVeterinarianView addVeterinarianView) {
        this.addVeterinarianView = addVeterinarianView;
        this.addVeterinarianUseCase = new AddVeterinarianUseCase(veterinarianRepository);
    }

    public void saveOrUpdate(ActionEvent actionEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String specialty = txtSpecialty.getText();
        String textCrmv = txtCRMV.getText();
        String contact = txtContact.getText();
        String phone = txtPhone.getText();

        CRMV crmv = new CRMV(textCrmv);

        try {
            boolean retorno = addVeterinarianUseCase.cadastrarVeterinario(name, address, specialty, phone, crmv, contact);
            if (retorno) {
                if (addVeterinarianView != null) {
                    alertSuccessCadastro();
                    addVeterinarianView.close();
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
        if (addVeterinarianView != null) {
            addVeterinarianView.close();
        }
    }
}





