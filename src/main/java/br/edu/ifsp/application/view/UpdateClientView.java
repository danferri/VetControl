package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.UpdateClientUIController;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.usecases.client.UpdateClientUseCase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UpdateClientView {
    private Stage stage;
    private UpdateClientUseCase updateClientUseCase;

    public UpdateClientView(UpdateClientUseCase updateClientUseCase) {
        this.updateClientUseCase = updateClientUseCase;
        this.stage = new Stage();
    }

    public void showAndWait(Client client) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/UpdateClientUI.fxml"));
            Parent root = loader.load();
            UpdateClientUIController controller = loader.getController();
            controller.init(this, updateClientUseCase, client);

            Scene scene = new Scene(root);
            stage.setTitle("Atualizar Cliente");
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
        successAlert.setContentText("Os dados do cliente foram atualizados com sucesso!");
        successAlert.showAndWait();
    }

    public void showError(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erro na Atualização");
        errorAlert.setHeaderText("Falha ao atualizar os dados do cliente");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    public void close() {
        stage.close();
    }
}

