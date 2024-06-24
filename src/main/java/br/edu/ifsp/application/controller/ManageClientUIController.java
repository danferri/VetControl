package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.view.AddClientView;
import br.edu.ifsp.application.view.ManageClientView;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageClientUIController {
    public static ObservableList<Client> clients;
    private final ClientRepository clientRepository = new ClientPersistence();

    private ManageClientView manageClientView;

    @FXML TableView<Client> tableClient;
    @FXML TableColumn<Client, String> colNome;
    @FXML TableColumn<Client, String> colAddress;
    @FXML TableColumn<Client, String> colCPF;

    public void init(ManageClientView manageClientView) {
        this.manageClientView = manageClientView;

        setupColumns();
        insertData();
        loadData();
    }

    @FXML
    private void addClientButton(ActionEvent actionEvent) {
        AddClientView addClientView = new AddClientView();
        addClientView.showAndWait();

        loadData();
    }

    private void setupColumns() {
        colNome.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        colAddress.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getAddress()));
        colCPF.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getCpf().toString()));
    }

    private void insertData() {
        clients = FXCollections.observableArrayList();

        tableClient.setItems(clients);
    }

    private void loadData() {
        clients.clear();
        clients.addAll(this.clientRepository.findAll());

        tableClient.refresh();
    }

    @FXML
    public void close() {
        manageClientView.close();
    }

    @FXML
    public void showClient(ActionEvent actionEvent) {
        Client selectedClient = tableClient.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            Alert detailsAlert = new Alert(Alert.AlertType.INFORMATION);
            detailsAlert.setTitle("Detalhes do Cliente");
            detailsAlert.setHeaderText("Informações do Cliente");
            String content = String.format("Nome: %s\nEndereço: %s\nCPF: %s",
                    selectedClient.getName(),
                    selectedClient.getAddress(),
                    selectedClient.getCpf());
            detailsAlert.setContentText(content);
            detailsAlert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Cliente");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um cliente para ver os detalhes.");
            alert.showAndWait();
        }
    }
}
