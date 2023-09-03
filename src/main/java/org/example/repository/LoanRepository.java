package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.connection.ConnectionClass.connect;

public class LoanRepository {

    private Connection conn = connect();
    private PreparedStatement preparedStatement;

    public LoanRepository() {
    }

    public LoanRepository(Connection connection) {
        this.conn = connection;
    }

    public boolean associateBookIdInLoan(int idBook, int idLoan) {
        try {
            String SQL = "UPDATE tbemprestimo SET idlivro=? WHERE id_emprestimo = ?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, idBook);
            preparedStatement.setInt(2, idLoan);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean associateUserId(int idUser, int idEmprestimo) {
        try {
            String SQL = "UPDATE tbEmprestimo SET idLeitor=? WHERE id_emprestimo=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idEmprestimo);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerNewLoan(int id_book, int id_user) {
        String SQL = "INSERT INTO tbemprestimo(idlivro,idleitor,status) VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id_book);
            pstmt.setInt(2, id_user);
            pstmt.setBoolean(3, true);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatusBook(int id_livro) {
        String SQL = "UPDATE tblivro SET status = ? WHERE id_livro = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, id_livro);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
