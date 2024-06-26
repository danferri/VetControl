package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.CreateReportUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateReportView {

    private Stage stage;

    public CreateReportView() {
        this.stage = new Stage();
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/CreateReportUI.fxml"));
            Parent root = loader.load();

            CreateReportUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Geração de Relatório");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return this.stage;
    }

    public void close() {
        stage.close();
    }
}
