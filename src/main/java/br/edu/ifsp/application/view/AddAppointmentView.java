package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.AddAppointmentUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAppointmentView {

    private Stage stage;

    public AddAppointmentView() {
        this.stage = new Stage();
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/AddAppointmentUI.fxml"));
            Parent root = loader.load();

            AddAppointmentUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Consulta");
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

