package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        Row yeniSatir=sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre=yeniSatir.createCell(0); // yeni satırda ilk hücre oluşturdu
        yeniHucre.setCellValue("Cloud"); // bilgi yazıldı

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);
        }

        // yazma işlemini yazma metodunda açıp öyle yapacağız
        String yeniExcellPath="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcellPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("DONE");
    }
}
