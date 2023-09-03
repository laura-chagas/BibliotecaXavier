
import org.example.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.*;


public class AdminTest {
    private AdminRepository adminRepository;
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

        adminRepository = new AdminRepository(connect);
    }

    @Test
    void testauthorRegister() {
        try {
            when(pstmt.executeUpdate()).thenReturn(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        adminRepository.registerAuthor("Louis","01987654321","louis@example.com");

        String mensagemEsperada = "Connected to the PostgreSQL server successfully.";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }

    @Test
    void testsucessLogin() throws SQLException {
        when(pstmt.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(true);
        when(result.getInt("token_admin")).thenReturn(1234);

        boolean result = adminRepository.logIn(1234);

        Assertions.assertTrue(result);
    }

    @Test
    void testinvalidLogin() throws SQLException {
        when(pstmt.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(false);

        boolean result = adminRepository.logIn(1234);

        Assertions.assertFalse(result);
    }

    @Test
    void testbookRegister()throws SQLException {
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.registerBook("O Codigo Da Vinci","Lorem Ipsum...","Aventura");

        Assertions.assertTrue(result);
    }


    @Test
    void testbookDelete()throws SQLException {
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.deleteBook(1);

        Assertions.assertTrue(result);
    }

    @Test
    void testauthorDelete()throws SQLException {
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.deleteAuthor(1);

        Assertions.assertTrue(result);
    }

    @Test
    void testuserDelete()throws SQLException {
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.deleteUser(1);

        Assertions.assertTrue(result);
    }

    @Test
    void testassociateAuthorId()throws SQLException{
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.associateAuthorId(1, 2);

        Assertions.assertTrue(result);
    }

    @Test
    void testassociateBookId()throws SQLException{
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = adminRepository.associateBookId(1, 2);

        Assertions.assertTrue(result);
    }

}





