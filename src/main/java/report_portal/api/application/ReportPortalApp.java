package report_portal.api.application;

import lombok.Data;
import report_portal.api.controllers.DashboardController;
@Data
public class ReportPortalApp {
    private DashboardController dashboardController;

    public ReportPortalApp(String url) {
        this.dashboardController = new DashboardController(url);
    }
}
