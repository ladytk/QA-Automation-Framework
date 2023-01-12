package Auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;
import java.util.List;

public class AutoPlaylistPage extends AutoBasePage {
    //Locators
    @FindBy(xpath = "//*[@id='playlists']//*[@data-testid='sidebar-create-playlist-btn']")
    private WebElement playlistLocator;
    @FindBy(css = ".btn-delete-playlist")
    private WebElement delBtn;

    @FindBy(css = "[type='text']")
    private WebElement enterNameList;

    @FindBy(xpath = "//li[(contains(.,'New Playlist'))]")
    private WebElement inputPlaylist;

    @FindBy(css = "input[name='name']")
    private WebElement enteringPlaylistName;

    public AutoPlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AutoPlaylistPage playListArea() {
        playlistLocator.click();
        return this;
    }

    public AutoPlaylistPage addingPlaylistbtn() {
        inputPlaylist.click();
        return this;
    }

    public AutoPlaylistPage deletingPlaylist() {
        List<WebElement> playlists = driver.findElements(By.cssSelector(".playlist"));
        actions.contextClick(playlists.get(2)).perform();
        delBtn.click();
        return this;
    }

    public void enterPlayListName(String playListName) {
        enteringPlaylistName.sendKeys((Keys.chord(Keys.COMMAND, "", Keys.BACK_SPACE)));
        enteringPlaylistName.sendKeys(playListName);
        enteringPlaylistName.sendKeys(Keys.ENTER);
    }

    public String getConfirmationPopupText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

    public boolean getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return driver.findElement(By.cssSelector("div.success.show")).isDisplayed();
    }
}