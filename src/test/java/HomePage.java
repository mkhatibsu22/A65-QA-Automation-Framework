import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{

   /* public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }*/

    public void renamePlaylist()
    {
        By selectedPlaylist =By.cssSelector(".playlist.playlist:nth-of-type(4) a");
        //action.doubleClick(findElement(By.cssSelector(".playlist.playlist:nth-of-type(4) a"))).perform();
        doubleClick(selectedPlaylist);
        WebElement auxwe =driver.findElement(By.cssSelector(".playlist:nth-child(4) input"));
        auxwe.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        auxwe.sendKeys( generateRandomPlaylistName());
        auxwe.sendKeys(Keys.ENTER);

    }
}
