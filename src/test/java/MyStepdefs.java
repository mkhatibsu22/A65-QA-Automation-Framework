import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyStepdefs {
    WebDriver driver;
    WebDriverWait wait;
    @Given("I am in the Login Page")
    public void iAmInTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    @And("I enter registered email")
    public void iEnterRegisteredEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='mohamed.khatib@testpro.io']"))).sendKeys(email);
    }

    @And("I enter valid password")
    public void iEnterValidPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='ZWyxkAKX']"))).sendKeys(password);
    }

    @When("I click submit button")
    public void iClickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=submit]"))).click();
    }

    @Then("I must be logged in successfully")
    public void iMustBeLoggedInSuccessfully() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img=avatar"))).isDisplayed());
    }
}
