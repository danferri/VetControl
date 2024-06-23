package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.AddAppointmentUIController;
import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAppointmentView {

    private Stage stage;
    private AppointmentPersistence appointmentPersistence;
    private VeterinarianPersistence veterinarianPersistence;
    private PetPersistence petPersistence;

    public AddAppointmentView(AppointmentPersistence appointmentPersistence, VeterinarianPersistence veterinarianPersistence, PetPersistence petPersistence) {
        this.stage = new Stage();
        this.appointmentPersistence = appointmentPersistence;
        this.veterinarianPersistence = veterinarianPersistence;
        this.petPersistence = petPersistence;
    }


    public void showAndWait() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/application/view/AddAppointmentUI.fxml"));
            Parent root = loader.load();

            AddAppointmentUIController controller = loader.getController();
            controller.init(this, appointmentPersistence, veterinarianPersistence, petPersistence);

            Scene scene = new Scene(root);
            stage.setTitle("Cadastro de Consulta");
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

