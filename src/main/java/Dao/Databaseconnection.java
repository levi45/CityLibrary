package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {

    private static final String url = "jdbc:mysql://localhost:3306/bookstore";
    private static Connection con = null;

    public static Connection getConnection(){

            try {
                String username = "root";
                String password = "Admin";
                Class.forName(
                        "com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        url, username, password);
            }catch (Exception e){
                e.printStackTrace();

            }
            return con;
    }
}
