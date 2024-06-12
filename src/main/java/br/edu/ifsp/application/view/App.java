package br.edu.ifsp.application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        AttendantView attendantView = new AttendantView();
        attendantView.show();
        //LoginView loginView = new LoginView();
        //loginView.show();
    }



    public static void main(String[] args) {
        launch();
    }

}