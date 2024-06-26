package br.edu.ifsp.application.controller;



import br.edu.ifsp.application.persistence.SQLite.SQLClientPersistence;
import br.edu.ifsp.application.view.UpdatePetView;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.usecases.pet.UpdatePetUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class UpdatePetUIController {
    @FXML private TextField txtName;
    @FXML private TextField txtBreed;
    @FXML private TextField txtSpecies;
    @FXML private ComboBox<Client> cbClient;

    private UpdatePetView updatePetView;
    private UpdatePetUseCase updatePetUseCase;
    private Pet currentPet;
    private final ClientRepository clientRepository = new SQLClientPersistence();

    public void init(UpdatePetView updatePetView, UpdatePetUseCase updatePetUseCase, Pet pet) {
        this.updatePetView = updatePetView;
        this.updatePetUseCase = updatePetUseCase;
        this.currentPet = pet;

        ObservableList<Client> clients = FXCollections.observableArrayList(clientRepository.findAll());

        cbClient.setItems(clients);

        cbClient.setConverter(new StringConverter<Client>() {
            @Override
            public String toString(Client client) {
                return client != null ? client.getName() : "";
            }

            @Override
            public Client fromString(String s) {
                return null;
            }
        });

        cbClient.getSelectionModel().select(currentPet.getOwner());

        loadData();
    }

    private void loadData() {
        txtName.setText(currentPet.getName());
        txtBreed.setText(currentPet.getBreed());
        txtSpecies.setText(currentPet.getSpecies());
    }

    @FXML
    public void savechanges(ActionEvent actionEvent) {
        try {
            updatePetUseCase.alterarPet(currentPet.getId(), txtName.getText(), txtBreed.getText(), txtSpecies.getText(), cbClient.getValue());
            updatePetView.showSuccess();
            updatePetView.close();
        } catch (IllegalArgumentException e) {
            updatePetView.showError(e.getMessage());
        }

    }

    @FXML
    private void backToPreviousScene(ActionEvent event) {
        updatePetView.close();
    }


}
