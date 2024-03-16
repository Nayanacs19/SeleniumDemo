package listeners;

import annotations.FrameworkAnnotations;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;
import reports.ExtentReportLogger;

import java.io.IOException;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTests(result.getName());
        ExtentReport.assignAuthor(result.getMethod()
                .getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).author());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentReportLogger.pass(result.getName()+ " is Passed");
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportLogger.fail(result.getName()+ " is failed");
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
