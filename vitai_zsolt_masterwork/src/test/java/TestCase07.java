import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlueNavBar;
import pages.DesktopsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCase07 extends BaseTest {

    @Test
    @DisplayName("Desktops products pagination")
    @Description("Opening the desktops tab and after the load go to the next page to check the reload in the list of products.")
    @Feature("Product Listing")
    public void desktopPagePaginationCheck() {
        LOG.debug("Creating BlueNavBar object");
        blueNavBar = new BlueNavBar(driver);
        LOG.debug("Creating DesktopsPage object");
        desktopsPage = new DesktopsPage(driver);
        LOG.info("Clicking on Desktops tab on the blue navbar - then Show All Desktops in the dropdown");
        blueNavBar.openAllDesktops();
        LOG.debug("Creating firstPageOfDesktopNames ArrayList to collect desktop products");
        List<String> firstPageOfDesktopNames = desktopsPage.listOutDekstopProducts();
        LOG.info("At the end of the list of desktops click on the '>' next page button");
        desktopsPage.moveToTheNextPageOfDesktop();
        LOG.info("The two list of desktop products should not match");
        assertThat(firstPageOfDesktopNames).isNotEqualTo(desktopsPage.listOutDekstopProducts());
    }
}
