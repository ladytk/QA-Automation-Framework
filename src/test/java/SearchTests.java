import InternSearch.pages.LoginPageSearch;
import InternSearch.pages.SearchPageSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTests extends BaseTest {
    @Test(enabled = true, priority = 0)// dataProvider = "songTitles", dataProviderClass = BaseTest.class)
    public void searchSongTitle() {
        //GIVEN
        LoginPageSearch Login = new LoginPageSearch(driver);
        SearchPageSearch searching = new SearchPageSearch(driver);
        Login.login();

        //WHEN
        searching.searchBoxMany();

        //THEN
        searching.resultFromSearch();
    }

    @Test(enabled = true, priority = 1)
    public void isSongSearchwithSentiveCase() {
        //GIVEN
        LoginPageSearch Login = new LoginPageSearch(driver);
        SearchPageSearch searching = new SearchPageSearch(driver);
        Login.login();

        //WHEN

        searching.searchBoxforCaseSensitive();

        //THEN
        searching.songResultpage();
        Assert.assertFalse(searching.negativeSearchResult());
    }

    @Test(enabled = true, priority = 2)
    public void clearQuery() {
        //GIVEN
        LoginPageSearch Login = new LoginPageSearch(driver);
        SearchPageSearch searching = new SearchPageSearch(driver);
        Login.login();
        searching.searchBox("Dark Days");

        //WHEN
        searching.clearInputQuery();

        //THEN
        searching.isClearResultAfterDeleting("Dark Days");
    }
}