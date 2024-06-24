package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.*;
import br.edu.ifsp.application.view.*;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AttendantUIController {
    private AttendantView attendantView;

    @FXML
    public void ManageVeterinarians(ActionEvent actionEvent) {
        ManageVeterinarianView manageVeterinarianView = new ManageVeterinarianView();
        manageVeterinarianView.showAndWait();
    }

    @FXML
    public void ManageClients(ActionEvent actionEvent) {
        ManageClientView clientView = new ManageClientView();
        clientView.showAndWait();
    }

    public void ManageAnimals(ActionEvent actionEvent) {
        ManagePetView petView = new ManagePetView();
        petView.showAndWait();
    }

    public void ManageAppointments(ActionEvent actionEvent) {
        ManageAppointmentView appointmentView = new ManageAppointmentView();
        appointmentView.showAndWait();
    }

    public void GenerateReports(ActionEvent actionEvent) {
        
    }

    public void ManagePayments(ActionEvent actionEvent) {
        ManagePaymentView managePaymentView = new ManagePaymentView();
        managePaymentView.showAndWait();
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void init(AttendantView attendantView) {
        this.attendantView = attendantView;
    }


}
