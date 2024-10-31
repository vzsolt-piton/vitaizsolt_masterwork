package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInformationPage extends BasePage {

    @FindBy(name = "telephone")
    WebElement telephoneField;

    @FindBy(css = "input[type = 'submit']")
    WebElement accountEditSubmit;

    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }

    public void writeTelephoneNumber(String givenTelephoneNumber) {
        telephoneField.clear();
        telephoneField.sendKeys(givenTelephoneNumber);
    }

    public void submitAccountInfoEdit() {
        accountEditSubmit.click();
    }

    public String getTelephoneNumber() {
        return telephoneField.getAttribute("value");
    }
}
