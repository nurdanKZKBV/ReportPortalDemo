package report_portal.ui.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report_portal.ui.pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='login']")
    private WebElement loginField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void doLogin(String username, String password) {
        loginField.clear();
        passwordField.clear();
        webElementActions.sendKeys(this.loginField, username)
                .sendKeys(this.passwordField, password)
                .click(loginBtn);
    }
}
