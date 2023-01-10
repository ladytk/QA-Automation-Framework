package POM.pages;

import InternSearch.pages.BasePageSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageSearch extends BasePageSearch {

    //Locators
    @FindBy(css="[type='search']")
    WebElement searchInput;

    //By searchInput = By.cssSelector("[type='search']");


    public SearchPageSearch(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SearchPageSearch searchBox(String songName){
        searchInput.sendKeys(songName);
        return this;

    }


}
