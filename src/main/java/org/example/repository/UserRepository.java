package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionClass.connect;

public class UserRepository {
    private Connection conn = connect();
    private PreparedStatement preparedStatement;

    public UserRepository(){}

    public UserRepository(Connection connection){
        this.conn = connection;
    }


    public boolean registerANewUser(String nome, String cpf, String email, String senha) {
        String sql = "INSERT INTO tbLeitor (nome,cpf,email,senha) VALUES (?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, senha);
            preparedStatement.executeUpdate();
            System.out.println("Leitor registrado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String email, String password) {
        try {
            String SQL = "SELECT * FROM tbLeitor WHERE email=? AND senha=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if ((resultSet.getString("email").equals(email)) && (resultSet.getString("senha").equals(password))) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }



}
