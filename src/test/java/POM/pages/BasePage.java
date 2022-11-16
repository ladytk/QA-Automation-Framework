package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    private final By allSongsMenuItemLocator = By.cssSelector("li a.songs");

    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");

    public BasePage (WebDriver givenDriver){

        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.elementToBeClickable(avatarLocator));
    }
    public SongsPage clickOnAllSongs() {
        driver.findElement(allSongsMenuItemLocator).click();
        return new SongsPage(driver);
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }
    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected void waitForVisibilityOfElement(WebElement webElementLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }

}
