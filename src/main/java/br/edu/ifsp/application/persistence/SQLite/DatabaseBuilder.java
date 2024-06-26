package br.edu.ifsp.application.persistence.SQLite;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    public void buildDatabaseIfMissing() {
        if (isDatabaseMissing()) {
            System.out.println("Database is Missing. Building Database...");
            buildTables();
        }
    }

    private boolean isDatabaseMissing() {
        return !Files.exists(Paths.get("database.db"));
    }

    private void buildTables() {
        try (Statement statement = ConnectionFactory.createStatement()){
            statement.addBatch(createClientTable());
            statement.addBatch(createVeterinarianTable());
            statement.addBatch(createPaymentTable());
            statement.addBatch(createPetTable());
            statement.addBatch(createAppointmentTable());
            statement.executeBatch();

            System.out.println("Base de dados criada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private String createAppointmentTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE appointments (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n");
        builder.append("date DATE NOT NULL, \n");
        builder.append("time TIME NOT NULL, \n");
        builder.append("description VARCHAR(100) NOT NULL, \n");
        builder.append("status VARCHAR(20) NOT NULL, \n");
        builder.append("cost DECIMAL(10, 2) NOT NULL, \n");
        builder.append("veterinarian_id INTEGER NOT NULL, \n");
        builder.append("pet_id INTEGER NOT NULL, \n");
        builder.append("payment_id INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(veterinarian_id) REFERENCES veterinarians(id), \n");
        builder.append("FOREIGN KEY(pet_id) REFERENCES pets(id), \n");
        builder.append("FOREIGN KEY(payment_id) REFERENCES payments(id) \n");
        builder.append(");\n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String createClientTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE clients (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n");
        builder.append("name VARCHAR(100) NOT NULL, \n");
        builder.append("address VARCHAR(150) NOT NULL, \n");
        builder.append("cpf VARCHAR(14) NOT NULL UNIQUE \n");
        builder.append(");\n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String createPaymentTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE payments (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n");
        builder.append("method VARCHAR(50) NOT NULL, \n");
        builder.append("status VARCHAR(50) NOT NULL, \n");
        builder.append("amount DECIMAL(10, 2) NOT NULL \n");
        builder.append(");\n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String createVeterinarianTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE veterinarians (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n");
        builder.append("name VARCHAR(100) NOT NULL, \n");
        builder.append("address VARCHAR(150) NOT NULL, \n");
        builder.append("specialty VARCHAR(100) NOT NULL, \n");
        builder.append("phone VARCHAR(20) NOT NULL, \n");
        builder.append("crmv VARCHAR(20) NOT NULL UNIQUE, \n");
        builder.append("contact VARCHAR(100) NOT NULL, \n");
        builder.append("status VARCHAR(50) NOT NULL \n");
        builder.append(");\n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String createPetTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE pets (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n");
        builder.append("name VARCHAR(100) NOT NULL, \n");
        builder.append("breed VARCHAR(100) NOT NULL, \n");
        builder.append("species VARCHAR(100) NOT NULL, \n");
        builder.append("status VARCHAR(100) NOT NULL, \n");
        builder.append("owner_id INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(owner_id) REFERENCES clients(id) \n");
        builder.append(");\n");

        System.out.println(builder.toString());
        return builder.toString();
    }
}