package TestCase;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListner implements IAnnotationTransformer {
    private Object IRetryAnalyzer;

    //public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();

        if(IRetryAnalyzer == null){
            iTestAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
        }
        
    }
}
