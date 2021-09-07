package com.parinder.dbtd.tests.api;

import com.parinder.dbtd.adapters.apis.UsersApi;
import com.parinder.dbtd.helper.HttpResponseHelper;
import com.parinder.dbtd.helper.JsonAssertionHelper;
import com.parinder.dbtd.tests.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test(description = "Test Get /users Request")
    @Description("**Scenario:** Check that the Get /users api retrieve all datasource details." + "<br/><br/>" +
            "_Given_ that I target the /users API" + "<br/>" +
            "_When_ I Perform a Get on the /users endpoint" + "<br/>" +
            "_And_ I Retrieve the users' detail" + "<br/>" +
            "_Then_ I can find the users and other details.")
    public void testGetUsers() {
        UsersApi usersApi = new UsersApi(this.config);
        Response response = usersApi.getUsers();

        HttpResponseHelper.assertStatusCode(response,200);

        JsonAssertionHelper.assertBodyContains(response,"Parinder");
    }
}
