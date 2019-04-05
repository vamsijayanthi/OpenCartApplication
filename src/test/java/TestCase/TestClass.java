package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass  {

    @Test(retryAnalyzer = RetryFailedTestCases.class)
    public void FailedTestCase(){
        System.out.println("Failed scenario");
        Assert.assertTrue(false);

    }
}
