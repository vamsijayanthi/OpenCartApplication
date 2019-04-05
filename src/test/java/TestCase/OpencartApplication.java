package TestCase;

import Core.ExcelUtils;
import Core.Log4j;
import Core.WebdriverManager;
import Pages.ChekoutPage;
import Pages.ItemSelectionPage;
import Pages.LoginPage;
import Pages.MyAccount;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.logging.Logger;

public class OpencartApplication extends BaseClass  {

    WebDriver driver = null;
    ExcelUtils excelUtils = new ExcelUtils();
    private static Logger Log = Logger.getLogger(Log4j.class.getName());

    @BeforeTest
    public void driverMethod() {
        driver = WebdriverManager.getWebDriver();
        driver.get("http://192.168.2.151/opencart/index.php?");
    }

    @Test(retryAnalyzer = RetryFailedTestCases.class)
    public void test001_verifyHomePage() throws Exception {
        MyAccount myAccount = new MyAccount(driver);
        LoginPage loginPage = new LoginPage(driver);
        Map<String, String> login = excelUtils.getLoginData("test001_verifyHomePage");
        myAccount.navigateMyAccount();
        loginPage.loginOpencart(login.get("UserName"),login.get("Password"));
        loginPage.verifyYourStoreHomePage();
        Log.info("Web application launched");

    }

    @Test(retryAnalyzer = RetryFailedTestCases.class)
    public void test002_verifyItemavailability() {
        ItemSelectionPage itemSelectionPage  = new ItemSelectionPage(driver);
        itemSelectionPage.searchItem("macbook");
        itemSelectionPage.addItemToCart();
    }

    @Test(retryAnalyzer = RetryFailedTestCases.class)
    public void test003_chekout() {
        ChekoutPage chekoutPage = new ChekoutPage(driver);
        System.out.println("Failed Scenario");
        Assert.assertTrue(false);
        //chekoutPage.verifyItems();
//        chekoutPage.clickOnCart();
//        chekoutPage.chekout();
//        chekoutPage.clickOnMyAccount();
//        chekoutPage.clickOnCart();
    }

}



