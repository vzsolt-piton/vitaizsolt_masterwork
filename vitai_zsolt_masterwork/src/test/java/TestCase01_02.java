import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegisterFormPage;
import pages.RegisterSuccessPage;
import pages.TopNavBar;

import static org.assertj.core.api.Assertions.*;

public class TestCase01_02 extends BaseTest {

    @BeforeEach
    public void init() {
        LOG.debug("Creating TopNavBar object");
        topNavBar = new TopNavBar(driver);
        LOG.debug("Creating RegisterFormPage object");
        registerFormPage = new RegisterFormPage(driver);
    }

    @Test
    @DisplayName("Successful registration")
    @Description("Registering a new user to the web shop successfully.")
    @Feature("Registration")
    public void successfulRegistration() {
        LOG.debug("Creating RegisterSuccessPage object");
        registerSuccessPage = new RegisterSuccessPage(driver);
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Register in the dropdown");
        topNavBar.clickOnRegister();
        LOG.info("Filling the registration form");
        registerFormPage.fillRegisterForm("Teszt", "Elek", generatedEmail, "+36309865673", "Qweqwe123+", "Qweqwe123+");
        LOG.info("Accepting Privacy Policy");
        registerFormPage.clickOnPrivacyPolicyAgree();
        LOG.info("Clicking on Continue to submit the form");
        registerFormPage.registerSubmit();
        LOG.info("The newly loaded page should have a h1 element telling 'Your Account Has Been Created!'");
        assertThat(registerSuccessPage.isSuccessTitleLoaded()).isTrue();
    }

    @Test
    @DisplayName("Unsuccessful registration")
    @Description("Registering a new user to the web shop unsuccessfully. We are not agreeing to the Privacy Policy.")
    @Feature("Registration")
    public void unsuccessfulRegistration() {
        LOG.info("Clicking on My Account dropdown tab on the top gray navbar");
        topNavBar.openDropdown();
        LOG.info("Clicking on Register in the dropdown");
        topNavBar.clickOnRegister();
        LOG.info("Filling in the registration form");
        registerFormPage.fillRegisterForm("Teszt", "Elek", "unsuccessfullreg@gmail.com", "+36309865673", "Qweqwe123+", "Qweqwe123+");
        LOG.info("Clicking on Continue to submit the form");
        registerFormPage.registerSubmit();
        LOG.info("After the submit we should see an error panel telling 'Warning: You must agree to the Privacy Policy!'");
        assertThat(registerFormPage.isPrivacyPolicyErrorLoaded()).isTrue();
    }
}
