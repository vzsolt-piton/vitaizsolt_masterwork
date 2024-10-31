package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SmartphonePage extends BasePage {

    @FindBy(css = "div[class = 'caption']>h4")
    List<WebElement> phonesList;
    @FindBy(xpath = "//*[@id='content']/div[2]/div[3]/div/div[2]/div[2]/button[1]")
    WebElement addCartPalmTreo;
    @FindBy(linkText = "HTC Touch HD")
    WebElement openHtcTouchHd;
    @FindBy(linkText = "Palm Treo Pro")
    WebElement openPalmTreoPro;

    public SmartphonePage(WebDriver driver) {
        super(driver);
    }

    public List<String> listOutPhoneProducts() {
        List<String> listOfPhoneNames = new ArrayList<>();
        for (WebElement element : phonesList) {
            listOfPhoneNames.add(element.getText());
        }
        return listOfPhoneNames;
    }

    public void addPalmTreoPhoneToTheCart() {
        addCartPalmTreo.click();
    }

    public void openTheProperitesOfHtcTouchHd() {
        openHtcTouchHd.click();
    }

    public void openTheProperitesOfPalmTreoPro() {
        openPalmTreoPro.click();
    }
}
