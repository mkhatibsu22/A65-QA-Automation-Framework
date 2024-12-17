import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework23 {


    LoginPage loginPage;
    HomePage homePage;
    ChromeOptions options = new ChromeOptions();
    WebDriver driver;
    @Test
            void main()
    {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        // options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage1=new LoginPage(driver);
        HomePage homePage1=new HomePage(driver);
        String url = "https://qa.koel.app/";
        driver.get(url);
             System.out.println("here212");
        loginPage1.login("mohamed.khatib@testpro.io", "ZWyxkAKX");
        homePage1.renamePlaylist();
    }

}
