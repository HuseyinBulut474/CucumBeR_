package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        // ResultSet: data * meta (data dışındaki diğer bilgiler kolon sayısı vs...)

        ResultSetMetaData rsmd = rs.getMetaData();
        // Sonuçların haricindeki diğer bilgiler: colon sayısı, isimleri, tipleri

        int columnCount = rsmd.getColumnCount(); // kolon sayısı
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);
            System.out.println(columnType + " " + columnName);
        }
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-15s", rsmd.getColumnName(i));
        // printf istediğin gibi sıralı yazmak
        // % değişkenin değerini işaret eder. - sola dayalı yazdırır. default sağa dayalı yazar
        // 15 kaç hane kullanılacak her zaman onun bilgisi
        // s  string değerler için. sayısal değerler için d kullanılır
        // "%5.2d" sayı için 5 hane kullan, ondalıklı kısım 2 hane... float için
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-15s", rs.getString(i));
            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {
        getTable("select * from actor");
    }
    public void getTable(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-15s", rsmd.getColumnName(i));
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.printf("%-15s", rs.getString(i));
            System.out.println();
        }
    }
}
