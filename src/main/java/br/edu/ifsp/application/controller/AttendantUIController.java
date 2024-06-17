package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AttendantView;
import br.edu.ifsp.application.view.ClientView;
import br.edu.ifsp.application.view.AddVeterinarianView;
import br.edu.ifsp.application.view.ManageVeterinarianView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AttendantUIController {
    private AttendantView attendantView;
    private VeterinarianPersistence veterinarianPersistence = new VeterinarianPersistence();

    @FXML
    public void ManageVeterinarians(ActionEvent actionEvent) {
        ManageVeterinarianView manageVeterinarianView = new ManageVeterinarianView(veterinarianPersistence);
        manageVeterinarianView.showAndWait();
    }

    @FXML
    public void ManageClients(ActionEvent actionEvent) {
        ClientView clientView = new ClientView();
        clientView.showAnWait();
    }

    public void ManageAnimals(ActionEvent actionEvent) {
    }

    public void ManageAppointments(ActionEvent actionEvent) {
    }

    public void GenerateReports(ActionEvent actionEvent) {
    }

    public void ManagePayments(ActionEvent actionEvent) {
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void init(AttendantView attendantView) {
        this.attendantView = attendantView;
    }


}
