package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.UpdateAppointmentUIController;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.usecases.appointment.UpdateAppointmentUseCase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UpdateAppointmentView {
    private Stage stage;
    private UpdateAppointmentUseCase updateAppointmentUseCase;

    public UpdateAppointmentView(UpdateAppointmentUseCase updateAppointmentUseCase) {
        this.updateAppointmentUseCase = updateAppointmentUseCase;
        this.stage = new Stage();
    }

    public void showAndWait(Appointment appointment) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/UpdateAppointmentUI.fxml"));
            Parent root = loader.load();
            UpdateAppointmentUIController controller = loader.getController();
            controller.init(this, updateAppointmentUseCase, appointment);

            Scene scene = new Scene(root);
            stage.setTitle("Atualizar Consulta");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSuccess() {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Atualização bem-sucedida");
        successAlert.setHeaderText(null); // Sem cabeçalho
        successAlert.setContentText("Os dados da consulta foram atualizados com sucesso!");
        successAlert.showAndWait();
    }

    public void showError(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erro na Atualização");
        errorAlert.setHeaderText("Falha ao atualizar os dados da consulta");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    public void close() {
        stage.close();
    }
}

