package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    WebElement loginSubmit;

    @FindBy(css = "div[class='alert alert-danger alert-dismissible']")
    WebElement loginErrorPanel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginFields(String givenEmail, String givenPassword) {
        emailField.sendKeys(givenEmail);
        passwordField.sendKeys(givenPassword);
        loginSubmit.click();
    }

    public boolean isLoginErrorPanelVisible() {
        return loginErrorPanel.isDisplayed();
    }
}
