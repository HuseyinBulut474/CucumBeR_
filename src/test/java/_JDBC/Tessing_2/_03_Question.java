package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class _03_Question extends JDBCParent {
    @Test
    @Parameters("select")
    public void question1(String select) throws SQLException {
        ResultSet rs = statement.executeQuery(select);
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
