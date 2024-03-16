package Utils;

import config.ConfigFactory;
import driver.DriverManager;
import enums.WaitStrategy;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void click(By by, String waitStrategy){
        if (waitStrategy.equalsIgnoreCase(WaitStrategy.PRESENT.getWaitStrategy())) {
            waitUntilElementPresent(by).click();
        } else if (waitStrategy.equalsIgnoreCase(WaitStrategy.CLICKABLE.getWaitStrategy())) {
            waitUntilElementToBeClickable(by).click();
        }
    }
    public static void sendKeys(By by, String value){
        waitUntilElementPresent(by).sendKeys(value);
    }
    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
       return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private static WebElement waitUntilElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String getTitle(By by){
       return waitUntilElementPresent(by).getText();
    }

    public static void isEnabled(By by){
        waitUntilElementPresent(by).isEnabled();
    }

    public static void isSelected(By by){
        waitUntilElementPresent(by).isSelected();
    }

    public static void moveToElement(By by){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(waitUntilElementPresent(by)).build().perform();
    }
}
