package br.edu.ifsp.application.controller;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.view.AddPetView;
import br.edu.ifsp.application.view.ManagePetView;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyStringWrapper;


public class ManagePetUIController {
    public static ObservableList<Pet> pets;
    private PetRepository petRepository = new PetPersistence();
    private ManagePetView managePetView;

    @FXML TableView<Pet> tablePet;
    //@FXML TableColumn<Pet, String> colId;
    @FXML TableColumn<Pet, String> colName;
    @FXML TableColumn<Pet, String> colBreed;
    @FXML TableColumn<Pet, String> colSpecies;

    public void init(ManagePetView managePetView) {
        this.managePetView = managePetView;

        setupColumns();
        insertData();
        loadData();
    }

    @FXML
    private void addPetButton(ActionEvent actionEvent) {
        AddPetView addPetView = new AddPetView();
        addPetView.showAndWait();

        loadData();
    }

    private void setupColumns() {
        //colId.setCellValueFactory(data -> new ReadOnlyStringWrapper(String.valueOf(data.getValue().getId())));
        colName.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        colBreed.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getBreed()));
        colSpecies.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getSpecies()));
    }

    private void insertData() {
        pets = FXCollections.observableArrayList();
        tablePet.setItems(pets);
    }

    private void loadData() {
        pets.clear();
        pets.addAll(this.petRepository.findAll());
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
