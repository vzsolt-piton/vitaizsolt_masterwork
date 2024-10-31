import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlueNavBar;
import pages.ShoppinCartPanel;
import pages.SmartphonePage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCase13 extends BaseTest {

    @Test
    @DisplayName("Delete item from shopping cart")
    @Description("Add a product to the shopping cart then delete it.")
    @Feature("Shopping cart")
    public void deleteItemFromCart() {
        LOG.debug("Creating BlueNavBar object");
        blueNavBar = new BlueNavBar(driver);
        LOG.debug("Creating SmartphonePage object");
        smartphonePage = new SmartphonePage(driver);
        LOG.debug("Creating ShoppinCartPanel object");
        shoppinCartPanel = new ShoppinCartPanel(driver);
        LOG.info("Clicking on Phones & PDAs tab on the blue navbar");
        blueNavBar.clickOnPhonesNavTab();
        LOG.info("Clicking the Palm Treo Pro product's 'ADD TO CART' button");
        smartphonePage.addPalmTreoPhoneToTheCart();
        LOG.info("Clicking on the black shopping cart button");
        shoppinCartPanel.clickOnOpenShoppingCartPanel();
        LOG.info("Clicking on the red 'X' button next to the phone");
        shoppinCartPanel.removePalmTreoPhoneFromCart();
        LOG.info("Clicking on the black shopping cart button");
        shoppinCartPanel.clickOnOpenShoppingCartPanel();
        LOG.info("After opening the shopping cart panel you should see a text telling 'Your shopping cart is empty!'");
        assertThat(shoppinCartPanel.isYourCartIsEmptyTextVisible()).isTrue();
    }
}
