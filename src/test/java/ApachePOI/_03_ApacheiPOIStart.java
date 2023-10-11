package ApachePOI;

import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldFactory;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Pdf;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

public class _03_ApacheiPOIStart {

    public static void main(String[] args) throws IOException {
        // dosyan�n oldu�u yerle program (burada IntellijIDE) aras�nda gerekli olan dosya yolu ba�lant�s�n� tan�ml�yorum.
        String path = "src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx";

        // Java dosya okuma nesnesine (dosyaOkumaBaglantisi) bu yolu vererek ba�lant� kuruyorum.
        // Tek y�nl� yani okuma olarak �al���yor.
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        // Dosya okuma ba�lant�s� �zerinden �al��ma kitab�na ula��yorum.
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        // Istenen isimdeki calisma sayfasina ula��yorum.
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
        // Sheet calismaSayfasi = calismaKitabi.getSheetAt(0); // index ile ula�ma

        // Istenen satira ula��yorum.
        Row satir = calismaSayfasi.getRow(0); // 0. satira ula�t�m.

        // Istenen hucreye ula��yorum.
        Cell hucre = satir.getCell(0); // Satirin 0. hucresine ula�t�m.

        System.out.println("hucre = " + hucre); // hucre = Lion

    }
}
