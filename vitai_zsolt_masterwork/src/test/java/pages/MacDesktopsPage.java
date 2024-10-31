package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacDesktopsPage extends BasePage {

    @FindBy(linkText = "iMac")
    WebElement iMacProduct;

    public MacDesktopsPage(WebDriver driver) {
        super(driver);
    }

    public void openIMacProduct() {
        iMacProduct.click();
    }
}
