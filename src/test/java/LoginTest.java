import annotations.FrameworkAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ResetPasswordPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @FrameworkAnnotations
    @Test
    public void loginValidationTest() {
        String actualTitle = loginPage.logintoApplication("Admin", "admin123").getHomePageTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
    }

    @FrameworkAnnotations
    @Test
    public void invalidCredentialsMessageValidation() {
        String actual = loginPage.invalidCredentialValidation("Admin", "123456");
        Assert.assertEquals(actual, "Invalid credentials");
    }
}
