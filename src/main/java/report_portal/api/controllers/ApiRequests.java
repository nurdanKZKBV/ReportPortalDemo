package report_portal.api.controllers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import report_portal.fileUtils.ConfigReader;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

@Slf4j
@Data
public class ApiRequests {
    protected String url;
    protected RequestSpecification requestSpecification;
    protected Response response;
    private static String SLASH="/";


    public ApiRequests(String url) {
        this.url = url;
        this.requestSpecification = RestAssured.given()
                .baseUri(url)
                .header("Authorization", "Bearer " + ConfigReader.getApiProperty("apikey"));
    }

    private void logResponse(){
        log.warn("Response is:");
        log.warn(getResponse().getBody().asPrettyString());
        log.warn("Status code: " + getResponse().getStatusCode());
    }

    protected static String getEndpoint(String ... endpoints){
        StringBuilder endpoint = new StringBuilder();
        for(String args : endpoints){
            endpoint.append(args).append(SLASH);
        }
        return endpoint.substring(0, endpoint.length()-1);
    }

    protected String formatParameter(HashMap<String, String> parameters){
        StringBuilder query = new StringBuilder("?");
        for(Map.Entry<String, String> entry : parameters.entrySet()){
            query.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return query.deleteCharAt(query.length()-1).toString();
    }

    protected Response get(String endpoint){
        log.info("performed GET {}", endpoint);
        this.response = given()
                .spec(requestSpecification)
                .get(endpoint);
        logResponse();
        return this.response;
    }

    protected Response post(String endpoint, String params){
        log.info("performed POST {}", endpoint);
        log.info("Params is {}", params);
        this.response = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(params)
                .post(endpoint);
        logResponse();
        return this.response;
    }

    protected Response post(String endpoint, Map<String, String> params){
        log.info("performed POST {}", endpoint);
        log.info("Params is {}", params);
        this.response = given()
                .spec(requestSpecification)
                .formParams(params)
                .post(endpoint);
        logResponse();
        return this.response;
    }
}

