import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement rn=driver.findElement(By.cssSelector("a[href='registration']"));
        rn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
        Thread.sleep(2000); //Added a temporary Thread.sleep for demo purposes
        driver.quit();
    }

}
