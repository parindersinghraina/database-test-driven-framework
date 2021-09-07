package com.parinder.dbtd.adapters.apis;

import com.parinder.dbtd.configuration.Config;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    protected Config config;
    protected RequestSpecification spec;

    public BaseApi(Config config) {
        this.config = config;
    }
}
