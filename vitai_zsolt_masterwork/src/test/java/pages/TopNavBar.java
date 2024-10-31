package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavBar extends BasePage {

    @FindBy(className = "dropdown")
    WebElement myAccountButton;
    @FindBy(linkText = "Register")
    WebElement registerButton;
    @FindBy(linkText = "Login")
    WebElement loginButton;
    @FindBy(linkText = "Logout")
    WebElement logoutButton;


    public TopNavBar(WebDriver driver) {
        super(driver);
    }

    public void openDropdown() {
        myAccountButton.click();
    }

    public void clickOnRegister() {
        registerButton.click();
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

}
