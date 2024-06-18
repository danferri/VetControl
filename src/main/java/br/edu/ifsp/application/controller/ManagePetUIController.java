package br.edu.ifsp.application.controller;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.view.ManagePetView;
import br.edu.ifsp.domain.model.client.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyStringWrapper;


public class ManagePetUIController {
    public static ObservableList<Pet> pets;
    private PetPersistence petPersistence;
    private ManagePetView managePetView;

    @FXML TableView<Pet> tablePet;
    @FXML TableColumn<Pet, String> colName;
    @FXML TableColumn<Pet, String> colBreed;

    public void init(ManagePetView managePetView, PetPersistence petPersistence) {
        this.managePetView = managePetView;
        this.petPersistence = petPersistence;

        setupColumns();
        insertData();
        loadData();
    }

    @FXML
    private void addPetButton(ActionEvent actionEvent) {
        //AddPetView addPetView = new AddPetView(petPersistence);
        //addPetView.showAndWait();

        loadData();
    }

    private void setupColumns() {
        colName.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        colBreed.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getBreed()));
    }

    private void insertData() {
        pets = FXCollections.observableArrayList();
        tablePet.setItems(pets);
    }

    private void loadData() {
        pets.clear();
        pets.addAll(this.petPersistence.findAll());
        tablePet.refresh();
    }

    @FXML
    public void close() {
        managePetView.close();
    }

    public void deactivate(ActionEvent actionEvent) {
        //DeactivatePetUseCase deactivatePetUseCase = new DeactivatePetUseCase(petPersistence);
        //deactivatePetUseCase.deactivatePet();
    }
}
