package TestCase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

    int count =1;
    int maxRetryCount = 2;

    public boolean retry(ITestResult iTestResult) {
        if(count < maxRetryCount){
            System.out.println("Retrying " + iTestResult.getName() + " again and the count is " + (count+1));
            count++;
            return true;
        }
        return false;
    }
}
