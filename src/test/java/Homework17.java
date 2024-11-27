import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17  extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement rn=driver.findElement(By.cssSelector("input[type='email']"));
        rn.sendKeys("mohamed.khatib@testpro.io");

        WebElement pw=driver.findElement(By.cssSelector("input[type='password']"));
        pw.sendKeys("B8gG0Wl2DJna");

        WebElement sb=driver.findElement(By.cssSelector("button[type='submit']"));
        sb.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000); //Added a temporary Thread.sleep for demo purposes
        driver.quit();



}}
