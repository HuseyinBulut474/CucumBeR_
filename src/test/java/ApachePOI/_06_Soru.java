package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 Bir önceki yapılan soruda, Kullanıcıya 1.sütundaki tüm değer bir liste halinde kullanıcıya
 yanlarında bi numara olarak sunalım. Kullanıcı hangi numararyı girerese o satırın
 yanındaki tüm bilgiler gösterilsin.
 Username için 1
 Password için 2
 */
public class _06_Soru {
    public static void main(String[] args) throws IOException {
        System.out.print("Satir bilgileri\n" +
                "Username icin 0\n" +
                "Password icin 1\n" +
                "Address  icin 2\n" +
                "Zipcode  icin 3\n" +
                "City     icin 4\n" +
                "State    icin 5\n" +
                "Yazdirilacak Satir Seciniz : ");
        Scanner oku = new Scanner(System.in);
        String sutun = oku.nextLine();
        switch (sutun) {
            case "0": System.out.println(bul("Username"));break;
            case "1": System.out.println(bul("Password"));break;
            case "2": System.out.println(bul("Address"));break;
            case "3": System.out.println(bul("Zipcode"));break;
            case "4": System.out.println(bul("City"));break;
            case "5": System.out.println(bul("State"));break;
        }
    }
    public static String bul(String arananKelime) {
        String donecek = "";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            if (cell.toString().equalsIgnoreCase(arananKelime))
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
                    donecek += row.getCell(j) + " ";
        }
        return donecek;
    }
}