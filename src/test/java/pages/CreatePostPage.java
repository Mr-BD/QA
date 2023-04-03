package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class CreatePostPage extends BasePage {
    public final String CREATE_POST_URL = "http://training.skillo-bg.com:4200/posts/create";


    @FindBy(name = "caption")
    WebElement postCaption;

    @FindBy(className = "input-lg")
    WebElement uploadedImageName;

    @FindBy(className = "file-preview")
    WebElement imagePreview;

    @FindBy(id = "create-post")
    WebElement submitButton;

    @FindBy(css = "input.file[type='file']")
    WebElement fileUploadInput;


    public CreatePostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCreatePostUrl() {
        verifyUrl(CREATE_POST_URL);
    }

    public void waitForImageToBeUploaded() {
        smallWait.until(ExpectedConditions.visibilityOf(imagePreview));
    }

    public void uploadImage(File image) {
        fileUploadInput.sendKeys(image.getAbsolutePath());
        waitForImageToBeUploaded();
    }

    public void createPost(String caption, File image) {
        enterText(postCaption, caption);
        uploadImage(image);
        clickElement(submitButton);
    }

}
