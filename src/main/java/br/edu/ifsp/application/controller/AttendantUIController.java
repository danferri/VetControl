package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AttendantUIController {
    private AttendantView attendantView;

    @FXML
    private Pane imagePane;

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
        CreateReportView createReportView = new CreateReportView();
        createReportView.showAndWait();
    }

    public void ManagePayments(ActionEvent actionEvent) {
        ManagePaymentView managePaymentView = new ManagePaymentView();
        managePaymentView.showAndWait();
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void init(AttendantView attendantView) {
        this.attendantView = attendantView;
        addImageToPane();
    }

    private void addImageToPane() {
        Image image = new Image("/Tela_inicial.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(580);
        imageView.setFitHeight(520);
        imagePane.getChildren().add(imageView);
    }


}
