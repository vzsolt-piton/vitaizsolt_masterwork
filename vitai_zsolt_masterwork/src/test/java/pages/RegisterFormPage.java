package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterFormPage extends BasePage {

    @FindBy(name = "firstname")
    WebElement firstNameField;
    @FindBy(name = "lastname")
    WebElement lastNameField;
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "telephone")
    WebElement telephoneField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(name = "confirm")
    WebElement confirmPasswordField;
    @FindBy(css = "input[name='agree']")
    WebElement privacyPolicyAgree;
    @FindBy(css = "input[type='submit']")
    WebElement continueSubmit;
    @FindBy(css = "div[class='alert alert-danger alert-dismissible']")
    WebElement privacyPolicyNotAgreeErrorPanel;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    WebElement privacyPolicyLink;
    @FindBy(css = "button[class ='close']")
    WebElement privacyPolicyPanelClose;

    public RegisterFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegisterForm(String givenFirstName, String givenLastName, String givenEmail, String givenTelephone, String givenPassword, String givenConfirmPassword) {
        firstNameField.sendKeys(givenFirstName);
        lastNameField.sendKeys(givenLastName);
        emailField.sendKeys(givenEmail);
        telephoneField.sendKeys(givenTelephone);
        passwordField.sendKeys(givenPassword);
        confirmPasswordField.sendKeys(givenConfirmPassword);
    }

    public boolean isPrivacyPolicyErrorLoaded() {
        return privacyPolicyNotAgreeErrorPanel.isDisplayed();
    }

    public void openPrivacyPolicy() {
        privacyPolicyLink.click();
    }

    public void closePrivacyPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyPanelClose)).click();
    }

    public boolean isPrivacyPolicyAccepted() {
        return privacyPolicyAgree.isSelected();
    }

    public void clickOnPrivacyPolicyAgree() {
        privacyPolicyAgree.click();
    }

    public void registerSubmit() {
        continueSubmit.click();
    }
}
