package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddVeterinarianView;
import br.edu.ifsp.application.view.ManageVeterinarianView;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.veterinarian.DeactivateVeterinarianUseCase;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageVeterinarianUIController {
    public static ObservableList<Veterinarian> veterinarians;
    private VeterinarianPersistence veterinarianPersistence;
    private ManageVeterinarianView manageVeterinarianView;

    @FXML TableView<Veterinarian> tableVeterinarian;
    @FXML TableColumn<Veterinarian, String> colNome;
    @FXML TableColumn<Veterinarian, String> colAddress;
    @FXML TableColumn<Veterinarian, String> colSpecialty;
    @FXML TableColumn<Veterinarian, String> colCRMV;
    @FXML TableColumn<Veterinarian, String> colContact;
    @FXML TableColumn<Veterinarian, String> colPhone;

    public void init(ManageVeterinarianView manageVeterinarianView, VeterinarianPersistence veterinarianPersistence) {
        this.manageVeterinarianView = manageVeterinarianView;
        this.veterinarianPersistence = veterinarianPersistence;

        setupColumns();
        insertData();
        loadData();
    }

    @FXML
    private void addVeterinarianButton(ActionEvent actionEvent) {
        AddVeterinarianView addVeterinarianView = new AddVeterinarianView(veterinarianPersistence);
        addVeterinarianView.showAndWait();

        loadData();
    }

    private void setupColumns() {
        colNome.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        colAddress.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getAddress()));
        colSpecialty.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getSpecialty()));
        colCRMV.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getCrmv().toString()));
        colContact.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getContact()));
        colPhone.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getPhone()));
    }

    private void insertData() {
        veterinarians = FXCollections.observableArrayList();

        tableVeterinarian.setItems(veterinarians);
    }

    private void loadData() {
        veterinarians.clear();
        veterinarians.addAll(this.veterinarianPersistence.findAll());

        tableVeterinarian.refresh();
    }

    @FXML
    public void close() {
        manageVeterinarianView.close();
    }

    public void deactive(ActionEvent actionEvent) {
        DeactivateVeterinarianUseCase deactivateVeterinarianUseCase = new DeactivateVeterinarianUseCase(veterinarianPersistence);
        //deactivateVeterinarianUseCase.inativarVeterinario();
    }
}
