package endPoints;

import apis.base.BaseTest;
import io.restassured.response.Response;
import payLoads.UserPayLoads;
import test.UserTest;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class UserEndPoints extends BaseTest {
    //Implemetation of CRUD operations
    static String key = "x-api-key";
    static String keyvalue = "pub_7d132fb30acc00155ff0cfa8d9f2ad1d3481a0e7252d5163158e16834c42ae12";

    public static Response getAllUser() {
        Response response = given()
                .header(key, keyvalue)
                .when()
                .get(BaseTest.getAllUser_Url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.getAllUser_Url);
        return response;
    }

    public static Response getSingleUser() {
        Response response = given()
                .header(key, keyvalue)
                .when()
                .get(BaseTest.getSingleUser_Url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.getSingleUser_Url);
        return response;

    }

    public static Response createUser(UserPayLoads payload) {
        Response response = given()
                .header(key, keyvalue)
                .contentType("application/json")
                .body(payload)
                .when()
                .post(BaseTest.post_Url);
        UserTest.logger.info("HTTP: POST Base URL: {}",BaseTest.post_Url);
        UserTest.logger.info("Payload: {}", new Gson().toJson(payload));
        return response;
    }

    public static Response updateUser(String id, String name, UserPayLoads payload) {
        Response response = given()
                .header(key, keyvalue)
                .body(payload)
                .when()
                .get(BaseTest.put_Url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.put_Url);
        UserTest.logger.info("Payload: {}", new Gson().toJson(payload));
        return response;
    }

    public static Response deleteUser() {
        Response response = given()
                .header(key, keyvalue)
                .when()
                .delete(BaseTest.delete_Url);
        UserTest.logger.info("HTTP: DELETE Base URL: {}",BaseTest.delete_Url);
        return response;
    }
}
