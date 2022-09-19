package _JDBC.Tessing_1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;

    @BeforeTest
    public void DBConnectionOpen(){
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection= DriverManager.getConnection(url, username, password);
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");
        rs.next();
        String dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);
    }
    @Test
    public void test2() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");
        rs.next();
        String dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);
    }
    @Test
    public void test3() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");
        rs.next();
        String dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.previous();  // English yazar bir önceki satıra döner
        dilAdi= rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);
    }
}
