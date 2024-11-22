import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testLogin() {
        Main main = new Main();
        String test1Result = main.login("TEST1@gmail.com", "test1"); // email not in data base
        String test2Result = main.login("test@gmail.com", "122"); // email in db but password wrong

        assertEquals("TEST FAILED",main.invalidLogIN, test1Result);
        assertEquals("TEST FAILED",main.invalidLogIN, test2Result);
    }

}
