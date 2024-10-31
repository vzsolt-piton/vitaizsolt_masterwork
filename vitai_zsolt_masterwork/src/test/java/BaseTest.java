import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected Logger LOG;
    protected HomePage homePage;
    protected RegisterFormPage registerFormPage;
    protected TopNavBar topNavBar;
    protected RegisterSuccessPage registerSuccessPage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected BlueNavBar blueNavBar;
    protected SmartphonePage smartphonePage;
    protected DesktopsPage desktopsPage;
    protected MacDesktopsPage macDesktopsPage;
    protected ProductPage productPage;
    protected AccountInformationPage accountInformationPage;
    protected ShoppinCartPanel shoppinCartPanel;
    protected LogoutSuccessPage logoutSuccessPage;
    protected String generatedEmail = "testvzs" + (int) (Math.random() * (9999999 - 1) + 1) + "@gmail.com";

    @BeforeEach
    public void setup() throws IOException {
        LOG = LoggerFactory.getLogger(getClass());
        String browser;
        LOG.debug("File reading test.properties");
        InputStream ioStream = this.getClass().getResourceAsStream("test.properties");
        Properties properties = new Properties();
        properties.load(ioStream);
        browser = properties.getProperty("browser");
        if (browser.equals("chrome")) {
            LOG.info("Chrome driver setup");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            LOG.info("Firefox driver setup");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            LOG.info("Edge driver setup");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        LOG.info("Setting the browser window to maximum size");
        driver.manage().window().maximize();
        LOG.debug("Initializing home page load function");
        loadHomePage();
    }


    public void loadHomePage() {
        LOG.debug("Creating home page object");
        homePage = new HomePage(driver);
        LOG.info("Loading home page");
        homePage.load();
    }

    @AfterEach
    public void tearDown() {
        LOG.info("Quitting the browser driver");
        driver.quit();
    }

}