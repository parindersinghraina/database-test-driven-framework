package com.parinder.dbtd.tests.database;

import com.google.gson.JsonObject;
import com.parinder.dbtd.adapters.model.Users;
import com.parinder.dbtd.helper.*;
import com.parinder.dbtd.tests.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersTest extends BaseTest {

    @Test(description = "Test Get /users Request for Database Validation")
    @Description("**Scenario:** Check that the Get /users api retrieve all datasource details." + "<br/><br/>" +
            "_Given_ that I target the /users API" + "<br/>" +
            "_When_ I Perform a Get on the /users endpoint" + "<br/>" +
            "_And_ I Retrieve the users' detail" + "<br/>" +
            "_Then_ I can find the users and other details.")
    public void testUsersEntities() throws Exception {
        // TO ESTABLISH CONNECTION
        String jsonFilePath = "/Users/parindersingh/git/database-test-driven-framework/src/test/resources/fixtures/get-users.json";
        Connection connection = connectionSetup();
        ArrayList<Users> arrayList = new ArrayList<Users>();

        // TO EXECUTE A QUERY
        ResultSet resultSet = QueryHelper.getQueryResult(connection, "SELECT * FROM users;");

        // ITERATE TO RECORDS THE POINTER TO PARTICULAR ROW
        ArrayList recordSet = ResultSetHelper.getUserResultSetArrayList(arrayList, resultSet);

        // CONVERT JAVA OBJECT TO JSON OBJECT AND CREATE JSON FIXTURE
        ConversionHelper.convertRecordToJsonObjectAndCreateJsonFile(recordSet, jsonFilePath);

        // VALIDATION
        JsonObject jsonObject = DataFixtureHelper.getJsonDocument("fixtures/get-users.json");

        Assert.assertTrue(jsonObject.toString().contains("Parinder"));
    }
}
