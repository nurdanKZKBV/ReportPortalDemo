package report_portal.ui.pages.main_menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report_portal.ui.pages.base.BasePage;

public class MainMenuPage extends BasePage {

    @FindBy(xpath = "//a[@href='#default_personal/dashboard' and contains(@class, 'sidebarButton__nav-link--gZnHQ')]")
    public WebElement dashBoards;
}
