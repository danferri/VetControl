package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddVeterinarianView;
import br.edu.ifsp.application.view.ManageVeterinarianView;
import br.edu.ifsp.application.view.UpdateVeterinarianView;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.veterinarian.DeactivateVeterinarianUseCase;
import br.edu.ifsp.domain.usecases.veterinarian.UpdateVeterinarianUseCase;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageVeterinarianUIController {
    public static ObservableList<Veterinarian> veterinarians;
    private VeterinarianPersistence veterinarianPersistence;
    private ManageVeterinarianView manageVeterinarianView;
    private UpdateVeterinarianView updateVeterinarianView;

    @FXML TableView<Veterinarian> tableVeterinarian;
    @FXML TableColumn<Veterinarian, String> colNome;
    @FXML TableColumn<Veterinarian, String> colAddress;
    @FXML TableColumn<Veterinarian, String> colSpecialty;
    @FXML TableColumn<Veterinarian, String> colCRMV;
    @FXML TableColumn<Veterinarian, String> colContact;
    @FXML TableColumn<Veterinarian, String> colPhone;

    @FXML private Button btnEditar;



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

    public void editVeterinarian(ActionEvent actionEvent) {
        Veterinarian selectedVeterinarian = tableVeterinarian.getSelectionModel().getSelectedItem();
        if (selectedVeterinarian != null) {
            if (updateVeterinarianView == null) {
                updateVeterinarianView = new UpdateVeterinarianView(new UpdateVeterinarianUseCase(veterinarianPersistence));
            }
            updateVeterinarianView.showAndWait(selectedVeterinarian);
            loadData();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Veterinário");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um veterinário para editar.");
            alert.showAndWait();
        }

    }

    @FXML
    public void ShowVeterinarian(ActionEvent actionEvent) {
        Veterinarian selectedVeterinarian = tableVeterinarian.getSelectionModel().getSelectedItem();
        if (selectedVeterinarian != null) {
            Alert detailsAlert = new Alert(Alert.AlertType.INFORMATION);
            detailsAlert.setTitle("Detalhes do Veterinário");
            detailsAlert.setHeaderText("Informações do Veterinário");
            String content = String.format("Nome: %s\nEndereço: %s\nEspecialidade: %s\nCRMV: %s\nContato: %s\nTelefone: %s",
                    selectedVeterinarian.getName(),
                    selectedVeterinarian.getAddress(),
                    selectedVeterinarian.getSpecialty(),
                    selectedVeterinarian.getCrmv(),
                    selectedVeterinarian.getContact(),
                    selectedVeterinarian.getPhone());
            detailsAlert.setContentText(content);
            detailsAlert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Veterinário");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um veterinário para ver os detalhes.");
            alert.showAndWait();
        }
    }
}
