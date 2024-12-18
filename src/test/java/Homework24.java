import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework24 {


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

    public pickBrowser(String browser)
    {
        switch (browser)
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver=new FirefoxDriver();
        case "MicrosoftEdge":
            WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return driver=new EdgeDriver(edgeOptions);

        default:
            WebDriverManager.chromedriver()driver().setup();
        ChromeOptions chromeOptions =new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");
        return driver=new ChromeDriver(chromeOptions);

    }

}
