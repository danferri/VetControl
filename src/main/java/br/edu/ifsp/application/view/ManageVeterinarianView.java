package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.AddVeterinarianUIController;
import br.edu.ifsp.application.controller.ManageVeterinarianUIController;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.veterinarian.UpdateVeterinarianUseCase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageVeterinarianView {

    private Stage stage;

    public ManageVeterinarianView() {
        this.stage = new Stage();
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ManageVeterinarianUI.fxml"));
            Parent root = loader.load();

            ManageVeterinarianUIController controller = loader.getController();
            controller.init(this);

            Scene scene = new Scene(root);
            stage.setTitle("Gerenciamento de Veterinário");
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

