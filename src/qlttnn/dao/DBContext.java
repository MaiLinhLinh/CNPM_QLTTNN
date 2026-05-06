package qlttnn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public Connection getConnection() throws Exception {
        // Sửa lại chuỗi kết nối cho SQL Server
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTTNN;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "123"; // Mật khẩu SQL Server của bạn
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }
}
