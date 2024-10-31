import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.BlueNavBar;
import pages.ProductPage;
import pages.MacDesktopsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCase09_10_11 extends BaseTest {

    @ParameterizedTest
    @DisplayName("Review writing three times to a product")
    @Description("Opening a product and write three reviews to it with a csv file")
    @Feature("Product Reviews")
    @CsvFileSource(resources = "reviews.csv", numLinesToSkip = 1, delimiter = ';')
    public void writeOneReview(String yourNameData, String yourReviewData, int yourRating) {
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
        productPage.fillInTheReview(yourNameData, yourReviewData, yourRating);
        LOG.info("Clicking on Continue to submit the form");
        productPage.reviewSubmit();
        LOG.info("After the submit we should see a green panel telling 'Thank you for your review. It has been submitted to the webmaster for approval.'");
        assertThat(productPage.reviewHasBeenSubmittedPanelIsVisible()).isTrue();
    }
}
