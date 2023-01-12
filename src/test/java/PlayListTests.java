import Auto.pages.AutoHomePage;
import Auto.pages.AutoLoginPage;
import Auto.pages.AutoPlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {
    @Test(enabled = true, priority = 0)
    public void createNewList() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("my list");
        //THEN
        Assert.assertEquals(playListPage.getConfirmationPopupText(), "Created playlist " + "\"" + "my list" + "." + "\"");
    }

    @Test(enabled = true, priority = 1)
    public void deletePlaylist() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.deletingPlaylist();
        //THEN
        Assert.assertEquals(playListPage.getConfirmationMessage(), true);
    }

    @Test(enabled = true, priority = 2)
    public void createNameTwice() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("second");
        //THEN
        Assert.assertEquals(playListPage.getConfirmationPopupText(), "Created playlist " + "\"" + "second" + "." + "\"");
        //REPEAT
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("second");
        //EXPECTED TO BE FALSE
        Assert.assertEquals(playListPage.getConfirmationMessage(), true, "CANNOT ENTER SAME NAME");
    }

    @Test(enabled = true, priority = 3)
    public void createNameWith10Chars() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("thisIsNo10");
        //THEN
        Assert.assertEquals(playListPage.getConfirmationPopupText(), "Created playlist " + "\"" + "thisIsNo10" + "." + "\"");
        Assert.assertEquals(playListPage.getConfirmationMessage(), true);
    }

    @Test(enabled = true, priority = 4)
    public void createNameWith11Chars() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("elevenChars");
        //THEN
        Assert.assertEquals(playListPage.getConfirmationMessage(), true);
    }

    @Test(enabled = true, priority = 5)
    public void createNameTwoChars() {
        //GIVEN
        AutoLoginPage loginPage = new AutoLoginPage(driver);
        AutoHomePage homePage = new AutoHomePage(driver);
        AutoPlaylistPage playListPage = new AutoPlaylistPage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
        //WHEN
        playListPage.playListArea();
        playListPage.addingPlaylistbtn();
        playListPage.enterPlayListName("to");
        //THEN
        Assert.assertEquals(playListPage.getConfirmationMessage(), true);
    }
}
