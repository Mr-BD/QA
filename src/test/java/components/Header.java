package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Header extends BasePage {

    @FindBy(id = "nav-link-login")
    WebElement loginLink;

    @FindBy(id = "nav-link-home")
    WebElement homeLink;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    @FindBy(id = "nav-link-profile")
    WebElement profileLink;


    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        clickElement(loginLink);
    }

    public void goToProfilePage() {
        clickElement(profileLink);
    }

    public void goToCreatePostPage() {
        clickElement(newPostLink);

    }


}
