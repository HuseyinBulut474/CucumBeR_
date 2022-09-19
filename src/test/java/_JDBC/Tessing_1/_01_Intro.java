package _JDBC.Tessing_1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public  void test1() throws SQLException {
    String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";  // hostname,port/db
    String username="root";
    String password="'\"-LhCB'.%k[4S]z";

        Connection connection= DriverManager.getConnection(url,username,password); // connection
        Statement statement=connection.createStatement();   // Open new page
        ResultSet rs =statement.executeQuery("select * from actor");

        rs.next(); // ilk satır
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        System.out.println("fullName = " + firstName + " " + lastName);

        rs.next(); // II. satır
        firstName=rs.getString("first_name");
        lastName=rs.getString("last_name");

        System.out.println("fullName = " + firstName + " " + lastName);

        connection.close();
    }
}
