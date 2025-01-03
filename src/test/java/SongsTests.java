
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/*
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

    @Test
    public void playSongWithRightClick() throws InterruptedException {
        login("planner@testpro.io", "6JooL8gp");
        driver.findElement(By.cssSelector(".songs")).click();
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item:nth-child(1)"));
        // right click
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
        driver.findElement(By.cssSelector(".playback")).click();
        Thread.sleep(2000);
    }

    @Test
    public void playSongWithHoverOver() throws InterruptedException {
        login("planner@testpro.io", "6JooL8gp");

        WebElement footerLogo = driver.findElement(By.cssSelector(".player-controls"));
        // hover over
        Actions actions = new Actions(driver);
        actions
                .moveToElement(footerLogo)
                .perform();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed());
    }

    @Test
    public void countSongs() throws InterruptedException {
        login("planner@testpro.io", "6JooL8gp");
        driver.findElement(By.cssSelector(".songs")).click();
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item .title"));
        int size = songs.size();
        System.out.println(size);
        List<String> songNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = songs.get(i).getText();
            songNames.add(name);
        }
        System.out.println(songNames);
        Assert.assertTrue(songNames.contains("Epic Song"));

    }

    @Test
    public void renamePlaylist() {
        String playlistName = generateRandomPlaylistName();
        login("planner@testpro.io", "6JooL8gp");
        WebElement firstCustomPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        String nameBefore = firstCustomPlaylist.getText();
        boolean isCustomPlaylistExists = firstCustomPlaylist.isDisplayed();
        if(!isCustomPlaylistExists){
            createNewPlaylistWhileAddingSong(playlistName);
        }
        // double click
        new Actions(driver)
                .doubleClick(firstCustomPlaylist)
                .perform();
        //
        WebElement input = driver.findElement(By.cssSelector(".playlist:nth-child(3) input"));
        input.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE)); // this should work for Mac
       // input.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE)); // this should work for Windows
        input.sendKeys("1000");
        input.sendKeys(Keys.ENTER);
        String nameAfter = firstCustomPlaylist.getText();
        // Using Soft Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(nameBefore.equals(nameAfter),
                "=== The song name expected to be different ===");
        // This line is required for soft assert, otherwise a test won't fail in case of failed assertion
        softAssert.assertAll();
    }
}
*/