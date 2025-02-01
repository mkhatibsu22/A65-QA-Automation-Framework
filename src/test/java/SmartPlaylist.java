import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SmartPlaylist extends BaseTest {
   // WebDriver driver;

    WebElement passwordField;
    WebElement submitbtnField;
    WebDriverWait wait;
    WebElement formPlaylistName;
    WebElement formModelSelect;
    WebElement formOperatorSelect;
    WebElement formInputNameValue;
    WebElement formAddRule;
    WebElement formAddGroup;
    WebElement formSave1;
    @FindBy(css="input[type='email']")
    public WebElement emailField;

    public SmartPlaylist(WebDriver givenDriver) {
        super(givenDriver);
    }


     void given() throws InterruptedException {
         WebElement plusCircleCP = driver.findElement(By.cssSelector("#playlists .fa.fa-plus-circle.create"));
         wait.until((ExpectedConditions.elementToBeClickable(plusCircleCP))).click();
         WebElement createSmartPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-smart']"));
         wait.until((ExpectedConditions.elementToBeClickable(createSmartPlaylist))).click();
         Thread.sleep(2000);
         formPlaylistName = driver.findElement(By.cssSelector("input[name='name'][type='text']"));
         formModelSelect = driver.findElement(By.cssSelector("select[name='model[]']"));
         formOperatorSelect = driver.findElement(By.cssSelector("select[name='operator[]']"));
         formInputNameValue = driver.findElement(By.cssSelector("input[name='value[]']"));
         formAddRule = driver.findElement(By.cssSelector("button[class='btn-add-rule']"));
         formAddGroup = driver.findElement(By.cssSelector("button[class='btn-add-group']"));
         formSave1 = driver.findElement(By.cssSelector("div.smart-playlist-form button[type='submit']"));

         formPlaylistName.sendKeys("first smart playlist");
         formModelSelect.sendKeys("Title");
         formInputNameValue.sendKeys("hello");
         formSave1.click();
     }
         //  @Test
         void createSmartPlaylistOneRule ()
         {
             formPlaylistName.sendKeys("first smart playlist");
             //formModelSelect.sendKeys("title");
         }

     }
