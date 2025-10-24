package com.ucc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnetion {

    private static final String URL =
        "jdbc:mysql://localhost:3307/sakila?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection myConn;

    private DatabaseConnetion() {}

    public static Connection getInstanceConnection() throws SQLException {
        if (myConn == null || myConn.isClosed()) {
            myConn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return myConn;
    }
}
