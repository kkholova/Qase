import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void projectTest(){
        given().
                header("Token","833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                header("Content-Type","application/json").
                body("{}").
        when().
                post("https://api.qase.io/v1/project").

        then().
                statusCode(200).
                body("errorMessage",equalTo("Data is invalid"),
                        "errorFields[0].error",equalTo("Title is required") );

    }
}
