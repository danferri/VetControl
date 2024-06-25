package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddAppointmentView;
import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyStringWrapper;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.view.ManageAppointmentView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class ManageAppointmentUIController {
    public static ObservableList<Appointment> appointments;

    private final AppointmentRepository appointmentRepository = new AppointmentPersistence();
    private ManageAppointmentView manageAppointmentView;

    @FXML TableView<Appointment> tableAppointment;
    @FXML TableColumn<Appointment, String> colId;
    @FXML TableColumn<Appointment, String> colDate;
    @FXML TableColumn<Appointment, String> colHour;
    @FXML TableColumn<Appointment, String> colDescription;
    @FXML TableColumn<Appointment, String> colVeterinarian;
    @FXML TableColumn<Appointment, String> colPet;
    @FXML TableColumn<Appointment, String> colStatus;
    @FXML TableColumn<Appointment, String> colCost;
    @FXML private TextField txtSearch;

    public void init(ManageAppointmentView manageAppointmentView) {
        this.manageAppointmentView = manageAppointmentView;

        setupColumns();
        insertData();
        loadData(this.appointmentRepository.findAll());
    }

    @FXML
    private void addAppointmentButton(ActionEvent actionEvent) {
        AddAppointmentView addAppointmentView = new AddAppointmentView();
        addAppointmentView.showAndWait();

        loadData(this.appointmentRepository.findAll());
    }

    private void setupColumns() {
        colId.setCellValueFactory(data -> new ReadOnlyStringWrapper(String.valueOf(data.getValue().getId())));
        colDate.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDate().toString()));
        colHour.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getHour().toString()));
        colDescription.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDescription()));
        colVeterinarian.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getVeterinarian().getName()));
        colPet.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getPet().getName()));
        colStatus.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getStatus().toString()));
        colCost.setCellValueFactory(data -> new ReadOnlyStringWrapper(String.format("%.2f", data.getValue().getCost())));
    }

    private void insertData() {
        appointments = FXCollections.observableArrayList();

        tableAppointment.setItems(appointments);
    }

    private void loadData( List<Appointment> appointmentList) {
        appointments.clear();
        appointments.addAll(appointmentList);

        tableAppointment.refresh();
    }

    public void localizar() {
        String nome = txtSearch.getText();
        List<Appointment> appointments = new ArrayList<>();

        for(Appointment appointment : this.appointmentRepository.findAll()) {
            if(appointment.getPet().getName().contains(nome) ||
                    appointment.getVeterinarian().getName().contains(nome)){
                appointments.add(appointment);
            }
        }
        loadData(appointments);
    }

    @FXML
    public void close() {
        manageAppointmentView.close();
    }

    public void cancelAppointment(ActionEvent actionEvent) {

    }
}

