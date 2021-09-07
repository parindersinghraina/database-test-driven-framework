package com.parinder.dbtd.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class JsonAssertionHelper {

    public static void assertEquals(JsonPath jsonPath, String path, String expectedValue) {
        Assert.assertEquals(jsonPath.getString(path), expectedValue,
                path + " should be : " + expectedValue);
    }

    public static void assertEquals(JsonPath jsonPath, String path, int expectedValue) {
        Assert.assertEquals(jsonPath.getInt(path), expectedValue,
                path + " should be : " + expectedValue);
    }

    public static void assertEquals(JsonPath jsonPath, String path, List expectedValues) {
        Assert.assertEquals(jsonPath.getInt(path), expectedValues,
                path + " should be : " + expectedValues);
    }

    public static void assertSizeEquals(JsonPath jsonPath, String path, int expectedValues) {
        Assert.assertEquals(jsonPath.getList(path).size(), expectedValues,
                path + " should be : " + expectedValues);
    }

    public static void assertGreaterThan(JsonPath jsonPath, String path, Integer value) {
        Assert.assertTrue(jsonPath.getInt(path) > value,
                path + " should be greater than :" + value);
    }

    public static void assertTrue(JsonPath jsonPath, String path) {
        Assert.assertTrue(jsonPath.getBoolean(path),
                path + " should be : True");
    }

    public static void assertFalse(JsonPath jsonPath, String path) {
        Assert.assertFalse(jsonPath.getBoolean(path),
                path + " should be : False");
    }

    public static void assertNull(JsonPath jsonPath, String path) {
        Assert.assertNull(jsonPath.getString(path), path + " should be : NULL");
    }

    public static void assertNotNull(JsonPath jsonPath, String path) {
        Assert.assertNotNull(jsonPath.getString(path), path + " should not be : NULL");
    }

    public static void assertContains(JsonPath jsonPath, String path, String expectedValue) {
        Assert.assertTrue(jsonPath.getList(path).toString().contains(expectedValue),
                path + " should contain : " + expectedValue);
    }

    public static void assertBodyContains(Response response, String expectedValue) {
        Assert.assertTrue(response.getBody().asString().contains(expectedValue),
                "Body should contain : " + expectedValue);
    }

    public static void assertNotContain(JsonPath jsonPath, String path, String expectedValue) {
        Assert.assertFalse(jsonPath.getList(path).toString().contains(expectedValue),
                path + " should not contain : " + expectedValue);
    }

    public static void assertDataType(JsonPath jsonPath, String path, String expectedDataType) {
        Assert.assertTrue(jsonPath.get(path).getClass().getName().equals(expectedDataType),
                path + " should be of : \"" + expectedDataType + "\" data type");
    }
}