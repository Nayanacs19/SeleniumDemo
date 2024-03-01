package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

    private ExtentReportManager(){}
    private static final ThreadLocal<ExtentTest> EXTENT_TEST_LOCAL = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return EXTENT_TEST_LOCAL.get();
    }

    static void setExtentTestLocal(ExtentTest test){
        EXTENT_TEST_LOCAL.set(test);
    }

}
