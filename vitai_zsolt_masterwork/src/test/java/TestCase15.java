import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.LogoutSuccessPage;
import pages.TopNavBar;

import static org.assertj.core.api.Assertions.*;

public class TestCase15 extends BaseTest {

    @Test
    @DisplayName("Successful logout")
    @Description("Logging out from the web shop.")
    @Feature("Logout")
    public void successfulLogout() {
        LOG.debug("Creating BlueNavBar object");
        topNavBar = new TopNavBar(driver);
        LOG.debug("Creating LoginPage object");
        loginPage = new LoginPage(driver);
        LOG.debug("Creating AccountPage object");
        accountPage = new AccountPage(driver);
        LOG.debug("Creating LogoutSuccessPage object");
        logoutSuccessPage = new LogoutSuccessPage(driver);
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Login in the dropdown");
        topNavBar.clickOnLogin();
        LOG.info("Filling in the login form - then submit");
        loginPage.fillLoginFields("sucesstest@gmail.com", "Qweqwe321-");
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Logout in the dropdown");
        topNavBar.clickOnLogout();
        LOG.info("The newly loaded page should have a h1 element telling 'Account Logout'");
        assertThat(logoutSuccessPage.isSuccessTitleLoaded()).isTrue();
    }
}
