package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.AddVeterinarianUIController;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddVeterinarianView {

    private Stage stage;
    private VeterinarianPersistence veterinarianPersistence;

    public AddVeterinarianView(VeterinarianPersistence veterinarianPersistence) {
        this.stage = new Stage();
        this.veterinarianPersistence = veterinarianPersistence;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/AddVeterinarianUI.fxml"));
            Parent root = loader.load();

            AddVeterinarianUIController controller = loader.getController();
            controller.init(this, veterinarianPersistence);

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

