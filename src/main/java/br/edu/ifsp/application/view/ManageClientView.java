package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.ManageClientUIController;
import br.edu.ifsp.application.controller.ManageVeterinarianUIController;
import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageClientView {
    private Stage stage;

    public ManageClientView() {
        this.stage = new Stage();
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ManageClientUI.fxml"));
            Parent root = loader.load();

            ManageClientUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Gerenciamento de Cliente");
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
