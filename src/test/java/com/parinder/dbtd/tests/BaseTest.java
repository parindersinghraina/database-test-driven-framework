package com.parinder.dbtd.tests;

import com.parinder.dbtd.configuration.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.*;

public class BaseTest {

    protected Config config;

    @BeforeMethod(alwaysRun = true)
    public Connection connectionSetup() throws Exception {
        Exception potentialException = null;
        try {
            Config config = new Config();
            Class.forName(config.getProperty("db.classname"));
            Connection connection = null;
            return connection = DriverManager.getConnection(config.getProperty("db.url"), config.getProperty("db.username"), config.getProperty("db.password"));
        }
        catch (Exception e) {
         potentialException = e;
        }
        throw potentialException;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() throws Exception {
        connectionSetup().close();
    }
}
