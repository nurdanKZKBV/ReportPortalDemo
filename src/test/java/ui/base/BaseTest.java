package ui.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report_portal.ui.driver.Driver;
import report_portal.ui.helper.BrowserManager;
import report_portal.ui.helper.WebElementActions;
import report_portal.ui.pages.dashboard.DashBoardPage;
import report_portal.ui.pages.login.LoginPage;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;
    public static Actions actions;
    public static WebElementActions webElementActions;
    public static BrowserManager browserManager;
    public static WebDriverWait wait;

    public LoginPage loginPage = new LoginPage();
    public DashBoardPage dashBoardPage = new DashBoardPage();

    @BeforeAll
    public static void beforeSuite() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterAll
    public static void afterSuite() {
        driver.close();
        driver.quit();
    }
}
