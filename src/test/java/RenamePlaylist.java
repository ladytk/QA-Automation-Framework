import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest{


    @Test
    public void renamePlaylist () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("tasiakwiggins@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        Assert.assertTrue(homePage.isUserAvatarDisplayed());

        doubleclickPlaylist();
        renamingPlaylist();
        validateNewPlaylist();

    }

    private void validateNewPlaylist() {
        WebElement newPlaylist = getDriver().findElement(By.cssSelector("li.playlist:nth-child(3)"));
        Assert.assertTrue(newPlaylist.isDisplayed());
    }

    private void renamingPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement editingName = getDriver().findElement(By.cssSelector("input[name='name']"));
        editingName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        editingName.sendKeys("The Office");
        editingName.sendKeys(Keys.RETURN);
    }

    private void doubleclickPlaylist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.playlist:nth-child(3)")));
        By playlistSelection = By.cssSelector("li.playlist:nth-child(3)");
        WebElement doubleClicking = getDriver().findElement(playlistSelection);
        actions.doubleClick(doubleClicking).perform();
    }
}

