package br.edu.ifsp.application.view;




import br.edu.ifsp.application.controller.CreateRecordUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateRecordView {

    private Stage stage;
    private String currentDescription;
    private TextField descriptionTextField;

    public CreateRecordView(String currentDescription, TextField descriptionTextField) {
        this.stage = new Stage();
        this.currentDescription = currentDescription;
        this.descriptionTextField = descriptionTextField;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/CreateRecordUI.fxml"));
            Parent root = loader.load();

            CreateRecordUIController controller = loader.getController();
            controller.init(this, currentDescription, descriptionTextField);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Registro");
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

