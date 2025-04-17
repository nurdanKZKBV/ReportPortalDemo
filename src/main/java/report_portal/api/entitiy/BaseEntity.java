package report_portal.api.entitiy;

import report_portal.api.utils.JsonUtils;

public class BaseEntity {

    public String toJson(){
        return JsonUtils.toJson(this);
    };
}
