package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreatePostPage extends BasePage {
    public final String CREATE_POST_URL = "http://training.skillo-bg.com:4200/posts/create";


    @FindBy(name = "caption")
    WebElement postCaption;

    @FindBy(className = "input-lg")
    WebElement uploadedImageName;

    @FindBy(id = "create-post")
    WebElement submitButton;


    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCreatePostUrl() {
        verifyUrl(CREATE_POST_URL);
    }

    public void createPost() {
        
    }

}
