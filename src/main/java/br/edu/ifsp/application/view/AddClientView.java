package br.edu.ifsp.application.view;


import br.edu.ifsp.application.controller.AddClientUIController;
import br.edu.ifsp.application.persistence.ClientPersistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddClientView {
    private Stage stage;
    private ClientPersistence clientPersistence;

    public AddClientView(ClientPersistence clientPersistence) {
        this.stage = new Stage();
        this.clientPersistence = clientPersistence;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/AddClientUI.fxml"));
            Parent root = loader.load();

            AddClientUIController controller = loader.getController();
            controller.init(this, clientPersistence);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Veterinário");
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
