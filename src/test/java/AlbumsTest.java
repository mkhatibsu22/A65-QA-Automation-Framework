import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlbumsTest {
    WebDriver driver;
    WebElement emailField;
    WebElement passwordField;
    WebElement submitbtnField;
@Test
    void main() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        // options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);

        System.out.println("here212");
        emailField=driver.findElement(By.cssSelector("input[type='email']"));
        passwordField=driver.findElement(By.cssSelector("input[type='password']"));
        submitbtnField=driver.findElement(By.cssSelector("button[type='submit']"));
       login("mohamed.khatib@testpro.io", "ZWyxkAKX");
        driver.get("https://qa.koel.app/#!/albums");

    }





    public  void login(String email,String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitbtnField.click();

    }


}
