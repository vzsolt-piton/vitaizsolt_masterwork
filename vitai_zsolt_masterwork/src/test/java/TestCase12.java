import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountInformationPage;
import pages.AccountPage;
import pages.LoginPage;
import pages.TopNavBar;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCase12 extends BaseTest {

    @Test
    @DisplayName("Edit account's telephone number")
    @Description("Editing an existing account's telephone number.")
    @Feature("Account")
    public void changeTelephoneNumber() {
        LOG.debug("Creating TopNavBar object");
        topNavBar = new TopNavBar(driver);
        LOG.debug("Creating LoginPage object");
        loginPage = new LoginPage(driver);
        LOG.debug("Creating AccountPage object");
        accountPage = new AccountPage(driver);
        LOG.debug("Creating AccountInformationPage object");
        accountInformationPage = new AccountInformationPage(driver);
        LOG.debug("Creating generatedTelephoneNumber String phone number");
        String generatedTelephoneNumber = "+3670" + (int) (Math.random() * (9999999 - 1000000) + 1);
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Login in the dropdown");
        topNavBar.clickOnLogin();
        LOG.info("Filling in the login form - then submit");
        loginPage.fillLoginFields("sucesstest@gmail.com", "Qweqwe321-");
        LOG.info("Clicking on 'Edit your account information' named linked label");
        accountPage.clickOnAccountEditLabel();
        LOG.info("Changing the Telephone number");
        accountInformationPage.writeTelephoneNumber(generatedTelephoneNumber);
        LOG.info("Clicking on Continue to submit the form");
        accountInformationPage.submitAccountInfoEdit();
        LOG.info("Clicking on 'Edit your account information' named linked label");
        accountPage.clickOnAccountEditLabel();
        LOG.info("The telephone number's change should be still there");
        assertThat(accountInformationPage.getTelephoneNumber()).isEqualTo(generatedTelephoneNumber);
    }
}
