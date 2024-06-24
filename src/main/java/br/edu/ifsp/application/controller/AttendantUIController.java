package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.*;
import br.edu.ifsp.application.view.*;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AttendantUIController {
    private AttendantView attendantView;
    private VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
    private ClientPersistence clientPersistence = new ClientPersistence();
    private PetPersistence petPersistence = new PetPersistence();
    private AppointmentPersistence appointmentPersistence = new AppointmentPersistence();
    private PaymentPersistence paymentPersistence = new PaymentPersistence();

    @FXML
    public void ManageVeterinarians(ActionEvent actionEvent) {
        ManageVeterinarianView manageVeterinarianView = new ManageVeterinarianView(veterinarianRepository);
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
        ManageAppointmentView appointmentView = new ManageAppointmentView(appointmentPersistence);
        appointmentView.showAndWait();
    }

    public void GenerateReports(ActionEvent actionEvent) {
        
    }

    public void ManagePayments(ActionEvent actionEvent) {
        ManagePaymentView managePaymentView = new ManagePaymentView(paymentPersistence);
        managePaymentView.showAndWait();
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void init(AttendantView attendantView) {
        this.attendantView = attendantView;
    }


}
