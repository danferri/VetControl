package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.ManagePaymentUIController;
import br.edu.ifsp.application.persistence.PaymentPersistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManagePaymentView {

    private Stage stage;
    private PaymentPersistence paymentPersistence;

    public ManagePaymentView(PaymentPersistence paymentPersistence) {
        this.stage = new Stage();
        this.paymentPersistence = paymentPersistence;
    }

    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/ManagePaymentUI.fxml"));
            Parent root = loader.load();

            ManagePaymentUIController controller = loader.getController();
            controller.init(this, paymentPersistence);

            Scene scene = new Scene(root);
            stage.setTitle("Gerenciamento de Pagamentos");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        stage.close();
    }
}


