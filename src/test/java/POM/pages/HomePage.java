package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "img[alt='Avatar of Abdi']")
    private WebElement avatarLocator;

    @FindBy(css = "a.songs.active")
    private WebElement buttonAllSongs;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean isUserAvatarDisplayed() {
        return avatarLocator.isDisplayed();
    }

    public void clickButtonAllSongs() {
        waitForVisibilityOfElement(buttonAllSongs);
        buttonAllSongs.click();
    }
}

