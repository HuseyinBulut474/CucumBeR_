package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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

    @Test
    public void question2() throws SQLException, IOException {
        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Standard");

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            Row newRow = sheet.createRow(i);

            while (rs.next()) {
                for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                    Cell newCell = newRow.createCell(j);
                    newCell.setCellValue(rs.getString(j));
                }
            }
            String yeniExcelPath = "src/test/java/ApachePOI/resource/actor.xlsx";
            FileOutputStream outputStream = new FileOutputStream(yeniExcelPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("İşlem tamamlandı");
        }
    }
}
