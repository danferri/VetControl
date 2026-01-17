package br.edu.ifsp.application.view;

import br.edu.ifsp.application.controller.LoginUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    private Stage stage = new Stage();

    public void show() {
        Pane sceneGraph = null;

        try {
            FXMLLoader loader = new FXMLLoader( App.class.getResource( "LoginUI.fxml" ) );
            sceneGraph = loader.load();

            stage.setTitle( "Login" );
            stage.setScene( new Scene( sceneGraph  ) );
            stage.setMaxWidth( 1080 );
            stage.setMaxHeight( 720 );

            LoginUIController loginController = (LoginUIController) loader.getController();
            loginController.init( this );

            stage.show();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void close() {
        stage.close();
    }
}
