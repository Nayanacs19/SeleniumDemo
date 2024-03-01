package reports;

import Utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

public final class ExtentReportLogger {

    private ExtentReportLogger() {
    }

    public static void pass(String message) throws IOException {
        ExtentReportManager.getExtentTest()
                .pass(message, MediaEntityBuilder
                        .createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    public static void info(String message){
        ExtentReportManager.getExtentTest().info(message);
    }
}
