package TestCase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

//import org.apache.logging.log4j.core.util.FileUtils;

public class BaseClass {

        WebDriver driver;
        ExtentReports extent;
        ExtentTest logger;

        /*@BeforeClass
        public void setReport(){
            ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ZenqExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        @BeforeMethod
        public void setupApplication(Method method) throws IOException {
           // logger = extent.createTest(method.getName());
         *//*   driver = WebdriverManager.getWebDriver();
            driver.get("http://192.168.2.151/opencart/index.php?");*//*
            logger = extent.createTest(method.getName());
         }*/

      /*  @AfterMethod
        public void tearDown(ITestResult result) throws IOException
        {
            if(result.getStatus()==ITestResult.FAILURE)
            {
                String temp=getScreenshot(driver);
                logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            }
          // extent.flush();
    //    driver.quit();
        }*/

        public static String getScreenshot(WebDriver driver)
        {
            TakesScreenshot ts=(TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            String path=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+System.currentTimeMillis()+".png";
            File destination=new File(path);
            try
            {
                FileUtils.copyFile(src,destination);
            } catch (IOException e)
            {
                System.out.println("Capture Failed "+e.getMessage());
            }
            return path;
        }
    }

