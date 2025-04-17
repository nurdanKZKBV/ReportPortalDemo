package report_portal.ui.pages.dashboard;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report_portal.ui.pages.base.BasePage;
import report_portal.ui.pages.main_menu.MainMenuPage;

import java.util.List;
import java.util.Random;

public class DashBoardPage extends BasePage {
    public MainMenuPage mainMenuPage;

    public DashBoardPage() {
        super();
        mainMenuPage = new MainMenuPage();
    }

    @FindBy(xpath = "//button[contains(text(), \"Add\")]")
    protected WebElement addBtn;

    @FindBy(xpath = "//button//span[contains(text(), 'Add new widget')]")
    protected WebElement addNewWidgetBtn;

    @FindBy(xpath = "//label[contains(@class, 'inputRadio__input-radio') and .//div[text()='Test case search']]")
    protected WebElement testCaseSearchBtn;

    @FindBy(xpath = "//span[contains(text(), \"Next step\")]")
    protected WebElement nextStepBtn;

    @FindBy(css = "textarea[placeholder='Enter widget description']")
    protected WebElement descriptionField;

    @Getter
    @FindBy(xpath = "//p[text()='Widget has been added successfully']")
    protected WebElement widgetSuccessField;

    public DashBoardPage addNewWidget(){
        String description = "Task Progress";
        webElementActions.jsClick(mainMenuPage.dashBoards);
        clickRandomDashboardLink();
        webElementActions.click(addNewWidgetBtn)
                .click(testCaseSearchBtn)
                .click(nextStepBtn)
                .sendKeys(descriptionField, description)
                .click(addBtn);
        return this;
    }

    private void clickRandomDashboardLink() {
        List<WebElement> dashboardLinks = driver.findElements(By.xpath("//a[@class='gridCell__grid-cell--EIqeC gridCell__align-left--DFXWN dashboardTable__name--t2a89' and contains(text(), '')]"));
        if (dashboardLinks.isEmpty()) {
            throw new RuntimeException("No dashboard links found with specified text.");
        }
        Random random = new Random();
        WebElement randomLink = dashboardLinks.get(random.nextInt(dashboardLinks.size()));
        webElementActions.scrollToElement(randomLink).click(randomLink);
    }

}
