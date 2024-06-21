package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.UpdateVeterinarianView;
import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.veterinarian.UpdateVeterinarianUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateVeterinarianUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtSpecialty;
    @FXML private TextField txtCRMV;
    @FXML private TextField txtContact;
    @FXML private TextField txtPhone;

    private UpdateVeterinarianView updateVeterinarianView;
    private UpdateVeterinarianUseCase updateVeterinarianUseCase;
    private Veterinarian currentVeterinarian;

    public void init(UpdateVeterinarianView updateVeterinarianView, UpdateVeterinarianUseCase updateVeterinarianUseCase, Veterinarian veterinarian) {
        this.updateVeterinarianView = updateVeterinarianView;
        this.updateVeterinarianUseCase = updateVeterinarianUseCase;
        this.currentVeterinarian = veterinarian;
        loadVeterinarianData();
    }

    private void loadVeterinarianData() {
        txtName.setText(currentVeterinarian.getName());
        txtAddress.setText(currentVeterinarian.getAddress());
        txtSpecialty.setText(currentVeterinarian.getSpecialty());
        txtCRMV.setText(currentVeterinarian.getCrmv().toString());
        txtContact.setText(currentVeterinarian.getContact());
        txtPhone.setText(currentVeterinarian.getPhone());
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        try {
            updateVeterinarianUseCase.alterarVeterinario(new CRMV(txtCRMV.getText()), txtName.getText(), txtAddress.getText(), txtSpecialty.getText(), txtPhone.getText());
            updateVeterinarianView.showSuccess();
        } catch (IllegalArgumentException e) {
            updateVeterinarianView.showError(e.getMessage());
        }
    }

    @FXML
    private void backToPreviousScene(ActionEvent event) {
        updateVeterinarianView.close();
    }
}
