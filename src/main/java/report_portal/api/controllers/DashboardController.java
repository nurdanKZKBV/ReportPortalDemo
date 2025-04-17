package report_portal.api.controllers;

import report_portal.api.entitiy.Dashboard;
import report_portal.api.statics.ReportPortalEndPoints;

public class DashboardController extends ApiRequests{
    public DashboardController(String url) {
        super(url);
    }


    public Dashboard createDashboard(Dashboard dashboard){
        return super.post(getEndpoint(ReportPortalEndPoints.API, ReportPortalEndPoints.V1, ReportPortalEndPoints.PROJECT_NAME, ReportPortalEndPoints.DASHBOARD),
                dashboard.toJson()).as(Dashboard.class);
    }
}
