package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(id = "defaultLoginFormUsername")
    WebElement username;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement password;

    @FindBy(id = "sign-in-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginUrl() {
        verifyUrl(LOGIN_URL);
    }

    public void login(String _username, String _password) {
        enterText(username, _username);
        enterText(password, _password);
        clickElement(loginButton);

    }

}
