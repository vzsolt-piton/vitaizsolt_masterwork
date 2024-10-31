package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(linkText = "Reviews (0)")
    WebElement reviewsTab;
    @FindBy(id = "input-name")
    WebElement yourNameField;
    @FindBy(id = "input-review")
    WebElement yourReviewField;
    @FindBy(id = "button-review")
    WebElement reviewSubmitButton;
    @FindBy(css = "div[class = 'alert alert-success alert-dismissible']")
    WebElement reviewIsSubmittedPanel;
    @FindBy(css = "div[class = 'col-sm-4']>h1")
    WebElement nameOfTheProduct;
    @FindBy(css = "div[id = 'tab-description']>p")
    WebElement descriptionOfTheProduct;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openReviewsTab() {
        reviewsTab.click();
    }

    public void fillInTheReview(String givenName, String givenReview, int givenRating) {
        WebElement ratingValue = driver.findElement(By.cssSelector("input[value = '" + givenRating + "']"));
        yourNameField.sendKeys(givenName);
        yourReviewField.sendKeys(givenReview);
        ratingValue.click();
    }

    public void reviewSubmit() {
        reviewSubmitButton.click();
    }

    public boolean reviewHasBeenSubmittedPanelIsVisible() {
        return wait.until(ExpectedConditions.elementToBeClickable(reviewIsSubmittedPanel)).isDisplayed();
    }

    public List<String> getDescAndNameOfTheProduct() {
        List<String> listOfProductNames = new ArrayList<>();
        listOfProductNames.add(nameOfTheProduct.getText());
        listOfProductNames.add(descriptionOfTheProduct.getText());
        return listOfProductNames;
    }
}
