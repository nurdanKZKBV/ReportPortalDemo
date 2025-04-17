package report_portal.ui.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import report_portal.ui.driver.Driver;
import report_portal.ui.helper.BrowserManager;
import report_portal.ui.helper.WebElementActions;

public class BasePage {
    public WebDriver driver;
    public Actions actions;
    public WebElementActions webElementActions;
    public BrowserManager browserManager;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);
    }
}
