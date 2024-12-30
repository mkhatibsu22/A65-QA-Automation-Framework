import org.testng.annotations.Test;

public class SmokeTest
{
    LoginPage loginPage=new LoginPage();

 @Test
    public void loginWithValidEntry()
{
    loginPage.login("mohamed.khatib@testpro.io", "ZWyxkAKX");

}
}
