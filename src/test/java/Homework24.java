import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URI;
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

    public WebDriver pickBrowser(String browser) throws MalformedURLException
    {
        DesiredCapabilities caps =new DesiredCapabilities();
        String gridURL="http://192.168.56.1:4444";

        switch (browser){
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver=new FirefoxDriver();
        case "MicrosoftEdge":
            WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return driver=new EdgeDriver(edgeOptions);
        case "grid-Edge":
            caps.setCapability("browserName","MicrosoftEdge");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

        case "grid-firefox":
        caps.setCapability("browserName","firefox");
        return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

        case "grid-chrome":
        caps.setCapability("browserName","chrome");
        return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

        default:
            WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        return driver=new ChromeDriver(chromeOptions);

    }

}}
