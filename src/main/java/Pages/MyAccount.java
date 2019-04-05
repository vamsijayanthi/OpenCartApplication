package Pages;

//import jdk.internal.jline.internal.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount {

    WebDriver driver;

    public MyAccount(WebDriver driver){

        this.driver = driver;
    }

    //element declaration
    By MyAccount = By.linkText("My Account");
    By Login = By.linkText("Login");

    public void navigateMyAccount(){
        driver.findElement(MyAccount).click();
        driver.findElement(Login).click();

        WebDriverWait  wait = new WebDriverWait(driver,30);

      //  Assert.assertTrue(MyAccount.equals("Account Login"));

        wait.until(ExpectedConditions.titleIs("Account Login"));

        //Log.info("opencart Application is launched");
    }


}
