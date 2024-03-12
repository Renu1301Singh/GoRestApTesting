package GoRest.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {
    public static Response sendGetRequest(String endpoint, String authToken) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .get(endpoint);
    }

    public static Response sendPostRequest(String endpoint, String requestBody, String authToken) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endpoint);
    }

    public static Response sendPatchRequest(String requestBody, String authToken) {
        String endpoint = endpoints.PATCH_USER;
        return RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .patch(endpoint);
    }

    public static Response sendDeleteRequest(String endpoint, String authToken) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .delete(endpoint);
    }
}
