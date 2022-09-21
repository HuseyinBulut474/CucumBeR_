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
        XSSFSheet sheet = workbook.createSheet("Standard");

        for (int i = 0; i < 10; i++) {
            Row newRow = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell newCell = newRow.createCell(j);
                newCell.setCellValue((i + 1) + " x " + (j + 1) + " = " + (i + 1) * (j + 1));
            }
        }
        String yeniExcelPath = "src/test/java/ApachePOI/resource/CarpimTablosu1.xlsx";
        FileOutputStream outputStream = new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı");
    }
}