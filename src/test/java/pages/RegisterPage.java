package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    public static final String REGISTER_URL = "http://training.skillo-bg.com:4200/users/register";

    @FindBy(name = "username")
    WebElement username;

    @FindBy(css = "input[type='email']")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "verify-password")
    WebElement confirmPassword;

    @FindBy(id = "sign-in-button")
    WebElement submitButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(REGISTER_URL);
    }

    public String fillFormAndSubmit() {
        Faker faker = new Faker();
        int randomDigit = faker.number().randomDigit();
        String fakerUsername = faker.name().firstName().concat(String.valueOf(randomDigit));
        String fakerEmail = fakerUsername.concat("@abv.bg");
        String fakerPassword = faker.internet().password(6, 16);

        enterText(username, fakerUsername);
        enterText(email, fakerEmail);
        enterText(password, fakerPassword);
        enterText(confirmPassword, fakerPassword);
        clickElement(submitButton);

        return fakerUsername;
    }

}
