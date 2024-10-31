package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends BasePage {

    @FindBy(css = "div[class = 'caption']>h4")
    List<WebElement> deskptopsList;
    @FindBy(linkText = ">")
    WebElement goToNextPageOfDesktops;

    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> listOutDekstopProducts() {
        List<String> listOfDesktopNames = new ArrayList<>();
        for (WebElement element : deskptopsList) {
            listOfDesktopNames.add(element.getText());
        }
        return listOfDesktopNames;
    }

    public void moveToTheNextPageOfDesktop() {
        goToNextPageOfDesktops.click();
    }
}
