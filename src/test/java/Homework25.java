import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class Homework25 extends BaseTest{


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
    @Test(priority = 0)
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("demo@class.com");
//        LoginPage.providePassword("hfdihaio");
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

//    Create your new Lambdatest account with a free trial here https://accounts.lambdatest.com/register
//Add the cloud execution capability to your framework
//Run your tests in the cloud and make sure they pass (check the videos)
//Create a new branch and commit your changes
//Push your code to a remote repository
//Create a pull request
//Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework