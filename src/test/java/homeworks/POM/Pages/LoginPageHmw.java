package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHmw extends BasePageHmw{
By emailFieldLocator = By.cssSelector("[type='email']");
By passwordFieldLocator = By.cssSelector("[type='password']");
By submitButtonLocator = By.cssSelector("[type='submit']");


public LoginPageHmw(WebDriver givenDriver){

super(givenDriver);
}
public void clickSubmitButton(){
 driver. findElement(submitButtonLocator).click();
}
public void provideEmail(String email){
 driver.findElement(emailFieldLocator).sendKeys(email);

}
public void providePassword(String password){
 driver.findElement(passwordFieldLocator).sendKeys(password);
}
public void login(){
 provideEmail("abisola@yahoo.com");
 providePassword("te$t$tudent");
 clickSubmitButton();
}
}





