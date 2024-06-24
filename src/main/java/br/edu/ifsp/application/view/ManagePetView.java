package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.ManagePetUIController;
import br.edu.ifsp.application.persistence.PetPersistence;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class ManagePetView {

    private Stage stage;

    public ManagePetView() {
        this.stage = new Stage();
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ManagePetUI.fxml"));
            Parent root = loader.load();

            ManagePetUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Gerenciamento de Pets");
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

