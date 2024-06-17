package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.VeterinarianView;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.usecases.veterinarian.AddVeterinarianUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class VeterinarianUIController {

    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtSpecialty;
    @FXML private TextField txtCRMV;
    @FXML private TextField txtContact;
    @FXML private TextField txtPhone;

    private VeterinarianView veterinarianView;
    private AddVeterinarianUseCase addVeterinarianUseCase;

    public VeterinarianUIController() {
        this.addVeterinarianUseCase = new AddVeterinarianUseCase(new VeterinarianPersistence());
    }

    public void init(VeterinarianView veterinarianView) {
        this.veterinarianView = veterinarianView;
    }


    public void saveOrUpdate(ActionEvent actionEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String specialty = txtSpecialty.getText();
        String crmv = txtCRMV.getText();
        String contact = txtContact.getText();
        String phone = txtPhone.getText();

        addVeterinarianUseCase.cadastrarVeterinario(name, address, specialty, phone, null, contact);

        // Suponha que os dados são salvos corretamente, então fechamos a janela
        if (veterinarianView != null) {
            veterinarianView.close();
        }
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if (veterinarianView != null) {
            veterinarianView.close();
        }
    }
}





