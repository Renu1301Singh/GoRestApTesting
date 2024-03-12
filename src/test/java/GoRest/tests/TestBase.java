package GoRest.tests;

import GoRest.Config.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = Config.BASE_URL;
    }
}
