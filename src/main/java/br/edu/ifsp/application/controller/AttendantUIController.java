package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AttendantUIController {
    private AttendantView attendantView;
    private VeterinarianPersistence veterinarianPersistence = new VeterinarianPersistence();
    private ClientPersistence clientPersistence = new ClientPersistence();
    private PetPersistence petPersistence = new PetPersistence();

    @FXML
    public void ManageVeterinarians(ActionEvent actionEvent) {
        ManageVeterinarianView manageVeterinarianView = new ManageVeterinarianView(veterinarianPersistence);
        manageVeterinarianView.showAndWait();
    }

    @FXML
    public void ManageClients(ActionEvent actionEvent) {
        ManageClientView clientView = new ManageClientView(clientPersistence);
        clientView.showAndWait();
    }

    public void ManageAnimals(ActionEvent actionEvent) {
        ManagePetView petView = new ManagePetView(petPersistence);
        petView.showAndWait();
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
