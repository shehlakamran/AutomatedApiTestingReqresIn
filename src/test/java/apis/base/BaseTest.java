package apis.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static String base_Url = "https://reqres.in";
    public static String getAllUser_Url = base_Url + "/api/users?page=2";
    public static String getSingleUser_Url = base_Url + "/api/users/2";
    public static String post_Url = base_Url + "/api/users";
    public static String put_Url = base_Url + "/api/users/2";
    public static String patch_Url = base_Url + "/api/users/2";
    public static String delete_Url = base_Url + "/api/users/2";
   /* @BeforeClass
    public void setUp(){
        RestAssured.baseURI = base_Url;
    }*/
}
