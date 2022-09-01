package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        //Dosyanın yolu alındı
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // Dosya okuma işlemcisine dosyanın yolunu veriyoruz: Böylece program ile dosya arasında baglanti
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);

        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);

        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");
        Row satir=calismaSayfasi.getRow(0);
        Cell hucre=satir.getCell(0);

        System.out.print(hucre);

    }
}
