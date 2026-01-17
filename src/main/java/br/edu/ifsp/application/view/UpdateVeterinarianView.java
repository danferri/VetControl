package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.UpdateVeterinarianUIController;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.veterinarian.UpdateVeterinarianUseCase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UpdateVeterinarianView {
    private Stage stage;
    private UpdateVeterinarianUseCase updateVeterinarianUseCase;

    public UpdateVeterinarianView(UpdateVeterinarianUseCase updateVeterinarianUseCase) {
        this.updateVeterinarianUseCase = updateVeterinarianUseCase;
        this.stage = new Stage();
    }

    public void showAndWait(Veterinarian veterinarian) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/UpdateVeterinarianUI.fxml"));
            Parent root = loader.load();
            UpdateVeterinarianUIController controller = loader.getController();
            controller.init(this, updateVeterinarianUseCase, veterinarian);

            Scene scene = new Scene(root);
            stage.setTitle("Atualizar Veterinário");
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
        successAlert.setContentText("Os dados do veterinário foram atualizados com sucesso!");
        successAlert.showAndWait();
    }

    public void showError(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erro na Atualização");
        errorAlert.setHeaderText("Falha ao atualizar os dados do veterinário");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    public void close() {
        stage.close();
    }
}
