package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    public static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

   private DriverManager(){}
    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
