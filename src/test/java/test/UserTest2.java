package test;

import com.github.javafaker.Faker;
import endPoints.UserEndPoints;
import endPoints.UserEndPoints2;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payLoads.UserPayLoads;

public class UserTest2 {


    public static final Logger logger = LogManager.getLogger(test.UserTest2.class);
    Faker faker = new Faker();
    UserPayLoads payload;
    String id;

    @BeforeClass
    public void setUp() {
        faker = new Faker();
        payload = new UserPayLoads();
        payload.setName(faker.name().name());
        payload.setJob(faker.job().title());
    }

    @Test(priority = 1)
    public void getAllUserfromlist() {
        logger.info("Running getAllUserfromlist");
        Response response = UserEndPoints2.getAllUser();
        logger.info("Response: {}, ResponseCode: {}", response.prettyPrint(), response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void getSingleUserfromlist() {
        logger.info("Running getSingleUserfromlist");
        Response response = UserEndPoints2.getSingleUser();
        logger.info("Response: {}, ResponseCode: {}", response.prettyPrint(), response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void createUser() {
        logger.info("Running createUser");
        Response response = UserEndPoints2.createUser(payload);
        response.then().log().all();
        id = response.jsonPath().getString("id");
        logger.info("Response: {}, ResponseCode: {}", response.prettyPrint(), response.statusCode());
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test(priority = 4, dependsOnMethods = "createUser")
    public void updateUser() {
        logger.info("Running updateUser");
        payload.setName(faker.name().name());
        payload.setJob(faker.job().title());
        Response response = UserEndPoints2.updateUser(id, this.payload.getName(), payload);
        response.then().log().body();
        logger.info("Response: {}, ResponseCode: {}", response.prettyPrint(), response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 5)
    public void deleteUser() {
        logger.info("Running deleteUser");
        Response response = UserEndPoints2.deleteUser();
        logger.info("Response: {}, ResponseCode: {}", response.prettyPrint(), response.statusCode());
        Assert.assertEquals(response.getStatusCode(), 204);
    }

}


