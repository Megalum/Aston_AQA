import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPostmanEcho{

    @Before
    public void setUpBaseUri() {
        RestAssured.baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2");

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }

    @Test
    public void testPostRawTextRequest() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .post("/post");

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFromDataRequest() {
        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/post");

        String responseBody = response.getBody().asString();

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/post"));
        Assert.assertTrue(responseBody.contains("foo1"));
        Assert.assertTrue(responseBody.contains("bar1"));
        Assert.assertTrue(responseBody.contains("foo2"));
        Assert.assertTrue(responseBody.contains("bar2"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"foo1\": \"bar1\"}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put("/put");

        String responseBody = response.getBody().asString();

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/put"));
        Assert.assertTrue(responseBody.contains("foo1"));
        Assert.assertTrue(responseBody.contains("bar1"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .patch("/patch");

        String responseBody = response.getBody().asString();

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/patch"));
        Assert.assertTrue(responseBody.contains("foo1"));
        Assert.assertTrue(responseBody.contains("bar1"));
        Assert.assertTrue(responseBody.contains("foo2"));
        Assert.assertTrue(responseBody.contains("bar2"));
    }

    @Test
    public void testDeleteRequest() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("/delete");

        response.then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"));
    }


}
