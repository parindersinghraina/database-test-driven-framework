package com.parinder.dbtd.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHelper {

    public static ResultSet getQueryResult(Connection connection, String queryStatement) throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(queryStatement);
        return resultSet;
    }
}
