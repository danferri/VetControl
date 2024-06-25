package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.view.AddPetView;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.pet.AddPetUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class AddPetUIController {

    @FXML private TextField txtName;
    @FXML private TextField txtBreed;
    @FXML private TextField txtSpecies;
    @FXML private ComboBox<Client> cbClient;
    //@FXML private TextField txtStatus;

    private AddPetView addPetView;
    private AddPetUseCase addPetUseCase;

    private final PetRepository petRepository = new PetPersistence();
    private final ClientRepository clientRepository = new ClientPersistence();


    public void init(AddPetView addPetView) {
        this.addPetView = addPetView;
        this.addPetUseCase = new AddPetUseCase(petRepository);

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

    }

    public void saveOrUpdate(ActionEvent actionEvent) {
        String name = txtName.getText();
        String breed = txtBreed.getText();
        String species = txtSpecies.getText();
        Client client = cbClient.getValue();
        //String status = txtStatus.getText().getStatus().toString();

        try {
            boolean retorno = addPetUseCase.cadastrarPet(name, breed, species, client);
            if (retorno) {
                if (addPetView != null) {
                    alertSuccessCadastro();
                    addPetView.close();
                }
            } else {
                alertFailCadastro();
            }
        } catch (IllegalArgumentException e) {
            alertException(e);
        }
    }

    private void alertSuccessCadastro() {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( "Cadastro realizado com sucesso!" );
        alert.setHeaderText( "Cadastro realizado com sucesso!" );
        alert.setContentText( "Cadastro realizado com sucesso! :)" );

        alert.showAndWait();
    }

    private void alertFailCadastro() {
        Alert alert = new Alert( Alert.AlertType.ERROR );
        alert.setTitle( "Erro no Cadastro" );
        alert.setHeaderText( "Erro" );
        alert.setContentText( "Erro no cadastro :(" );

        alert.showAndWait();
    }

    private void alertException(Exception e) {
        Alert alert = new Alert( Alert.AlertType.ERROR );
        alert.setTitle( "Erro no Cadastro" );
        alert.setHeaderText( "Erro" );
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if (addPetView != null) {
            addPetView.close();
        }
    }

}

