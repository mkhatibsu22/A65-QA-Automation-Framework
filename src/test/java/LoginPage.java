import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {
    /*@Test
    public void loginEmptyEmailPassword()  {

        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        loginField.sendKeys("planner@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        passwordField.sendKeys("6JooL8gp");
        submitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/");
    }*/

  /*  public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }*/
    By emailField=By.cssSelector("input[type='email']");
    By passwordField=By.cssSelector("input[type='password']");
    By submitBtn =By.cssSelector("button[type='submit']");

     void login(String email,String password)
    {
       wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn)).click();

    }

}
