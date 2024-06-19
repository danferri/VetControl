package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.AddPetUIController;
import br.edu.ifsp.application.persistence.PetPersistence;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class AddPetView {
    private Stage stage;
    private PetPersistence petPersistence;

    public AddPetView(PetPersistence petPersistence) {
        this.stage = new Stage();
        this.petPersistence = petPersistence;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/AddPetUI.fxml"));
            Parent root = loader.load();

            AddPetUIController controller = loader.getController();
            controller.init(this, petPersistence);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Pet");
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

