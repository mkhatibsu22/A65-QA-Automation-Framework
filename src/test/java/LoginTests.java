import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmailPassword()  {
        WebDriver driver2=getThreadDriver();
        WebElement loginField = driver2.findElement(By.cssSelector("[type='email']"));
        loginField.sendKeys("planner@testpro.io");
        WebElement passwordField = driver2.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver2.findElement(By.cssSelector("[type='submit']"));
        passwordField.sendKeys("6JooL8gp");
        submitButton.click();
        Assert.assertEquals(driver2.getCurrentUrl(),"https://qa.koel.app/");
    }

    @Test
     void loginEmptyEmailPassword()  {
        WebDriver driver1=getThreadDriver();

        WebElement loginField = driver1.findElement(By.cssSelector("[type='email']"));
        loginField.sendKeys("");
        WebElement passwordField = driver1.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver1.findElement(By.cssSelector("[type='submit']"));
        passwordField.sendKeys("6JooL8gp");
        submitButton.click();
        Assert.assertEquals(driver1.getCurrentUrl(),"https://qa.koel.app/");
    }
}
