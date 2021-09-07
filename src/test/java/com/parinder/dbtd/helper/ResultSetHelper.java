package com.parinder.dbtd.helper;

import com.parinder.dbtd.adapters.model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetHelper {

    public static ArrayList getUserResultSetArrayList(ArrayList arrayList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Users users = new Users();
            users.setId(resultSet.getLong(1));
            users.setCreatedAt(resultSet.getDate(2));
            users.setCreatedBy(resultSet.getString(3));
            users.setEmail(resultSet.getString(4));
            users.setFirstName(resultSet.getString(5));
            users.setLastName(resultSet.getString(6));
            users.setUpdatedAt(resultSet.getDate(7));
            users.setUpdatedBy(resultSet.getString(8));

            arrayList.add(users);
        }
        return arrayList;
    }
}
