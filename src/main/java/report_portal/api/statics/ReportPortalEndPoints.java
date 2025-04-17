package report_portal.api.statics;

import report_portal.fileUtils.ConfigReader;

public class ReportPortalEndPoints {


    public static final String URL = ConfigReader.getApiProperty("url");
    public static final String API = "api";
    public static final String V1 = "v1";
    public static final String PROJECT_NAME = "default_personal";

    public static final String DASHBOARD = "dashboard";
    public static final String USERS = "users";
    public static final String WIDGET = "widget";

}
