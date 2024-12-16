import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework22
{
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
 @Test
    public void hw22()
{
    loginPage.login("mohamed.khatib@testpro.io", "ZWyxkAKX");
    homePage.renamePlaylist();
}
}
