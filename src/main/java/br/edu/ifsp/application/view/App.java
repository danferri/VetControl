package br.edu.ifsp.application.view;

import br.edu.ifsp.application.persistence.SQLite.DatabaseBuilder;
import javafx.application.Application;
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
        setUpDatabase();
        launch();
    }

    private static void setUpDatabase() {
        DatabaseBuilder databaseBuilder = new DatabaseBuilder();
        databaseBuilder.buildDatabaseIfMissing();
    }

}