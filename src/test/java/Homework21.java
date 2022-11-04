import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist () {
        doubleclickPlaylist();
        renamingPlaylist();
        validateNewPlaylist();

    }

    private void validateNewPlaylist() {
        WebElement newPlaylist = driver.findElement(By.cssSelector("li.playlist:nth-child(3)"));
        Assert.assertTrue(newPlaylist.isDisplayed());
    }

    private void renamingPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement editingName = driver.findElement(By.cssSelector("input[name='name']"));
        editingName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        editingName.sendKeys("New Girl");
        editingName.sendKeys(Keys.RETURN);
    }

    private void doubleclickPlaylist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.playlist:nth-child(3)")));
        By playlistSelection = By.cssSelector("li.playlist:nth-child(3)");
        WebElement doubleClicking = driver.findElement(playlistSelection);
        actions.doubleClick(doubleClicking).perform();

    }
}
//    Create a new file Homework21.java file with @Test annotation in IntelliJ IDEA
//        Using Action Class methods, create/refactor the test case renamePlaylist()
//        Implement Explicit Waits
//        Remove all Thread.sleep implementations
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework