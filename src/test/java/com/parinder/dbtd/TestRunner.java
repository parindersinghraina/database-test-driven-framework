package com.parinder.dbtd;

import com.parinder.dbtd.tests.database.UsersTest;

public class TestRunner {

    public static void main (String[] args) throws Exception {
        UsersTest usersTest = new UsersTest();
        usersTest.testUsersEntities();
    }
}
