package ApachePOI;

import javafx.beans.binding.IntegerBinding;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    public static void main(String[] args) {
        System.out.print("Sayı Giriniz= ");
        Scanner oku=new Scanner(System.in);
        int Deger=oku.nextInt();

        System.out.println("Dönen Sonuç= "+ bul(Deger));
    }
    public static String bul(int deger) {
        String donecek="";
        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook=null;
        try {
            FileInputStream inputStream= inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++){
            if (sheet.getRow(i).getPhysicalNumberOfCells()>deger)
                donecek+=sheet.getRow(i).getCell(deger)+"\n";
        }
        return donecek;
    }
}
