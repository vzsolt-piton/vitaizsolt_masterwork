package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutSuccessPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement successLogoutMainTitle;

    public LogoutSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessTitleLoaded() {
        return successLogoutMainTitle.isDisplayed();
    }
}
