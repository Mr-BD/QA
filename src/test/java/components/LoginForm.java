package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm {
    private final WebDriver driver;
    private final Utils utils;


    @FindBy(id = "defaultLoginFormUsername")
    WebElement username;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement password;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void login() {
//        fill username
        utils.typeInInput(this.username, "auto_user");
//        fill password
//        click Sign In button

    }

    public void test() {
        System.out.println("Jsdfskldfjsdfsdf");
    }

}
