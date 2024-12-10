
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SongsTests extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        System.out.println(playlistName);
        login("planner@testpro.io", "6JooL8gp");
        searchForSong(text);
        clickViewAllBtn();
        clickFirstSearchResultSong();
        clickAddToPlaylistBtn();
        createNewPlaylistWhileAddingSong(playlistName);
        Assert.assertTrue(isBannerDisplayed());
        Assert.assertEquals(text, getSongName());
    }

    @Test
    public void deletePlaylist() {
        login("planner@testpro.io", "6JooL8gp");
        String name = driver.findElement(By.cssSelector(".playlist.playlist:nth-of-type(3) a")).getText();
        clickFirstPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(isBannerDisplayed());
        String bannerMessage = getBannerText();
        Assert.assertEquals(bannerMessage, "Deleted playlist \"" + name + ".\"");
        Assert.assertTrue(bannerMessage.contains("Deleted playlist"));
    }

}
