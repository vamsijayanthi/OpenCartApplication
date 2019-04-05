package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;

public class CaptureScreenShot {

    @Test
    public static void captureScreenMethod() throws Exception{
        System.setProperty("webdriver.gecko.driver","D://Selenium Environment//Drivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        try{
            driver.get("https://www.softwaretestingmaterial.com");
            driver.navigate().refresh();
            //driver.findElement(By.xpath("//*[@id='cse-search-box']/div/input[4]")).sendKeys("agile"); //Statement with correct Xpath
            driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("agile"); //Statement with incorrect Xpath
        }catch(Exception e){

            TakesScreenshot ts=(TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            String path=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+System.currentTimeMillis()+".png";
            File destination=new File(path);

            /*File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));*/
        }


        driver.close();
        driver.quit();
    }
}
