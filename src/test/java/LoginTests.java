import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    provideEmail("dcabdi@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();

    WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
    Assert.assertTrue(avatarIcon.isDisplayed());
    driver.quit();
    }
}
