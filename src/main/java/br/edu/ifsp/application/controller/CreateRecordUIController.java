package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.CreateRecordView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateRecordUIController {
    @FXML private TextField txtDescription;
    private TextField txtDescriptionCreateAppointmentView;

    private String currentDescription;
    private CreateRecordView createRecordView;

    public void init(CreateRecordView createRecordView, String currentDescription, TextField txtDescriptionCreateAppointmentView) {
        this.createRecordView = createRecordView;
        this.currentDescription = currentDescription;
        this.txtDescriptionCreateAppointmentView = txtDescriptionCreateAppointmentView;
        loadData();
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
}
