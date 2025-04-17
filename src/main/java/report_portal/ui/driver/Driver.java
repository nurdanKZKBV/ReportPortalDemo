package report_portal.ui.driver;

import org.openqa.selenium.WebDriver;
import report_portal.fileUtils.ConfigReader;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getAppProperty("browserType")) {
                case "chrome":
                    driver = ChromeWebDriver.loadFromDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFromDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadFromDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + ConfigReader.getAppProperty("browserType"));
            }
        }
        return driver;
    }
}

