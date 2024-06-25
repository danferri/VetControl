package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.UpdatePetUIController;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.usecases.pet.UpdatePetUseCase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UpdatePetView {
    private Stage stage;
    private UpdatePetUseCase updatePetUseCase;

    public UpdatePetView(UpdatePetUseCase updatePetUseCase) {
        this.updatePetUseCase = updatePetUseCase;
        this.stage = new Stage();
    }

    public void showAndWait(Pet pet) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/UpdatePetUI.fxml"));
            Parent root = loader.load();
            UpdatePetUIController controller = loader.getController();
            controller.init(this, updatePetUseCase, pet);

            Scene scene = new Scene(root);
            stage.setTitle("Atualizar Animal");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSuccess() {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Atualização bem-sucedida");
        successAlert.setHeaderText(null); // Sem cabeçalho
        successAlert.setContentText("Os dados do animal foram atualizados com sucesso!");
        successAlert.showAndWait();
    }

    public void showError(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erro na Atualização");
        errorAlert.setHeaderText("Falha ao atualizar os dados do animal");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    public void close() {
        stage.close();
    }
}
