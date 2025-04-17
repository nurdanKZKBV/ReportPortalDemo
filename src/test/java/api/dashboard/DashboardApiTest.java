package api.dashboard;

import api.base.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import report_portal.api.asserts.ApiAssert;
import report_portal.api.asserts.DashboardAssert;
import report_portal.api.entitiy.Dashboard;
import report_portal.api.utils.EntityManager;

import static io.qameta.allure.Allure.step;

@Epic("ReportPortal API")
@Feature("Dashboard")
@ExtendWith(AllureJunit5.class)
public class DashboardApiTest extends BaseApiTest {

    @Test
    @Tag("api")
    @DisplayName("Создание dashboard и валидация ответа")
    @Description("Отправить POST /dashboard запрос и проверить ответ")
    @Owner("Nurdan")
    void createDashboardTest() {

        Dashboard expectedDashboard = step("Генерация сущности Dashboard", () ->
                new EntityManager().generateDashboard()
        );

        Dashboard actualDashboard = step("Создание Dashboard через API", () ->
                reportPortalApp.getDashboardController().createDashboard(expectedDashboard)
        );

        step("Проверка статус-кода", () -> {
            ApiAssert.assertThat(reportPortalApp.getDashboardController().getResponse())
                    .isCorrectStatusCode(201);
        });

        step("Сравнение тела ответа с ожидаемым объектом", () -> {
            DashboardAssert.assertThat(actualDashboard)
                    .isEqualsTo(expectedDashboard);
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Негативный тест: создание dashboard с отсутствующим именем")
    @Description("Проверка, что создание dashboard без имени возвращает ошибку")
    @Owner("Nurdan")
    void createDashboardWithMissingNameTest() {
        Dashboard invalidDashboard = Dashboard.builder()
                .description("Description without name")
                .name(null)
                .build();
        step("Отправка запроса с отсутствующим именем", () -> {
            reportPortalApp.getDashboardController().createDashboard(invalidDashboard);
        });
        step("Проверка статус-кода 400", () -> {
            ApiAssert.assertThat(reportPortalApp.getDashboardController().getResponse())
                    .isCorrectStatusCode(400);
        });
        step("Проверка сообщения об ошибке", () -> {
            ApiAssert.assertThat(reportPortalApp.getDashboardController().getResponse())
                    .containsErrorMessage("name");
        });
    }




}
