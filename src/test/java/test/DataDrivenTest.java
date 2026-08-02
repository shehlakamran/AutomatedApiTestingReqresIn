package test;

import api.utilities.DataProviders;
import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payLoads.UserPayLoads;

public class DataDrivenTest {
    String id;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void createUser(String name, String job) {
        UserPayLoads payLoads = new UserPayLoads();
        payLoads.setName(name);
        payLoads.setJob(job);
        Response response = UserEndPoints.createUser(payLoads);
        response.then().log().all();
        id = response.jsonPath().getString("id");
        System.out.println("Created user ID: " + id);

        Assert.assertEquals(response.statusCode(), 201);

    }
}
