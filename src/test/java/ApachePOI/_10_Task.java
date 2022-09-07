package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**  Soru 2:
 *  Çarpım tablosunu excele yazdırınız.
 *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
 *  sıfırdan excel oluşturarak.
 *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
 */
public class _10_Task {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("ÇARPIM TABLOSU");

        int k = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 11; j++) {
                row = sheet.createRow((k));
                cell = row.createCell(0);
                cell.setCellValue(i + "x" + j + " = " + (i * j));
                k++;
            }
            sheet.createRow((k));
            row.createCell(0);
            cell.setCellValue(" ");
        }
        String newExcelPath = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        try {
            FileOutputStream outputStream = new FileOutputStream(newExcelPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}