package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.UpdateAppointmentView;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.appointment.UpdateAppointmentUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UpdateAppointmentUIController {
    @FXML private DatePicker dpDate;
    @FXML private TextField txtTime;
    @FXML private TextField txtDescription;
    @FXML private ComboBox<Veterinarian> cbVeterinarian;
    @FXML private ComboBox<Pet> cbPet;

    private UpdateAppointmentView updateAppointmentView;
    private UpdateAppointmentUseCase updateAppointmentUseCase;
    private Appointment currentAppointment;
    private VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
    private PetRepository petRepository = new PetPersistence();


    public void init(UpdateAppointmentView updateAppointmentView, UpdateAppointmentUseCase updateAppointmentUseCase, Appointment appointment) {
        this.updateAppointmentView = updateAppointmentView;
        this.updateAppointmentUseCase = updateAppointmentUseCase;
        this.currentAppointment = appointment;

        ObservableList<Veterinarian> veterinarians = FXCollections.observableArrayList(veterinarianRepository.findAll());

        cbVeterinarian.setItems(veterinarians);

        cbVeterinarian.setConverter(new StringConverter<Veterinarian>() {
            @Override
            public String toString(Veterinarian veterinarian) {
                return veterinarian != null ? veterinarian.getName() : "";
            }

            @Override
            public Veterinarian fromString(String s) {
                return null;
            }
        });

        cbVeterinarian.getSelectionModel().select(currentAppointment.getVeterinarian());

        ObservableList<Pet> pets = FXCollections.observableArrayList(petRepository.findAll());

        cbPet.setItems(pets);

        cbPet.setConverter(new StringConverter<Pet>() {
            @Override
            public String toString(Pet pet) {
                return pet != null ? pet.getName() : "";
            }

            @Override
            public Pet fromString(String s) {
                return null;
            }
        });

        cbPet.getSelectionModel().select(currentAppointment.getPet());



        loadData();
    }

    private void loadData() {
        dpDate.setValue(currentAppointment.getDate());
        txtTime.setText(currentAppointment.getHour().format(DateTimeFormatter.ofPattern("HH:mm")));
        txtDescription.setText(currentAppointment.getDescription());
        cbVeterinarian.setValue(currentAppointment.getVeterinarian());
        cbPet.setValue(currentAppointment.getPet());
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        try {
            updateAppointmentUseCase.alterarConsulta(
                    currentAppointment.getId(),
                    dpDate.getValue(),
                    LocalTime.parse(txtTime.getText()),
                    txtDescription.getText(),
                    cbVeterinarian.getSelectionModel().getSelectedItem(),
                    cbPet.getSelectionModel().getSelectedItem()
            );
            updateAppointmentView.showSuccess();
            updateAppointmentView.close();
        } catch (IllegalArgumentException e) {
            updateAppointmentView.showError(e.getMessage());
        }
    }

    @FXML
    private void backToPreviousScene(ActionEvent event) {
        updateAppointmentView.close();
    }
}

