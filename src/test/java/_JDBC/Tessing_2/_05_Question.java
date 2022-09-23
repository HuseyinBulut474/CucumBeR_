package _JDBC.Tessing_2;

import _JDBC.Tessing_1.JDBCParent;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _05_Question extends JDBCParent {
    private static Connection connection;
    protected static Statement statement;

    @Test
    public void test3() throws SQLException, IOException {
        //DB connection
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/tabloseç";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();

        //create a newtable in database
        String sql = "create table isimgelecek (no int, ad varchar(40),soyad varchar(40),numara int)";
        statement.execute(sql);

        //Excel
        String path = "/Users/pRofesör/Desktop/Cucumber3/src/test/java/_JDBC/veriler.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");
        int rows = sheet.getLastRowNum();

        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            double id = row.getCell(0).getNumericCellValue();
            String ad = row.getCell(1).getStringCellValue();
            String soyad = row.getCell(2).getStringCellValue();
            double numara = row.getCell(3).getNumericCellValue();

            String sql1 = "insert into isimGelecek values('"+id+"','"+ad+"','"+soyad+"','"+numara+"')";
            statement.execute(sql1);
            statement.execute("commit");
        }
        workbook.close();
        inputStream.close();
        connection.close();
    }
}
