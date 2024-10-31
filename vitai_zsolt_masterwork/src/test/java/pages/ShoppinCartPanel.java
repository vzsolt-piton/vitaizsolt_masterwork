package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppinCartPanel extends BasePage {

    @FindBy(css = "button[class = 'btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement openShoppingCartPanel;
    @FindBy(xpath = "//*[@id='cart']/ul/li[1]/table/tbody/tr/td[5]/button")
    WebElement removeFromCartPalmTreo;
    @FindBy(css = "p[class = 'text-center']")
    WebElement yourCartIsEmpty;

    public ShoppinCartPanel(WebDriver driver) {
        super(driver);
    }

    public void clickOnOpenShoppingCartPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(openShoppingCartPanel)).click();
    }

    public void removePalmTreoPhoneFromCart() {
        removeFromCartPalmTreo.click();
    }

    public boolean isYourCartIsEmptyTextVisible() {
        return yourCartIsEmpty.isDisplayed();
    }
}
