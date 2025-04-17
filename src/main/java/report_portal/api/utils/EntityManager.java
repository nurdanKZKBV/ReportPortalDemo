package report_portal.api.utils;

import com.github.javafaker.Faker;
import report_portal.api.entitiy.Dashboard;

public class EntityManager {
    private static final Faker faker = new Faker();

    public Dashboard generateDashboard(){
        return Dashboard.builder()
                .name(faker.name().firstName())
                .description(faker.lorem().sentence())
                .build();
    }
}
