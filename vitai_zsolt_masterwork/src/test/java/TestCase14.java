import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlueNavBar;
import pages.ProductPage;
import pages.SmartphonePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TestCase14 extends BaseTest {

    @Test
    @DisplayName("Saving phone details to a file")
    @Description("Opening two phone products and saving the name and information from it to a csv file.")
    @Feature("Product Details")
    public void saveTwoPhonesInformation() throws IOException {
        LOG.debug("Creating BlueNavBar object");
        blueNavBar = new BlueNavBar(driver);
        LOG.debug("Creating SmartphonePage object");
        smartphonePage = new SmartphonePage(driver);
        LOG.debug("Creating ProductPage object");
        productPage = new ProductPage(driver);
        LOG.debug("Creating detailsOfProducts ArrayList for storing the details");
        List<List<String>> detailsOfProducts = new ArrayList<>();
        LOG.info("Clicking on Phones & PDAs tab on the blue navbar");
        blueNavBar.clickOnPhonesNavTab();
        LOG.info("Clicking the HTC Touch HD product's name");
        smartphonePage.openTheProperitesOfHtcTouchHd();
        LOG.debug("Adding HTC Touch HD details to the list");
        detailsOfProducts.add(productPage.getDescAndNameOfTheProduct());
        LOG.info("Going back one page in the browser");
        driver.navigate().back();
        LOG.info("Clicking the Palm Treo Pro product's name");
        smartphonePage.openTheProperitesOfPalmTreoPro();
        LOG.debug("Adding Palm Treo Pro details to the list");
        detailsOfProducts.add(productPage.getDescAndNameOfTheProduct());
        LOG.info("The file where we saved the details should not be empty");
        assertThat(writeTheDetailsToFile(detailsOfProducts)).isTrue();
    }

    private boolean writeTheDetailsToFile(List<List<String>> collectedData) throws IOException {
        LOG.debug("Creating detailsOfProductsToBeWritten ArrayList for writing the details into a file");
        List<String> detailsOfProductsToBeWritten = new ArrayList<>();
        LOG.debug("Adding the first line to the list");
        detailsOfProductsToBeWritten.add("ProductName;ProductDetails");
        LOG.debug("Giving over the list of details to the list where we fill get the data to the file");
        for (List<String> element : collectedData) {
            detailsOfProductsToBeWritten.add(element.get(0) + ";" + element.get(1));
        }
        LOG.debug("Getting the path to the productDetails.csv file");
        Path productDetailsFile = Paths.get("src/test/resources/productDetails.csv");
        LOG.debug("Writing the details to the file from the list");
        Files.write(productDetailsFile, detailsOfProductsToBeWritten);
        LOG.debug("Creating actualFile File variable");
        File actualFile = new File(String.valueOf(productDetailsFile));
        LOG.debug("Checking if the file is empty or not and return");
        return actualFile.length() > 0;
    }
}
