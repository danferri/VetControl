package br.edu.ifsp.application.persistence.SQLite;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.model.user.VeterinarianStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLVeterinarianPersistence implements VeterinarianRepository {

    @Override
    public boolean save(Veterinarian veterinarian) {
        String sql = "INSERT INTO veterinarians (name, address, specialty, phone, crmv, contact, status) " +
                "VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, veterinarian.getName());
            statement.setString(2, veterinarian.getAddress());
            statement.setString(3, veterinarian.getSpecialty());
            statement.setString(4, veterinarian.getPhone());
            statement.setString(5, veterinarian.getCrmv().toString());
            statement.setString(6, veterinarian.getContact());
            statement.setString(7, veterinarian.getStatus().toString());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Veterinarian findByCrmv(CRMV crmv) {
        System.out.println("Teste");
        String sql = "SELECT * FROM veterinarians WHERE crmv = ?";
        Veterinarian veterinarian = null;

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, crmv.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                veterinarian = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarian;
    }

    @Override
    public void update(Veterinarian veterinarian) {
        String sql = "UPDATE veterinarians SET name = ?, address = ?, specialty = ?, phone = ?, " +
                "contact = ? WHERE id = ?";

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setString(1, veterinarian.getName());
            statement.setString(2, veterinarian.getAddress());
            statement.setString(3, veterinarian.getSpecialty());
            statement.setString(4, veterinarian.getPhone());
            statement.setString(5, veterinarian.getContact());
            statement.setInt(6, Integer.parseInt(veterinarian.getId()));

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Veterinarian> findAll() {
        String sql = "SELECT * FROM veterinarians";
        List<Veterinarian> veterinarians = new ArrayList<>();

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Veterinarian veterinarian = resultSetToEntity(rs);
                veterinarians.add(veterinarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarians;
    }

    @Override
    public List<Veterinarian> findAllActive() {
        String sql = "SELECT * FROM veterinarians WHERE status = 'Active'";
        List<Veterinarian> veterinarians = new ArrayList<>();

        try (PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Veterinarian veterinarian = resultSetToEntity(rs);
                veterinarians.add(veterinarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarians;
    }

    private Veterinarian resultSetToEntity(ResultSet rs) throws SQLException {
        return new Veterinarian(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("specialty"),
                rs.getString("phone"),
                new CRMV(rs.getString("crmv")),
                rs.getString("contact"),
                VeterinarianStatus.toEnum(rs.getString("status")));
    }
}
