import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };}
    @Test(dataProvider = "IncorrectLoginProviders")
    public void loginInvalidEntry(String email,String password)
    {
        loginPage.login(email, password);

    }
/*
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }
    @Test (dataProvider = "data-provider")
    public void myTest (String val) {
        System.out.println("Passed Parameter Is : " + val);
    }*/
}