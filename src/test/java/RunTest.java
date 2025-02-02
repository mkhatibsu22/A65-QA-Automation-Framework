import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTest  {



    @Test
    public void doTest1() throws InterruptedException {
          SmartPlaylist smartTestone=new SmartPlaylist();
          smartTestone.addOnerule("first try","Title","","any");

    }
    public  void login(String email,String password)
    {



    }
}


