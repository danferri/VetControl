package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.CreateReportView;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.appointment.ExportAppointmentReportUseCase;
import br.edu.ifsp.domain.usecases.appointment.GenerateAppointmentReportUseCase;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateReportUIController {
    private static ObservableList<Appointment> appointments;

    @FXML private DatePicker dpInicio;
    @FXML private DatePicker dpFim;

    @FXML private ComboBox<Veterinarian> cbVet;
    @FXML private ComboBox<Pet> cbPet;

    @FXML private TableView<Appointment> tableReport;
    @FXML private TableColumn<Appointment, String> colNomeVet;
    @FXML private TableColumn<Appointment, String> colNomeClient;
    @FXML private TableColumn<Appointment, String> colNomePet;
    @FXML private TableColumn<Appointment, String> colDate;

    private CreateReportView createReportView;

    private final AppointmentRepository appointmentRepository = new AppointmentPersistence();
    private final VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
    private final PetRepository petRepository = new PetPersistence();

    public void init(CreateReportView createReportView) {
        this.createReportView = createReportView;

        setupComboboxes();
        setupColumns();
        insertData();
    }

    private void setupColumns() {
        colNomeVet.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getVeterinarian().getName()));
        colNomeClient.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getPet().getOwner().getName()));
        colNomePet.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getPet().getName()));
        colDate.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDate().toString()));
    }

    private void setupComboboxes() {
        ObservableList<Veterinarian> veterinarians = FXCollections.observableArrayList(veterinarianRepository.findAllActive());
        ObservableList<Pet> pets = FXCollections.observableArrayList(petRepository.findAll());

        cbVet.setItems(veterinarians);
        cbPet.setItems(pets);

        cbVet.setConverter(new StringConverter<Veterinarian>() {
            @Override
            public String toString(Veterinarian veterinarian) {
                return veterinarian != null ? veterinarian.getName() : "";
            }

            @Override
            public Veterinarian fromString(String s) {
                return null;
            }
        });

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
    }

    private void insertData() {
        appointments = FXCollections.observableArrayList();
        tableReport.setItems(appointments);
    }

    private void loadData(List<Appointment> appointmentList) {
        appointments.clear();
        appointments.addAll(appointmentList);
        tableReport.refresh();
    }

    public void gerarRelatorio(ActionEvent actionEvent) {
        Veterinarian veterinarian = cbVet.getValue();
        Pet pet = cbPet.getValue();
        LocalDate dataInicio = dpInicio.getValue();
        LocalDate dataFim = dpFim.getValue();

        GenerateAppointmentReportUseCase generateAppointmentReportUseCase = new GenerateAppointmentReportUseCase(appointmentRepository);
        List<Appointment> appointmentList = generateAppointmentReportUseCase.GenerateAppointment(veterinarian, pet, dataInicio, dataFim);

        loadData(appointmentList);
    }

    public void exportarRelatorio(ActionEvent actionEvent) {
        ArrayList<Appointment> appointmentList = new ArrayList<>(appointments);

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Selecionar onde salvar o arquivo.");

        File selectedDirectory = directoryChooser.showDialog(createReportView.getStage());

        ExportAppointmentReportUseCase exportAppointmentReportUseCase = new ExportAppointmentReportUseCase();
        exportAppointmentReportUseCase.exportReportPDF(appointmentList, selectedDirectory.getPath() + "ReportPDF.pdf");
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if(createReportView != null)
            createReportView.close();
    }
}
