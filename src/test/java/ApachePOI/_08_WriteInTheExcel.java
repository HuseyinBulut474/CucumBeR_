package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan excele yazma

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");
        // Hafızada oluşturma ve yazma işlemi
        Row yeniSatir=sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre=yeniSatir.createCell(0); // yeni satırda ilk hücre oluşturdu
        yeniHucre.setCellValue("Cloud"); // bilgi yazıldı

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);
        }
        //sıra kaydetmeye geldi, bütü n bilgler hafızada buraya kadar her şey workbook da
        inputStream.close();//okuma modunu kapattım. çünkü yazma modunda açmam gerekiyor

        // yazma işlemini yazma metodunda açıp öyle yapacağız
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("DONE");
    }
}
