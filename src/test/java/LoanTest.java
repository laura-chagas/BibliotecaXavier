
import org.example.repository.LoanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LoanTest {
    private LoanRepository loanRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement pstmt = mock(PreparedStatement.class);
    private ResultSet result = mock(ResultSet.class);
    private ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(capturaASaidaDoConsole));

        try {
            when(connect.prepareStatement(anyString())).thenReturn(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        loanRepository = new LoanRepository(connect);
    }

    @Test
    void testregisterNewLoan() throws SQLException {
        boolean result = loanRepository.registerNewLoan(1, 2);

        verify(pstmt).executeUpdate();

        verify(pstmt).setInt(1, 1);
        verify(pstmt).setInt(2, 2);
        verify(pstmt).setBoolean(3, true);

        Assertions.assertTrue(result);
    }

    @Test
    void testassociateUserId()throws SQLException{
        boolean result = loanRepository.associateUserId(1, 2);

        verify(pstmt).executeUpdate();

        verify(pstmt).setInt(1, 1);
        verify(pstmt).setInt(2, 2);

        Assertions.assertTrue(result);
    }

    @Test
    void testupdateStatusBook()throws SQLException{
        boolean result = loanRepository.updateStatusBook(1);

        verify(pstmt).executeUpdate();

        verify(pstmt).setBoolean(1, false);
        verify(pstmt).setInt(2, 1);

        Assertions.assertTrue(result);
    }



}




