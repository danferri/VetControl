package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.ManageAppointmentUIController;
import br.edu.ifsp.application.persistence.AppointmentPersistence;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class ManageAppointmentView {

    private Stage stage;
    private AppointmentPersistence appointmentPersistence;

    public ManageAppointmentView(AppointmentPersistence appointmentPersistence) {
        this.stage = new Stage();
        this.appointmentPersistence = appointmentPersistence;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ManageAppointmentUI.fxml"));
            Parent root = loader.load();

            ManageAppointmentUIController controller = loader.getController();
            controller.init(this, appointmentPersistence);

            Scene scene = new Scene(root);
            stage.setTitle("Gerenciamento de Consultas");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        stage.close();
    }
}

