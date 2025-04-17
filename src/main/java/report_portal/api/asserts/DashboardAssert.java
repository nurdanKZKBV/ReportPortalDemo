package report_portal.api.asserts;
import report_portal.api.entitiy.BaseEntity;
import report_portal.api.entitiy.Dashboard;

public class DashboardAssert extends EntityAssert {


    public DashboardAssert(BaseEntity actualBaseEntity) {
        super(actualBaseEntity);
    }

    public static DashboardAssert assertThat(Dashboard dashboard) {
        return new DashboardAssert(dashboard);
    }
}
