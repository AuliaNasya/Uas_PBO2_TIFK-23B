
package com.mycompany.apotek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/apotek_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        return conn;
    }
}
