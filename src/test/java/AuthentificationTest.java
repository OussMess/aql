import Beans.Authentification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import session.ConnectDb;

@RunWith(MockitoJUnitRunner.class)
public class AuthentificationTest {
    private Authentification login;
    private ConnectDb connectDb;

    @Before
    public void setUp() throws Exception {
        login = new Authentification();
        connectDb = mock(ConnectDb.class);
        login.setConnectBD(connectDb);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_username() {
        String username = "hamza";
        String usernameNotCorrect = "NoOne";

        when(connectDb.checkUsername(username)).thenReturn(true);
        when(connectDb.checkUsername(usernameNotCorrect)).thenReturn(false);

        assertTrue(login.isCorrectLogin(username));
        assertFalse(login.isCorrectLogin(usernameNotCorrect));
    }

    @Test
    public void test_username_password() {
        String username = "ouss", password = "mess";
        String usernameCorrect = "hamza", passwordNotCorrect="incorrect";

        when(connectDb.checkUsernamePassword(username, password)).thenReturn(true);
        when(connectDb.checkUsernamePassword(usernameCorrect, passwordNotCorrect)).thenReturn(false);

        assertTrue(login.isCorrectLoginPassword(username, password));
        assertFalse(login.isCorrectLoginPassword(usernameCorrect, passwordNotCorrect));
    }
    @Test
    public void testSelenuim() throws Exception{

        System.setProperty("webdriver.chrome.driver", "/Users/Mac/Downloads/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.google.com/");
    }

}