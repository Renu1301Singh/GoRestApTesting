package GoRest.tests;
import GoRest.Config.Config;
import GoRest.utils.RandomGen;
import GoRest.utils.RestUtils;
import GoRest.utils.endpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITest extends TestBase {

    @Test(priority = 1)
    public void createUser_Positive() {
        String requestBody = "{\"name\":\"" + RandomGen.generateRandomName() + "\", \"gender\":\"female\", \"email\":\"" + RandomGen.generateDynamicEmail() + "\", \"status\":\"active\"}";
        Response response = RestUtils.sendPostRequest(endpoints.CREATE_USER, requestBody, Config.AUTH_TOKEN);
        Config.userId = response.jsonPath().getString("id");
        System.out.println(Config.userId);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201 Created");
    }

    @Test(priority = 2)
    public void createUser_Negative_InvalidToken() {
        String requestBody = "{\"name\":\"" + RandomGen.generateRandomName() + "\", \"gender\":\"female\", \"email\":\"" + RandomGen.generateDynamicEmail() + "\", \"status\":\"active\"}";
        Response response = RestUtils.sendPostRequest(endpoints.CREATE_USER, requestBody, "invalid_token");
        Assert.assertEquals(response.getStatusCode(), 401, "Status code should be 401 Unauthorized");
    }

    @Test(priority = 3)
    public void updateUser_Positive() {
        String requestBody = "{\"name\":\"AllasaniPeddana\", \"email\":\"" + RandomGen.generateDynamicEmail() + "\", \"status\":\"active\"}";
        Response response = RestUtils.sendPatchRequest(requestBody, Config.AUTH_TOKEN); // Use requestBody and authToken
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 OK");
    }
    @Test(priority = 4)
    public void updateUser_Negative_InvalidUserId() {
        String requestBody = "{\"name\":\"Allasani Peddana\", \"email\":\"allasani.peddana@15ce.com\", \"status\":\"active\"}";
        Response response = RestUtils.sendPatchRequest(requestBody, Config.AUTH_TOKEN); // Use requestBody and authToken
        Assert.assertEquals(response.getStatusCode(), 422, "Status code should be 422 Unprocessable Entity");
    }


    @Test(priority = 5)
    public void fetchUser_Positive() {
        Response response = RestUtils.sendGetRequest(endpoints.USERS, Config.AUTH_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 OK");
    }

    @Test(priority = 6)
    public void fetchUser_Negative_InvalidUserId() {
        Response response = RestUtils.sendGetRequest(endpoints.INVALID_ENDPOINT, Config.AUTH_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 Not Found");
    }

    @Test(priority = 7)
    public void deleteUser_Positive() {
        Response response = RestUtils.sendDeleteRequest(endpoints.DELETE_USER, Config.AUTH_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 No Content");
    }

    @Test(priority = 8)
    public void deleteUser_Negative_InvalidUserId() {
        Response response = RestUtils.sendDeleteRequest(endpoints.DELETE_NON_EXISTENT_END_POINT, Config.AUTH_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 Not Found");
    }
}

