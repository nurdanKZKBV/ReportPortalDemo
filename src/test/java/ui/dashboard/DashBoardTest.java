package ui.dashboard;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import report_portal.fileUtils.ConfigReader;
import ui.base.BaseTest;

public class DashBoardTest extends BaseTest {
    @BeforeEach
    @Step("authorization")
    public void setUp() {
        browserManager.openURL("https://demo.reportportal.io/");
        loginPage.doLogin(ConfigReader.getCredential("username"), ConfigReader.getCredential("password"));
    }

    @Tag("ui")
    @Step("Проверка успешного добавления виджета")
    @Epic("Dashboard")
    @Feature("Widgets")
    @Story("Добавление нового виджета на дашборд")
    @Owner("Nurdan")
    @Test
    public void addNewWidgetTest(){
        dashBoardPage.addNewWidget();
        String successfulWidgetText = "Widget has been added successfully";
        Assertions.assertTrue(webElementActions.isDisplayed(dashBoardPage.getWidgetSuccessField()));
        Assertions.assertEquals(successfulWidgetText, dashBoardPage.getWidgetSuccessField().getText());
    }
}
