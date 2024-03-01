import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearup() {
        Driver.quitDriver();
    }
}
