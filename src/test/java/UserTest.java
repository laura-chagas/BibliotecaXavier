
import org.example.repository.UserRepository;
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

public class UserTest {

    private UserRepository userRepository;
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

        userRepository = new UserRepository(connect);
    }

    @Test
    void testCadastro()throws SQLException{
        boolean result = userRepository.registerANewUser("Luna", "187456789", "luna@example.com", "98574");

        verify(pstmt).executeUpdate();

        verify(pstmt).setString(1, "Luna");
        verify(pstmt).setString(2, "187456789");
        verify(pstmt).setString(3, "luna@example.com");
        verify(pstmt).setString(4, "98574");

        Assertions.assertTrue(result);
    }

    @Test
    void testLoginValido()throws SQLException{
        when(pstmt.executeQuery()).thenReturn(result);

        when(result.next()).thenReturn(true);
        when(result.getString("email")).thenReturn("paulo@gmail.com");
        when(result.getString("senha")).thenReturn("1234");

        boolean resultado = userRepository.logIn("paulo@gmail.com", "1234");

        Assertions.assertTrue(resultado);
    }

    @Test
    void testLoginInvalido()throws SQLException{
        when(pstmt.executeQuery()).thenReturn(result);

        when(result.next()).thenReturn(false);

        boolean resultado = userRepository.logIn("paulo@gmail.com", "1234");

        Assertions.assertFalse(resultado);
    }



}




