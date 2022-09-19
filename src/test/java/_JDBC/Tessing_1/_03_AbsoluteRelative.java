package _JDBC.Tessing_1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent{
    @Test
    private  void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from film");
        rs.absolute(10); // 10 satıra git
        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // 15. satıra git
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15); // sondan 15. satıra git
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5); // en son bulunduğun yerden 5 satır ileri gider
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5); // en son bulunduğun yerden 5 satır geri gider
        title = rs.getString("title");
        System.out.println("title = " + title);

    }
}
