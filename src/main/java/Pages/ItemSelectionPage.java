package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemSelectionPage {

    WebDriver driver;

    public ItemSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Elements Declaration
    By SearchText = By.cssSelector("input[name='search']");
    By SearchButton = By.xpath("//span[@class=\"input-group-btn\"]//button");
    //    By CartButton = By.xpath("//*[@class= 'btn btn-inverse btn-block btn-lg dropdown-toggle']");
    //By ViewCart = By.xpath("//*[contains(text(),\" View Cart\")]");
    // By CurrentPage = By.xpath("//span[contains(@class,\"hidden-xs hidden-sm hidden-md\")] [contains(text(),'Add to Cart')]");
    By Message = By.xpath("//*[@class=\"alert alert-success alert-dismissible\"]");
    By CurrentPage = By.xpath("(//div[@class=\"product-thumb\"]//button[@type=\"button\"])[1]");


    public void searchItem(String keyword) {
        driver.findElement(SearchText).sendKeys(keyword);
        driver.findElement(SearchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("Search - " + keyword));
    }

    public void addItemToCart() {
        //ADD ITEM TO CART
        driver.findElement(CurrentPage).click();
        //Verify success Message
        driver.findElement(Message).getText();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("Search - macbook"));
    }
}
