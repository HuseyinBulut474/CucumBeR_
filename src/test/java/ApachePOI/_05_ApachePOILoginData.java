package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_ApachePOILoginData {
    public static void main(String[] args){

        System.out.print("Aranacak Kelime =");
        Scanner oku=new Scanner(System.in);
        String arananKelime=oku.nextLine();

        System.out.println("Dönen Sonuç= "+ bul(arananKelime));
    }

    public static String bul(String arananKelime) {
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
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            if (cell.toString().equalsIgnoreCase(arananKelime))
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++)
                                donecek+=row.getCell(j)+" ";
        }
            return donecek;
    }
}
