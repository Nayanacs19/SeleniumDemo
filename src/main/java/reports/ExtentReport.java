package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FrameworkConstants;

public final class ExtentReport {

    private ExtentReport(){}

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void initReports(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extentReports.attachReporter(sparkReporter);
    }

    public static void flushReports(){
        extentReports.flush();
    }

    public static void createTests(String test){
        extentTest = extentReports.createTest(test);
        ExtentReportManager.setExtentTestLocal(extentTest);
    }

    public static void assignAuthor(String author){
        ExtentReportManager.getExtentTest().assignAuthor(author);
    }
}
