import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlbumsTest {
@Test
    void main() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        // options.addArguments("--start-maximized");
        WebDriver driver;
        driver = new ChromeDriver(options);

        String url = "https://qa.koel.app/";
        driver.get(url);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("here212");
       login("mohamed.khatib@testpro.io", "ZWyxkAKX");
        driver.get("https://qa.koel.app/#!/albums");

    }



    @FindBy(css="[type='email']")
    private WebElement emailField;

    @FindBy (css="[type='password']")
    private WebElement passwordField;

    @FindBy (css="[type='submit']")
    private WebElement submitbtnField;

    public  void login(String email,String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitbtnField.click();

    }


}
