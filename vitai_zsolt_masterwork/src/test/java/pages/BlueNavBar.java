package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlueNavBar extends BasePage {

    @FindBy(linkText = "Phones & PDAs")
    WebElement phonesNavTab;
    @FindBy(linkText = "Desktops")
    WebElement desktopsNavTab;
    @FindBy(linkText = "Show All Desktops")
    WebElement showAllDesktopsLabel;
    @FindBy(linkText = "Mac (1)")
    WebElement macDesktops;

    public BlueNavBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnPhonesNavTab() {
        phonesNavTab.click();
    }

    public void openMacDesktops() {
        desktopsNavTab.click();
        macDesktops.click();
    }

    public void openAllDesktops() {
        desktopsNavTab.click();
        showAllDesktopsLabel.click();
    }
}
