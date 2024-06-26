package br.edu.ifsp.application.controller;



import br.edu.ifsp.application.persistence.PaymentPersistence;
import br.edu.ifsp.application.view.ManagePaymentView;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.usecases.payment.ProcessPaymentUseCase;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class ManagePaymentUIController {

    public static ObservableList<Payment> payments;
    private PaymentRepository paymentRepository = new PaymentPersistence();
    private ManagePaymentView managePaymentView;

    @FXML TableView<Payment> tablePayments;
    @FXML TableColumn<Payment, String> colID;
    @FXML TableColumn<Payment, String> colAmount;
    @FXML TableColumn<Payment, String> colMethod;
    @FXML TableColumn<Payment, String> colStatus;
    @FXML TableColumn<Payment, String> colAppointment;

    @FXML private Button btnViewDetails;
    @FXML private Button btnProcessPayment;
    @FXML private TextField txtSearch;

    public void init(ManagePaymentView managePaymentView) {
        this.managePaymentView = managePaymentView;

        setupColumns();
        insertData();
        loadData(this.paymentRepository.findAll());
    }

    private void setupColumns() {
        colID.setCellValueFactory(data -> new ReadOnlyStringWrapper(Integer.toString(data.getValue().getAppointment().getId())));
        colAmount.setCellValueFactory(data -> new ReadOnlyStringWrapper(String.format("%.2f", data.getValue().getAmount()))); //colAmount.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getAmount()));
        colMethod.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getMethod()));
        colStatus.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getStatus().toString()));
        colAppointment.setCellValueFactory(data -> new ReadOnlyStringWrapper(Integer.toString(data.getValue().getAppointment().getId())));
    }

    private void insertData() {
        payments = FXCollections.observableArrayList();
        tablePayments.setItems(payments);
    }

    private void loadData(List<Payment> paymentList) {
        payments.clear();
        payments.addAll(paymentList);
        tablePayments.refresh();
    }

    public void searchPayments() {
        String id = txtSearch.getText();
        Integer idToNumbert = Integer.parseInt(id);
        List<Payment> payments = new ArrayList<>();

        for(Payment payment : this.paymentRepository.findAll()) {
            if(payment.getAppointment().getId() == idToNumbert)
                payments.add(payment);
            }

        loadData(payments);
    }

    @FXML
    public void viewPaymentDetails(ActionEvent actionEvent) {
        Payment selectedPayment = tablePayments.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            Alert detailsAlert = new Alert(Alert.AlertType.INFORMATION);
            detailsAlert.setTitle("Detalhes do Pagamento");
            detailsAlert.setHeaderText("Informações do Pagamento");
            String content = String.format("ID Consulta: %s\nValor: %s\nMétodo: %s\nStatus: %s\nData: %s",
                    selectedPayment.getId(),
                    selectedPayment.getAmount(),
                    selectedPayment.getMethod(),
                    selectedPayment.getStatus(),
                    selectedPayment.getAppointment().getDate().toString());
            detailsAlert.setContentText(content);
            detailsAlert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleção de Pagamento");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um pagamento para ver os detalhes.");
            alert.showAndWait();
        }
    }

    @FXML
    public void processPayment(ActionEvent actionEvent) {
        Payment selectedPayment = tablePayments.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            ProcessPaymentUseCase processPaymentUseCase = new ProcessPaymentUseCase(paymentRepository);
            processPaymentUseCase.processarPagamento(selectedPayment.getId());

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Processar Pagamento");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um pagamento para processar.");
            alert.showAndWait();
        }

        loadData(paymentRepository.findAll());
    }

    @FXML
    public void close() {
        managePaymentView.close();
    }


}



