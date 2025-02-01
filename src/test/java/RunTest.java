import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTest {
    ChromeOptions options = new ChromeOptions();
    ChromeDriver driver = new ChromeDriver(options);
   @Test
    public void doTest1() {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        // options.addArguments("--start-maximized");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);

        login("mohamed.khatib@testpro.io", "ZWyxkAKX");
        //driver.get("https://qa.koel.app/#!/albums");
        //Thread.sleep(3000);

    }
    public  void login(String email,String password)
    {
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();


    }
}


