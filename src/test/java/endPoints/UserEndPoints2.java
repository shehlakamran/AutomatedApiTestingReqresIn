package endPoints;

import apis.base.BaseTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import payLoads.UserPayLoads;
import test.UserTest;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {
    static String key = "x-api-key";
    static String keyvalue = "pub_7d132fb30acc00155ff0cfa8d9f2ad1d3481a0e7252d5163158e16834c42ae12";
//method created for getting URL's from Properties file
    static ResourceBundle getURL(){
        ResourceBundle rb = ResourceBundle.getBundle("url");
        return rb;
    }
    public static Response getAllUser() {
       String url = getURL().getString("getalluser_url");
        Response response = given()
                .header(key, keyvalue)
                .when()
                .get(url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.getAllUser_Url);
        return response;
    }

    public static Response getSingleUser() {
        String url = getURL().getString("get_url");
        Response response = given()
                .header(key, keyvalue)
                .when()
                .get(url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.getSingleUser_Url);
        return response;

    }

    public static Response createUser(UserPayLoads payload) {
        String url = getURL().getString("post_url");
        Response response = given()
                .header(key, keyvalue)
                .contentType("application/json")
                .body(payload)
                .when()
                .post(url);
        UserTest.logger.info("HTTP: POST Base URL: {}",BaseTest.post_Url);
        UserTest.logger.info("Payload: {}", new Gson().toJson(payload));
        return response;
    }

    public static Response updateUser(String id, String name, UserPayLoads payload) {
        String url = getURL().getString("update_url");
        Response response = given()
                .header(key, keyvalue)
                .body(payload)
                .when()
                .get(url);
        UserTest.logger.info("HTTP: GET Base URL: {}",BaseTest.put_Url);
        UserTest.logger.info("Payload: {}", new Gson().toJson(payload));
        return response;
    }

    public static Response deleteUser() {
        String url = getURL().getString("delete_url");
        Response response = given()
                .header(key, keyvalue)
                .when()
                .delete(url);
        UserTest.logger.info("HTTP: DELETE Base URL: {}",BaseTest.delete_Url);
        return response;
    }
}
