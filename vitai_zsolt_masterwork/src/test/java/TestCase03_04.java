import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.assertj.core.api.Assertions.*;

public class TestCase03_04 extends BaseTest {

    @BeforeEach
    public void init() {
        LOG.debug("Creating TopNavBar object");
        topNavBar = new TopNavBar(driver);
        LOG.debug("Creating LoginPage object");
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Successful login")
    @Description("Logging in to the web shop with an existing account.")
    @Feature("Login")
    public void successfulLogin() {
        LOG.debug("Creating AccountPage object");
        accountPage = new AccountPage(driver);
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Login in the dropdown");
        topNavBar.clickOnLogin();
        LOG.info("Filling in the login form - then submit");
        loginPage.fillLoginFields("sucesstest@gmail.com", "Qweqwe321-");
        LOG.info("The newly loaded page should have a linked label telling 'Edit your account information'");
        assertThat(accountPage.isAccountEditLabelVisible()).isTrue();
    }

    @Test
    @DisplayName("Unsuccessful login")
    @Description("Attempt to login to the web shop without giving a password. This way it will be an unsuccessful login.")
    @Feature("Login")
    public void unsuccessfulLogin() {
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Login in the dropdown");
        topNavBar.clickOnLogin();
        LOG.info("Filling in the login form without giving the password - then submit");
        loginPage.fillLoginFields("failtest@gmail.com", "");
        LOG.info("After the submit we should see an error panel telling 'Warning: Warning: No match for E-Mail Address and/or Password.'");
        assertThat(loginPage.isLoginErrorPanelVisible()).isTrue();
    }
}
