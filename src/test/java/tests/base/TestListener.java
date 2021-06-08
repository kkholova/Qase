package tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

public class TestListener implements ITestListener {

        public void onTestStart(ITestResult result) {
            System.out.println(String.format("Test started: %s,",result.getName()));
        }
        //TODO API request to set status of the test
        public void onTestFailure(ITestResult result) {
            WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
            AllureUtils.takeScreenshot(driver);
            System.out.println(String.format("Test failed: %s",result.getName()));

        }

        //TODO create test run using API (add testcases to)
        public void onStart(ITestContext context) {
        }

    }



