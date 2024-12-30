import org.testng.annotations.Test;

import java.time.Duration;

public class RegressionTest {
    LoginPage loginPage=new LoginPage();

    @Test
    public void loginWithValidEntry()
    {
        loginPage.login("mohamed.khatib@testpro.io", "ZWyxkAKX");

        loginPage.logout();
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void loginInvalidEntry(String email,String password)
    {
        loginPage.login(email, password);

    }
}
