import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;


    /*  @BeforeSuite
      static void setupClass() {
          WebDriverManager.chromedriver().setup();

      }
  */
    public BaseTest(WebDriver givenDriver)
    {
       driver=givenDriver;
        wait = new WebDriverWait(givenDriver, Duration.ofSeconds(5));
        PageFactory.initElements(givenDriver,this);
        action= new Actions(givenDriver);
    }
    protected WebElement findElement(WebElement webElement)

    {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void click(WebElement webElement)
    {
        wait.until((ExpectedConditions.elementToBeClickable(webElement))).click();
    }

    protected void doubleClick(WebElement webElement)
    {
        action.doubleClick(findElement(webElement)).perform();
    }}
