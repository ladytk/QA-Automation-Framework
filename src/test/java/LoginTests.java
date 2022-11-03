import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = false, priority = 0, description = "changing the username")
    public void changeUsernameVerifyTheChange() throws InterruptedException {

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickAvatarIcon();

        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement username= driver.findElement(By.xpath("//input[@name='name']"));
        username.clear();
        username.sendKeys("Abdi");
        Thread.sleep(1000);
        WebElement usernameActual = driver.findElement(By.xpath("//span[@class='name']"));
        WebElement saveBtn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveBtn.click();
        Assert.assertTrue(usernameActual.isDisplayed());
        Thread.sleep(3000);
        tearDownBrowser();
    }
    @Test(enabled = true, priority = 1) //( priority = 1, description = "Login w/ a valid email", dataProvider = "InvalidCredentials", dataProviderClass = BaseTest.class)

    public static void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail();
        loginPage.providePassword();
        loginPage.clickSubmitBtn();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
