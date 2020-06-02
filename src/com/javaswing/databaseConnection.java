package com.javaswing;
import java.sql.*;

public class databaseConnection {
    String url = "jdbc:mysql://localhost:3306/additiontest?autoReconnect=true&useSSL=false";
    String username = "danny";
    String password = "danny";
    String query;

    public databaseConnection(String query){
        this.query = query;
    }

    public void runQuery() throws SQLException {
        Connection conn = DriverManager.getConnection(url,username, password);
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }
}
