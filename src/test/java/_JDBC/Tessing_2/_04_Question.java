package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Question extends JDBCParent {

    @Test
    public void test2() throws SQLException, IOException {
        //statement-query
        ResultSet rs = statement.executeQuery("select * from actor");

        //excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Actors Data");

        Row newRow = sheet.createRow(0);
        newRow.createCell(0).setCellValue("actor_id");
        newRow.createCell(1).setCellValue("first_name");
        newRow.createCell(2).setCellValue("last_name");
        newRow.createCell(3).setCellValue("last_update");

        int rowCount = 1;
        while (rs.next()){
            int actor_id = rs.getInt("actor_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String last_update = rs.getString("last_update");

            newRow = sheet.createRow(rowCount);
            rowCount++;

            newRow.createCell(0).setCellValue(actor_id);
            newRow.createCell(1).setCellValue(first_name);
            newRow.createCell(2).setCellValue(last_name);
            newRow.createCell(3).setCellValue(last_update);
        }
        //excel write execute
        String path = "src/test/java/ApachePOI/resource/actor23.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
