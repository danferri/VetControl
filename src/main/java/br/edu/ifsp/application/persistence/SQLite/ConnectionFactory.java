
package br.edu.ifsp.application.persistence.SQLite;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory implements AutoCloseable{

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;

    public static Connection createConnection(){
        try{
            instantiateConnectionIfNull();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private static void instantiateConnectionIfNull() throws SQLException {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:database.db");
        if (connection == null)
            connection = dataSource.getConnection();
    }

    public static PreparedStatement createPreparedStatement(String sql){
        try {
            preparedStatement = createConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Statement createStatement(){
        try {
            statement = createConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public void close() throws Exception {
        closeStatementsIfNotNull();
        closeConnectionIfNotNull();
    }

    private static void closeConnectionIfNotNull() throws SQLException {
        if(connection != null)
            connection.close();
    }

    private static void closeStatementsIfNotNull() throws SQLException {
        if(preparedStatement != null)
            preparedStatement.close();
        if (statement != null)
            statement.close();
    }
}