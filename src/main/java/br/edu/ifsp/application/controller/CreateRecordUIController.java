package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.CreateRecordView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CreateRecordUIController {
    @FXML private TextField txtDescription;
    @FXML private Pane imagePane;
    private TextField txtDescriptionCreateAppointmentView;

    private String currentDescription;
    private CreateRecordView createRecordView;

    public void init(CreateRecordView createRecordView, String currentDescription, TextField txtDescriptionCreateAppointmentView) {
        this.createRecordView = createRecordView;
        this.currentDescription = currentDescription;
        this.txtDescriptionCreateAppointmentView = txtDescriptionCreateAppointmentView;
        loadData();
        addImageToPane();

    }

    private void loadData() {
        txtDescription.setText(currentDescription);
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        txtDescriptionCreateAppointmentView.setText(txtDescription.getText());
        createRecordView.close();
    }

    @FXML
    public void backToPreviousScene(ActionEvent actionEvent) {
        createRecordView.close();
    }

    private void addImageToPane() {
        Image image = new Image("/Tela_prontuario.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(227);
        imageView.setFitHeight(235);
        imagePane.getChildren().add(imageView);
    }
}
