package Core;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) WebdriverManager.getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static boolean checkPageTitle(String expectedTitle, int timeout) {
        WebDriverWait wait = new WebDriverWait(WebdriverManager.getWebDriver(), timeout);
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public static boolean isElementDisplayed(By expectedElement, int timeout) {
        WebDriver driver = WebdriverManager.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(expectedElement))) != null;
    }
}
