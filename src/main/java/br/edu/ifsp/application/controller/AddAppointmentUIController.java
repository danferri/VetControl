package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.PaymentPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.application.view.AddAppointmentView;
import br.edu.ifsp.application.view.CreateRecordView;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.appointment.AddAppointmentUseCase;
import br.edu.ifsp.domain.usecases.payment.CreatePaymentUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalTime;


public class AddAppointmentUIController {
    @FXML private DatePicker dpDate;
    @FXML private TextField txtHour;
    @FXML private TextField txtDescription;
    //@FXML private TextField txtVeterinarian;
    //@FXML private TextField txtPet;
    @FXML private ComboBox<Veterinarian> cbVeterinarian;
    @FXML private ComboBox<Pet> cbPet;
    @FXML private TextField txtCost;
    @FXML private TextField txtMethod;

    private AddAppointmentView addAppointmentView;

    private final AppointmentRepository appointmentRepository = new AppointmentPersistence();
    private final VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
    private final PaymentRepository paymentRepository = new PaymentPersistence();
    private final PetRepository petRepository = new PetPersistence();

    private AddAppointmentUseCase addAppointmentUseCase;
    private CreatePaymentUseCase createPaymentUseCase;

    public void init(AddAppointmentView addAppointmentView) {
        this.addAppointmentView = addAppointmentView;
        this.addAppointmentUseCase = new AddAppointmentUseCase(appointmentRepository);
        this.createPaymentUseCase = new CreatePaymentUseCase(paymentRepository);

        ObservableList<Veterinarian> veterinarians = FXCollections.observableArrayList(veterinarianRepository.findAllActive());
        ObservableList<Pet> pets = FXCollections.observableArrayList(petRepository.findAll());

        //debug
        System.out.println("Veterinarians: " + veterinarianRepository.findAll().size());
        System.out.println("Pets: " + pets.size());

        cbVeterinarian.setItems(veterinarians);
        cbPet.setItems(pets);

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

    public void saveOrUpdate(ActionEvent actionEvent) {
        LocalDate date = dpDate.getValue();
        String hour = txtHour.getText();
        String description = txtDescription.getText();
        Veterinarian veterinarian = cbVeterinarian.getValue();
        Pet pet = cbPet.getValue();

        String method = txtMethod.getText();
        double cost = Double.parseDouble(txtCost.getText());

        try {
            Appointment result = addAppointmentUseCase.cadastrarConsulta(date, LocalTime.parse(hour), description, veterinarian, pet, cost);
            if (result != null) {
                createPaymentUseCase.cadastrarPagamento(result, method, cost);

                alertSuccessCadastro();
                addAppointmentView.close();
            } else {
                alertFailCadastro();
            }
        } catch (Exception e) {
            alertException(e);
        }
    }

    private void alertSuccessCadastro() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro realizado com sucesso!");
        alert.setHeaderText(null);
        alert.setContentText("A consulta foi cadastrada com sucesso!");

        alert.showAndWait();
    }

    private void alertFailCadastro() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Falha no Cadastro");
        alert.setContentText("Não foi possível cadastrar a consulta.");

        alert.showAndWait();
    }

    private void alertException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Erro");
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    public void backToPreviousScene(ActionEvent actionEvent) {
        if (addAppointmentView != null) {
            addAppointmentView.close();
        }
    }

    public void gerarProtuario(ActionEvent actionEvent) {
        CreateRecordView createRecordView = new CreateRecordView(txtDescription.getText(), txtDescription);
        createRecordView.showAndWait();
    }
}

