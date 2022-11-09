package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    private final By allSongsMenuItemLocator = By.cssSelector("li a.songs");

    public BasePage (WebDriver givenDriver){

        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://bbb.testpro.io/");
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public SongsPage clickOnAllSongs() {
        driver.findElement(allSongsMenuItemLocator).click();
        return new SongsPage(driver);
    }
}
