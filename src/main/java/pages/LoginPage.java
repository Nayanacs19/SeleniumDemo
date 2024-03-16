package pages;

import static Utils.SeleniumUtils.*;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage {

    private final By TXTBOX_USERNAME = By.name("username");
    private final By TXTBOX_PASSWORD = By.xpath("//input[@type = 'password']");
    private final By BTN_LOGIN = By.xpath("//button[@type = 'submit']");

    private final By LOGIN_TEXT = By.xpath("//h5[text()='Login']");
    private final By INVALID_CREDENTIAL = By.xpath("//p[text() = 'Invalid credentials']");
    private final By FORGOT_PASSWORD = By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']");

    private LoginPage setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username);
         return this;
    }

    private LoginPage setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }

    public String getLoginPageTitle(){
        return getTitle(LOGIN_TEXT);
    }

    private HomePage setLogin() {
        click(BTN_LOGIN, WaitStrategy.PRESENT.getWaitStrategy());
        return new HomePage();
    }

    private void clickLogin() {
        click(BTN_LOGIN,WaitStrategy.PRESENT.getWaitStrategy());
    }

    private ResetPasswordPage clickForgotPassword() {
        click(FORGOT_PASSWORD, WaitStrategy.CLICKABLE.getWaitStrategy());
        return new ResetPasswordPage();
    }
    private String getInvalidCredentialMessage(){
        return getTitle(INVALID_CREDENTIAL);
    }
    public HomePage logintoApplication(String username, String password) {
        return setUsername(username)
                .setPassword(password)
                .setLogin();
    }

    public ResetPasswordPage validateResetPassword(){
        return clickForgotPassword();
    }

    public String invalidCredentialValidation(String username, String password) {
        setUsername(username).setPassword(password).clickLogin();
        return getInvalidCredentialMessage();
    }
}
