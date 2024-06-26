package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.view.AddPetView;
import br.edu.ifsp.application.view.ManagePetView;
import br.edu.ifsp.application.view.UpdatePetView;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.usecases.pet.DeactivatePetUseCase;
import br.edu.ifsp.domain.usecases.pet.UpdatePetUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class ManagePetUIController {
    public static ObservableList<Pet> pets;
    private final PetRepository petRepository = new PetPersistence();
    private ManagePetView managePetView;
    private UpdatePetView updatePetView;

    @FXML TableView<Pet> tablePet;
    @FXML TableColumn<Pet, String> colId;
    @FXML TableColumn<Pet, String> colName;
    @FXML TableColumn<Pet, String> colBreed;
    @FXML TableColumn<Pet, String> colSpecies;
    @FXML TableColumn<Pet, String> colClient;
    @FXML TableColumn<Pet, String> colStatus;
    @FXML private TextField txtSearch;

    public void init(ManagePetView managePetView) {
        this.managePetView = managePetView;

        setupColumns();
        insertData();
        loadData(this.petRepository.findAll());
    }

    @FXML
    private void addPetButton(ActionEvent actionEvent) {
        AddPetView addPetView = new AddPetView();
        addPetView.showAndWait();

        loadData(this.petRepository.findAll());
    }

    private void setupColumns() {
        colId.setCellValueFactory(data -> new ReadOnlyStringWrapper(String.valueOf(data.getValue().getId())));
        colName.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        colBreed.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getBreed()));
        colSpecies.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getSpecies()));
        colClient.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getOwner().getName()));
        colStatus.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getStatusString()));
    }

    private void insertData() {
        pets = FXCollections.observableArrayList();
        tablePet.setItems(pets);
    }

    private void loadData(  List<Pet> petList) {
        pets.clear();
        pets.addAll(petList);
        tablePet.refresh();
    }

    public void localizar() {
        String nome = txtSearch.getText();
        List<Pet> pets = new ArrayList<>();

        for(Pet pet : this.petRepository.findAll()) {
            if(pet.getName().contains(nome)){
                pets.add(pet);
            }
        }
        loadData(pets);
    }


    @FXML
    public void close() {
        managePetView.close();
    }

    public void deactivate(ActionEvent actionEvent) {
        Pet selectedPet = tablePet.getSelectionModel().getSelectedItem();
        if(selectedPet != null) {
            DeactivatePetUseCase deactivatePetUseCase = new DeactivatePetUseCase(petRepository);
            deactivatePetUseCase.inativarPet(selectedPet.getId());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Pet");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um pet para desativá-lo.");
            alert.showAndWait();
        }

        loadData(this.petRepository.findAll());
    }

    public void editPet(ActionEvent actionEvent) {
        Pet selectedPet = tablePet.getSelectionModel().getSelectedItem();
        if (selectedPet != null) {
            if (updatePetView == null) {
                updatePetView = new UpdatePetView(new UpdatePetUseCase(petRepository));
            }
            updatePetView.showAndWait(selectedPet);
            loadData(this.petRepository.findAll());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Animal");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um animal para editar.");
            alert.showAndWait();
        }
    }

}
