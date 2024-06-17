package br.edu.ifsp.application.view;


import br.edu.ifsp.application.controller.ClientUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientView {
    private Stage stage;

    public ClientView() {
        this.stage = new Stage();
    }

    public void showAnWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ClientUI.fxml"));
            Parent root = loader.load();

            ClientUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Client");
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
