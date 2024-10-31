import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegisterFormPage;
import pages.TopNavBar;

import static org.assertj.core.api.Assertions.*;

public class TestCase05 extends BaseTest {

    @Test
    @DisplayName("Privacy Policy Checking")
    @Description("Opening the Privacy Policy and accepting it on the registration form.")
    @Feature("Registration")
    public void successfulPrivacyPolicyCheck() {
        LOG.debug("Creating TopNavBar object");
        topNavBar = new TopNavBar(driver);
        LOG.debug("Creating RegisterFormPage object");
        registerFormPage = new RegisterFormPage(driver);
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Register in the dropdown");
        topNavBar.clickOnRegister();
        LOG.info("Clicking on Privacy Policy linked label");
        registerFormPage.openPrivacyPolicy();
        LOG.info("Clicking on Privacy Policy's closer 'X' button");
        registerFormPage.closePrivacyPolicy();
        LOG.info("Accepting Privacy Policy");
        registerFormPage.clickOnPrivacyPolicyAgree();
        LOG.info("Privacy Policy checkbox should be checked in");
        assertThat(registerFormPage.isPrivacyPolicyAccepted()).isTrue();
    }

}
