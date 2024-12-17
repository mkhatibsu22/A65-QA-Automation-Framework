import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    @FindBy(css=".playlist.playlist:nth-of-type(4) a")
    private WebElement selectedPlaylist;

    @FindBy (css=".playlist:nth-child(4) input")
    private WebElement auxwe;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void renamePlaylist()
    {

        doubleClick(selectedPlaylist);

        auxwe.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        auxwe.sendKeys( generateRandomPlaylistName());
        auxwe.sendKeys(Keys.ENTER);

    }
}
