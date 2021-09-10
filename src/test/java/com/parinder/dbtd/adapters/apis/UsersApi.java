package com.parinder.dbtd.adapters.apis;

import com.parinder.dbtd.configuration.Config;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UsersApi extends BaseApi{

    public UsersApi(Config config) {
        super(config);
        this.spec = new RequestSpecBuilder().setBaseUri(this.config.getProperty("api.rest-api-services.baseurl")).setRelaxedHTTPSValidation().build();
    }

    @Step("Submit GET '/api/v1/users'")
    public Response getUsers() {
        return given().spec(this.spec)
                .header("Content-Type", "application/json")
                .get("/api/v1/users");
    }
}
