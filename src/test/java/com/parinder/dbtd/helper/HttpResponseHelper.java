package com.parinder.dbtd.helper;

import io.restassured.response.Response;
import org.testng.Assert;

public class HttpResponseHelper {
    public static void assertStatusCode(Response response, int code) {
        Assert.assertEquals(response.getStatusCode(), code, "Status code should be : " + code);
    }
}