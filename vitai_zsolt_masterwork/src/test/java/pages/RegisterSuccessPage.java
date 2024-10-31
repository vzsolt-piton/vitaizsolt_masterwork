package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSuccessPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement successRegisterMainTitle;

    public RegisterSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessTitleLoaded() {
        return successRegisterMainTitle.isDisplayed();
    }
}
