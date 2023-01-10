package InternSearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPageSearch extends BasePageSearch {

    //Locators
    @FindBy(css = "[type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@data-testid='song-excerpts']//button[@data-test='view-all-songs-btn']")
    private WebElement songresult;
    //locator for correct song
    @FindBy(xpath = "//*[@id='songResultsWrapper']//td[@class='title']")
    private WebElement isThatCorrectSong;
    //locator is correct artist
    @FindBy(xpath = "//*[@id='songResultsWrapper']//td[@class='artist']")
    private WebElement isThatCorrectartist;

    //locator for correct Album
    @FindBy(xpath = "//*[@id='songResultsWrapper']//td[@class='album']")
    private WebElement isThatCorrectAlbum;
    //search result-search area
    @FindBy(css = "#searchExcerptsWrapper h1")
    private WebElement searchResult;

    @FindBy(css = "input[name='q']")
    private WebElement inputField;

    String songName = "Dark Days";
    //use all cases- exact spelling of song name, ingnore trailing and heading white space
    String[] list = {"Dark Days", " Dark Days ", "Dark Days "};
    String[] caseSenList = {"darks day", "darKs DAy"};

    public SearchPageSearch(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SearchPageSearch searchBox(String songName) {
        searchInput.sendKeys(songName);
        return this;
    }

    public SearchPageSearch searchBoxMany() {
        for (int i = 0; i < list.length; i++) {
            searchInput.sendKeys(list[i]);
        }
        return this;
    }

    public SearchPageSearch searchBoxforCaseSensitive() {
        for (int i = 0; i < caseSenList.length; i++) {
            searchInput.sendKeys(caseSenList[i]);
        }
        return this;
    }

    public SearchPageSearch resultFromSearch() {
        songresult.click();
        Assert.assertEquals(isThatCorrectSong.getText(), "Dark Days");
        Assert.assertEquals(isThatCorrectartist.getText(), "Grav");
        Assert.assertEquals(isThatCorrectAlbum.getText(), "Dark Days EP");
        return this;
    }

    public void isClearResultAfterDeleting(String songName) {
        Assert.assertEquals(searchResult.getText(), "Search");
    }

    public boolean negativeSearchResult() {
        return isThatCorrectSong.isDisplayed();
    }

    public void songResultpage() {
        songresult.click();
    }
    public void clearInputQuery() {
        inputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE)));
    }
}


