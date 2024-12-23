import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class BaseTest {

    protected WebDriver driver;
    WebDriverWait wait;
    private static final ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>();
    String url;
    //@BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpDriver(String BaseURL) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);*/
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       /* wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String url = "https://qa.koel.app/";

        driver.get(url);*/
        getThreadDriver().get(BaseURL);
        url=BaseURL;
        navigateToPage();
    }

    private void navigateToPage() {
        getThreadDriver().get(url);
    }

    private WebDriver getThreadDriver() {
        return threadDriver.get();
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException
    {
        DesiredCapabilities caps =new DesiredCapabilities();
        String gridURL="http://192.168.56.1:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver=new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver=new EdgeDriver(edgeOptions);
            case "grid-Edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

                case "cloud";
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver=new ChromeDriver(chromeOptions);

        }}

    public WebDriver lambdaTest() throws MalformedURLException
    {
        DesiredCapabilities caps =new DesiredCapabilities();
        String hubURL="HTTPS://hub.lambdatest.com/wd/hub/";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("131");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "mkhatibsu22");
        ltOptions.put("accessKey", "OUzjDicFstAqZq1NCnNCQYzTkmbHVLpQA0l9z5drlad7ZROmYa");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL),caps);
    }

    @AfterMethod
    public void closeBrowser() {
        threadDriver.get().close();
        threadDriver.remove();
    }


    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    public void enterPassword(String password) {
        WebElement passwordInput = waitUntilClickable(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void clickLoginBtn() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }


    protected void enterEmail(String email) {
        WebElement emailInput = waitUntilVisible(By.cssSelector("[type='email']"));
      //  WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitUntilClickable(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public void searchForSong(String text) {
        WebElement searchInput = waitUntilClickable(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = waitUntilClickable(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        newPlaylistNameInput.sendKeys(Keys.ENTER);
    }
    public boolean isBannerDisplayed(){
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        return successBanner.isDisplayed();
    }

    public String getSongName(){
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }

    protected String getBannerText() {
        String bannerMessage = driver.findElement(By.cssSelector(".success")).getText();
        return bannerMessage;
    }

    protected void clickDeletePlaylist() {
        driver.findElement(By.cssSelector(".btn-delete-playlist")).click();
        driver.findElement(By.cssSelector(".ok")).click();
    }

    protected void clickFirstPlaylist() {
        driver.findElement(By.cssSelector(".playlist.playlist:nth-of-type(3)")).click();
    }
}