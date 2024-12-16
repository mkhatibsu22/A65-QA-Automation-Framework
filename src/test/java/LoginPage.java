import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css="[type='email']")
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
   /* @Test
    public void loginEmptyEmailPassword()  {

        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        loginField.sendKeys("planner@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        passwordField.sendKeys("6JooL8gp");
        submitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/");
    }*/
}
