import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
   // WebDriver driver;

    WebElement passwordField;
    WebElement submitbtnField;
    //WebDriverWait wait;
    WebElement formPlaylistName;
    WebElement formModelSelect;
    WebElement formOperatorSelect;
    WebElement formInputNameValue;
    WebElement formAddRule;
    WebElement formAddGroup;
    WebElement formSave1;


    public  WebDriver driver ;

    public  String url = "https://qa.koel.app/";
    public  WebDriverWait wait = null;



    public BaseTest()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
//        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        //driver = pickBrowser(System.getProperty("browser"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(url);
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("mohamed.khatib@testpro.io");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("ZWyxkAKX");
        WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
        element.click();


    }
    void openCreateSmartPlaylistForm() throws InterruptedException {
        Thread.sleep(3000);
        WebElement plusCircleCP = driver.findElement(By.cssSelector("#playlists .fa.fa-plus-circle.create"));
        wait.until((ExpectedConditions.elementToBeClickable(plusCircleCP))).click();
        WebElement createSmartPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-smart']"));
        wait.until((ExpectedConditions.elementToBeClickable(createSmartPlaylist))).click();
    }

     void addOnerule(String name,String model ,String opertaor,String eqValue ) throws InterruptedException {
         openCreateSmartPlaylistForm();
         Thread.sleep(2000);
         formPlaylistName = driver.findElement(By.cssSelector("input[name='name'][type='text']"));
         formModelSelect = driver.findElement(By.cssSelector("select[name='model[]']"));
         formOperatorSelect = driver.findElement(By.cssSelector("select[name='operator[]']"));
         formInputNameValue = driver.findElement(By.cssSelector("input[name='value[]']"));
         formAddRule = driver.findElement(By.cssSelector("button[class='btn-add-rule']"));
         formAddGroup = driver.findElement(By.cssSelector("button[class='btn-add-group']"));
         formSave1 = driver.findElement(By.cssSelector("div.smart-playlist-form button[type='submit']"));
//select[name='operator[]'] > option:nth-of-type(1)
         formPlaylistName.sendKeys(name);
         formModelSelect.sendKeys(model);
         formInputNameValue.sendKeys(eqValue);


         formSave1.click();
     }
         //  @Test    div.rule-group input[name='value[]']
         void createSmartPlaylistMultibleRule ()
         {
             formAddRule.click();

             formOperatorSelect = driver.findElement(By.cssSelector("select[name='operator[]']"));
             formInputNameValue = driver.findElement(By.cssSelector("input[name='value[]']"));

             formModelSelect.sendKeys("Album");
             formInputNameValue.sendKeys("equal");
             formPlaylistName.sendKeys("first smart playlist");
             //formModelSelect.sendKeys("title");
         }

         void openArtistsPage()
         {
             WebElement artistsLink= driver.findElement(By.cssSelector("a.artists"));
             wait.until((ExpectedConditions.elementToBeClickable(artistsLink))).click();

         }

    void searchArtists(String name)
    {
        WebElement artistSearch= driver.findElement(By.cssSelector("input[type='search']"));
        wait.until((ExpectedConditions.elementToBeClickable(artistSearch))).sendKeys(name);


    }


     }
