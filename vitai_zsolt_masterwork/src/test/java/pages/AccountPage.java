package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(linkText = "Edit your account information")
    WebElement accountEditLabel;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountEditLabelVisible() {
        return accountEditLabel.isDisplayed();
    }

    public void clickOnAccountEditLabel() {
        accountEditLabel.click();
    }
}
