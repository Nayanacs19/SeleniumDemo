import annotations.FrameworkAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ResetPasswordPage;

public class ResetPasswordTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @FrameworkAnnotations
    @Test
    public void validateCancelButton(){
        ResetPasswordPage resetPasswordPage = loginPage.validateResetPassword();
        String actual = resetPasswordPage.clickCancel().getLoginPageTitle();
        Assert.assertEquals(actual, "Login");
    }

    @FrameworkAnnotations
    @Test
    public void resetPasswordPageTitleValidationTest(){
        String actualTitle = loginPage.validateResetPassword().getResetPasswordPageTitle();
        Assert.assertEquals(actualTitle, "Reset Password");
    }

    @Test
    @FrameworkAnnotations
    public void resetPasswordValidationTest(){
        ResetPasswordPage resetPasswordPage = loginPage.validateResetPassword();
        resetPasswordPage.enterResetUsername("nainaaa8@gmail.com");
        resetPasswordPage.clickResetPassword();
        Assert.assertEquals(resetPasswordPage.getResetMessage(), "Reset Password link sent successfully");
    }
}
