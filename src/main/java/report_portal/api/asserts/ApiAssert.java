package report_portal.api.asserts;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

@Slf4j
@Getter
public class ApiAssert {
    private Response response;

    public ApiAssert(Response response) {
        this.response = response;
    }
    public static ApiAssert assertThat(Response response) {
        return new ApiAssert(response);
    }



    public ApiAssert isCorrectStatusCode(Integer expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, this.response.getStatusCode(),
                String.format("Status code is not correct, actual %s, expected %s",
                        this.response.getStatusCode(), expectedStatusCode));

        log.info("Status code is correct {}", expectedStatusCode);

        return this;
    }

    public ApiAssert containsErrorMessage(String expectedMessage) {
        String responseBody = this.response.getBody().asString();
        Assertions.assertTrue(responseBody.contains(expectedMessage),
                String.format("Expected error message '%s' was not found in the response. Actual response: %s",
                        expectedMessage, responseBody));

        log.info("Response contains the expected error message: {}", expectedMessage);
        return this;
    }
}
