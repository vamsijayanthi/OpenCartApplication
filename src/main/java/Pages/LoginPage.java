package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //elements declaration
    By UserName = By.id("input-email");
    By Password = By.id("input-password");
    By LoginButton = By.xpath("//*[@value='Login']");
    By YourStoreHeader = By.xpath("//h1/a");

    public void loginOpencart(String userName, String passWord) {

        driver.findElement(UserName).sendKeys(userName);
        driver.findElement(Password).sendKeys(passWord);
        driver.findElement(LoginButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("My Account"));
    }

    public void verifyYourStoreHomePage() {
        WebElement element = driver.findElement(YourStoreHeader);
        Assert.assertTrue(element.isDisplayed());
    }
}
