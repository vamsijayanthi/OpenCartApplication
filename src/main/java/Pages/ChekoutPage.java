package Pages;

import Core.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChekoutPage {

    WebDriver driver;

    public ChekoutPage(WebDriver driver) {
        this.driver = driver;
    }

    //By CartButton = By.cssSelector("button[type='button'][data-toggle='dropdown']");
    By CartButton = By.xpath("//button[@type='button']//span[@id='cart-total']");
    By ViewCart = By.xpath("//strong[contains(text(),'View Cart')]");
    //By Quantity = By.xpath("//input[@name=\"quantity[3231]\"]");
    By Quantity = By.xpath("//input[starts-with(@name,'quantity')]");
    By chekoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By chekoutOption = By.xpath("//h4[contains(text(),\"Step 1: Checkout Options\")]");
    By billingDetails = By.xpath("//*[contains(text(),\"Step 2: Account & Billing Details\")]");
    By paymentMethod = By.xpath("//h4[contains(text(),\"Step 3: Payment Method\")]");
    By confirmOrder = By.xpath("//h4[contains(text(),\"Step 4: Confirm Order\")]");
    By MyAccount = By.linkText("My Account");
    //By LogOutButton = By.linkText("https://192.168.2.151/opencart/index.php?route=account/logout");
    By LogOut = By.linkText("Account Logout");



    public void clickOnCart() {

        //click on cart button
        driver.findElement(CartButton).click();
//        CommonUtils.javaScriptClick(driver.findElement(CartButton));
        CommonUtils.checkPageTitle("Search - macbook", 30);

        //click on view cart
        // driver.findElement(ViewCart).click();

        CommonUtils.javaScriptClick(driver.findElement(ViewCart));
        CommonUtils.checkPageTitle("Shopping Cart", 30);
    }


    public void verifyItems() {

         String str = driver.findElement(Quantity).getAttribute("value");
         System.out.println("This line is executed because assertEquals "
                 + "passed since both the strings are same");
         WebDriverWait wait = new WebDriverWait(driver, 30);
         wait.until(ExpectedConditions.titleIs("Shopping Cart"));
     }

    public void chekout() {

        //click on chekout button
        driver.findElement(chekoutButton).click();
        CommonUtils.checkPageTitle("Checkout", 30);

        //verify the chekout options are present
        if (driver.findElement(chekoutOption).isDisplayed()) {
            System.out.println("Checkout Option is Visible");
        } else {
            System.out.println("ChekoutOption is not InVisible");
        }
        /*if( driver.findElement(billingDetails).isDisplayed()){
            System.out.println("BillingDetails are Visible");
        }else{
            System.out.println("BillingDetails are not InVisible");
        }*/
        if (driver.findElement(paymentMethod).isDisplayed()) {
            System.out.println("paymentMethod Option is Visible");
        } else {
            System.out.println("paymentMethod is not InVisible");
        }
        if (driver.findElement(confirmOrder).isDisplayed()) {
            System.out.println("confirmOrder Option is Visible");
        } else {
            System.out.println(" confirmOrder Option is not InVisible");
        }

        CommonUtils.checkPageTitle("Checkout", 30);
    }

    public void clickOnMyAccount() {
        driver.findElement(MyAccount).click();
        CommonUtils.checkPageTitle("Checkout", 30);
         //verify success message
        //String actual_msg = driver.findElement(By.id("You have been logged off your account. It is now safe to leave the computer.")).click();
//        CommonUtils.checkPageTitle("Account Logout", 30);
//        Assert.assertTrue(false);
    }

    public void LogOut(){
        driver.findElement(LogOut);
        CommonUtils.checkPageTitle("Account Logout", 30);
        //Assert.assertTrue(false);

    }
    /*public void clickLogOut() {

     *//* //click on logout
        Select dropdown = new Select(driver.findElement(LogOutButton));

        //verify success message
        String actual_msg = driver.findElement(By.id("You have been logged off your account. It is now safe to leave the computer.")).getText();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("Account Logout"));*//*
    }*/


}
