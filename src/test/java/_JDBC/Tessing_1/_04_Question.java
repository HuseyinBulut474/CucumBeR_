package _JDBC.Tessing_1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
public class _04_Question extends JDBCParent{

    @Test
    private void cityNext() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=1;
        while (rs.next()) {
            String city = rs.getString("city");
            System.out.println(count+ ".city = " + city);
            count++;
        }
    }
    @Test
    private void cityAbsolute() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=1;
        while (rs.absolute(count)) {
            String city = rs.getString("city");
            System.out.println(count+ ".city = " + city);
            count++;
        }
    }
    @Test
    private void cityRelative() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=1;
        while (rs.relative(1)) {
            String city = rs.getString("city");
            System.out.println(count+ ".city = " + city);
            count++;
        }
    }
}
