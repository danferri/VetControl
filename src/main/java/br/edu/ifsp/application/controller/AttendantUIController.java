package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.AttendantView;
import br.edu.ifsp.application.view.VeterinarianView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.net.URL;

public class AttendantUIController {
    private AttendantView attendantView;


    @FXML
    public void ManageVeterinarians(ActionEvent actionEvent) {
        VeterinarianView veterinarianView = new VeterinarianView();
        veterinarianView.show();
    }

    @FXML
    public void ManageClients(ActionEvent actionEvent) {

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
