package pages;

import static Utils.SeleniumUtils.*;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class ResetPasswordPage {

    private final By RESET_PASSWORD_TITLE = By.xpath("//h6[text()='Reset Password']");

    private final By CANCEL_BUTTON = By.xpath("//button[@type = 'button']");
    private final By ENTER_RESET_DETAILS_TEXT = By.xpath("//p[@class = 'oxd-text oxd-text--p']");

    private final By RESET_PAGE_USERNAME = By.xpath("//input[@name = 'username']");
    private final By RESET_PASSWORD_BUTTON = By.xpath("//button[@type = 'submit']");
    private final By RESET_SUCCESS = By.xpath("//h6");

    public String getResetPasswordPageTitle(){
        return getTitle(RESET_PASSWORD_TITLE);
    }


    public LoginPage clickCancel() {
        click(CANCEL_BUTTON, String.valueOf(WaitStrategy.CLICKABLE));
        return new LoginPage();
    }

    public void enterResetUsername(String  username){
        sendKeys(RESET_PAGE_USERNAME, username);
    }

    public String getResetMessage(){
        return getTitle(RESET_SUCCESS);
    }
    public void clickResetPassword(){
        click(RESET_PASSWORD_BUTTON, String.valueOf(WaitStrategy.CLICKABLE));
    }
}
