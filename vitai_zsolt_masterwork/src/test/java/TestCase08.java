import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlueNavBar;
import pages.ProductPage;
import pages.MacDesktopsPage;

import static org.assertj.core.api.Assertions.*;

public class TestCase08 extends BaseTest {

    @Test
    @DisplayName("Review writing to a product")
    @Description("Opening a product and write a review.")
    @Feature("Product Reviews")
    public void writeOneReview() {
        LOG.debug("Creating BlueNavBar object");
        blueNavBar = new BlueNavBar(driver);
        LOG.debug("Creating MacDesktopsPage object");
        macDesktopsPage = new MacDesktopsPage(driver);
        LOG.debug("Creating ProductPage object");
        productPage = new ProductPage(driver);
        LOG.info("Clicking on Desktops tab on the blue navbar - then Mac in the dropdown");
        blueNavBar.openMacDesktops();
        LOG.info("Clicking the iMac product's name");
        macDesktopsPage.openIMacProduct();
        LOG.info("Clicking on Reviews tab under the pictures");
        productPage.openReviewsTab();
        LOG.info("Filling in the review form");
        productPage.fillInTheReview("Test Review01", "Thank you, it works really well for me! The PC is fast and quiet.", 3);
        LOG.info("Clicking on Continue to submit the form");
        productPage.reviewSubmit();
        LOG.info("After the submit we should see a green panel telling 'Thank you for your review. It has been submitted to the webmaster for approval.'");
        assertThat(productPage.reviewHasBeenSubmittedPanelIsVisible()).isTrue();
    }
}
