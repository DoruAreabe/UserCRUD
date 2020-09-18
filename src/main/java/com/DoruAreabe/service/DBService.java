package com.DoruAreabe.service;

import java.sql.*;

public class DBService {
    private static final String DBLogin="root";
    private static final String DBpassword="coderslab";
    private static final String DBUrl="jdbc:mysql://localhost:3306/UserDB?serverTimezone=UTC";

    public static Connection getConection() throws SQLException {
        Connection con = DriverManager.getConnection(DBUrl,DBLogin,DBpassword);
        return con;
    }
}
