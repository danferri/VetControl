package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddVeterinarianView;
import br.edu.ifsp.application.view.ManageVeterinarianView;
import br.edu.ifsp.domain.model.user.Veterinarian;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageVeterinarianUIController {
    public static ObservableList<Veterinarian> veterinarians;
    private VeterinarianPersistence veterinarianPersistence;
    private ManageVeterinarianView manageVeterinarianView;

    @FXML TableView<Veterinarian> tableVeterinarian;
    @FXML TableColumn<Veterinarian, String> colNome;

    public void init(ManageVeterinarianView manageVeterinarianView, VeterinarianPersistence veterinarianPersistence) {
        this.manageVeterinarianView = manageVeterinarianView;
        this.veterinarianPersistence = veterinarianPersistence;

        setupCollumns();
        insertData();
        loadData();
    }

    @FXML
    private void addVeterinarianButton(ActionEvent actionEvent) {
        AddVeterinarianView addVeterinarianView = new AddVeterinarianView(veterinarianPersistence);
        addVeterinarianView.showAnWait();

        loadData();
    }

    private void setupCollumns() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("name"));
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
}
