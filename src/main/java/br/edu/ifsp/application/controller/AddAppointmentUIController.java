package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddAppointmentView;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.appointment.AddAppointmentUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;


public class AddAppointmentUIController {
    @FXML private DatePicker dpDate;
    @FXML private TextField txtHour;
    @FXML private TextField txtDescription;
    //@FXML private TextField txtVeterinarian;
    //@FXML private TextField txtPet;
    @FXML private ComboBox<Veterinarian> cbVeterinarian;
    @FXML private ComboBox<Pet> cbPet;
    @FXML private TextField txtCost;

    private AddAppointmentView addAppointmentView;
    private AddAppointmentUseCase addAppointmentUseCase;

    public void init(AddAppointmentView addAppointmentView, AppointmentPersistence appointmentPersistence, VeterinarianPersistence veterinarianPersistence, PetPersistence petPersistence) {
        this.addAppointmentView = addAppointmentView;
        this.addAppointmentUseCase = new AddAppointmentUseCase(appointmentPersistence);

        ObservableList<Veterinarian> veterinarians = FXCollections.observableArrayList(veterinarianPersistence.findAll());
        ObservableList<Pet> pets = FXCollections.observableArrayList(petPersistence.findAll());

        //debug
        System.out.println("Veterinarians: " + veterinarians.size());
        System.out.println("Pets: " + pets.size());

        cbVeterinarian.setItems(veterinarians);
        cbPet.setItems(pets);
    }

    public void saveOrUpdate(ActionEvent actionEvent) {
        LocalDate date = dpDate.getValue();
        String hour = txtHour.getText();
        String description = txtDescription.getText();
        Veterinarian veterinarian = cbVeterinarian.getValue();
        Pet pet = cbPet.getValue();
        double cost = Double.parseDouble(txtCost.getText());

        try {
            boolean result = addAppointmentUseCase.cadastrarConsulta(date, LocalTime.parse(hour), description, veterinarian, pet, cost);
            if (result) {
                alertSuccessCadastro();
                addAppointmentView.close();
            } else {
                alertFailCadastro();
            }
        } catch (Exception e) {
            alertException(e);
        }
    }

    private void alertSuccessCadastro() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro realizado com sucesso!");
        alert.setHeaderText(null);
        alert.setContentText("A consulta foi cadastrada com sucesso!");

        alert.showAndWait();
    }

    private void alertFailCadastro() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Falha no Cadastro");
        alert.setContentText("Não foi possível cadastrar a consulta.");

        alert.showAndWait();
    }

    private void alertException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Erro");
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if (addAppointmentView != null) {
            addAppointmentView.close();
        }
    }
}

