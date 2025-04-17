package api.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import report_portal.api.application.ReportPortalApp;
import report_portal.api.statics.ReportPortalEndPoints;

public class BaseApiTest {

    public static ReportPortalApp reportPortalApp;

    @Step("Настройка URL для ReportPortal")
    @BeforeAll
    public static void setUp(){
        reportPortalApp = new ReportPortalApp(ReportPortalEndPoints.URL);
    }

}
