package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {

    @Test
    private void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select city_id, city, country_id from city");

        rs.last(); // son karakter

        String id=rs.getString(1);
        System.out.println("id = " + id);

        int idInt=rs.getInt(1);
        System.out.println("idInt = " + idInt);

        String name=rs.getString(2);
        System.out.println("name = " + name);

        // int nameInt=rs.getInt(2);
        // System.out.println("nameInt = " + nameInt);
        // tipi uygun olan dönüşümle , mesala hepsini String olarak alabilirsin.
        // ancak tipi uygun olmayan mesala isimleri , int olarak zaten alınmaz


        int kacinciSatir=rs.getRow();
        // dolayısıyla bir sorgunun sonucunda kaç satır geldiğini
        // rs.last() dedikten sonra rs.getRow() ile alabilirim.

        System.out.println("kacinciSatir = " + kacinciSatir);
        rs.first(); // ilk satıra gider
    }
}
