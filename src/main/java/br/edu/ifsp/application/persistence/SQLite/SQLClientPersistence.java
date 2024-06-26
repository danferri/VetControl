package br.edu.ifsp.application.persistence.SQLite;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLClientPersistence implements ClientRepository {

    @Override
    public boolean save(Client cliente) {
        String sql = "INSERT INTO clients (name, address, cpf) VALUES (?,?,?)";

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, cliente.getName());
            statement.setString(2, cliente.getAddress());
            statement.setString(3, cliente.getCpf().toString());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Client findByCPF(CPF cpf) {
        String sql = "SELECT * FROM clients WHERE cpf = ?";
        Client client = null;

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, cpf.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                client = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Client client = resultSetToEntity(rs);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE clients SET name = ?, address = ?, cpf = ? WHERE id = ?";

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, client.getName());
            statement.setString(2, client.getAddress());
            statement.setString(3, client.getCpf().toString());
            statement.setInt(4, client.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Client resultSetToEntity(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"),
                new CPF(rs.getString("cpf")));
    }
}