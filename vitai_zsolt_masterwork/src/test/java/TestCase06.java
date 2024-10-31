import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlueNavBar;
import pages.SmartphonePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TestCase06 extends BaseTest {

    @Test
    @DisplayName("Phone products list")
    @Description("Opening the phones tab and after the load, check the list of names.")
    @Feature("Product Listing")
    public void shouldHaveTheRightThreePhones() {
        LOG.debug("Creating BlueNavBar object");
        blueNavBar = new BlueNavBar(driver);
        LOG.debug("Creating SmartphonePage object");
        smartphonePage = new SmartphonePage(driver);
        LOG.info("Clicking on Phones & PDAs tab on the blue navbar");
        blueNavBar.clickOnPhonesNavTab();
        LOG.info("The two list of phones should match");
        assertThat(smartphonePage.listOutPhoneProducts()).isEqualTo(phoneListMaker());
    }

    private List<String> phoneListMaker() {
        LOG.debug("Creating expectedListOfPhoneNames ArrayList to store the phone names");
        List<String> expectedListOfPhoneNames = new ArrayList<>();
        LOG.debug("Adding phones to the expectedListOfPhoneNames list");
        Collections.addAll(expectedListOfPhoneNames, "HTC Touch HD", "iPhone", "Palm Treo Pro");
        return expectedListOfPhoneNames;
    }
}
