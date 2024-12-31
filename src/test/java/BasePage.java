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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

public  class BasePage {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions action;
    ChromeOptions options = new ChromeOptions();

    /*  @BeforeSuite
      static void setupClass() {
          WebDriverManager.chromedriver().setup();

      }
  */
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        wait.until((ExpectedConditions.visibilityOfElementLocated(locator))).click();
    }

    public void doubleClick(By locator) {
        action.doubleClick(findElement(locator)).perform();
    }

    public String generateRandomPlaylistName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    @BeforeTest
    public void driverSetup() {
        //      Added ChromeOptions argument below to fix websocket error

        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        // options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("here212");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String url = "https://qa.koel.app/";
        driver.get(url);
        // wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        action = new Actions(driver);

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

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver=new ChromeDriver(chromeOptions);

        }
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String BaseURL) throws MalformedURLException
    {
        ThreadLocal threadLocal=new ThreadLocal<>();
        driver=pickBrowser(System.getProperty("browser"));
        threadLocal.set(driver);

        wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        action = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url=BaseURL;
        navigateToPage();

    }





    }

    /*
    public BasePage(WebDriver givenDriver)

    {
        driver=givenDriver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        action= new Actions(driver);
    }*/

    /*
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpDriver() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String url = "https://qa.koel.app/";
        driver.get(url);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
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
    }*/
