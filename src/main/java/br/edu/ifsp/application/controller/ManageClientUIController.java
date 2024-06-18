package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.view.AddClientView;
import br.edu.ifsp.application.view.ManageClientView;
import br.edu.ifsp.domain.model.client.Client;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageClientUIController {
    public static ObservableList<Client> clients;
    private ClientPersistence clientPersistence;
    private ManageClientView manageClientView;

    @FXML TableView<Client> tableClient;
    @FXML TableColumn<Client, String> colNome;
    @FXML TableColumn<Client, String> colAddress;
    @FXML TableColumn<Client, String> colCPF;

    public void init(ManageClientView manageClientView, ClientPersistence clientPersistence) {
        this.manageClientView = manageClientView;
        this.clientPersistence = clientPersistence;

        setupColumns();
        insertData();
        loadData();
    }

    @FXML
    private void addClientButton(ActionEvent actionEvent) {
        AddClientView addClientView = new AddClientView(clientPersistence);
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
        clients.addAll(this.clientPersistence.findAll());

        tableClient.refresh();
    }

    @FXML
    public void close() {
        manageClientView.close();
    }
}
