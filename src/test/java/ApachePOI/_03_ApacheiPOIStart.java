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
        // dosyan�n oldu�u yerle program (burada IntellijIDE) aras�nda bir doya yolu ba�lant�s� gerekli.
        String path = "src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx";

        // Java dosya okuma nesnesine bu yolu vererek ba�lant� kuruyorum.
        // Tek y�nl� yani okuma olarak �al���yor.
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        // Dosya okuma ba�lant�s� �zerinden �al��ma kitab�n� al�yorum.
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        // Istenen isimdeki calisma sayfasini aliyorum.
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");

        // Istenen satiri aliyorum.
        Row satir = calismaSayfasi.getRow(0); // 0. satiri ald�m.

        // Istenen hucreyi aliyorum.
        Cell hucre = satir.getCell(0); // Satirin 0. hucresini aldim.

        System.out.println("hucre = " + hucre); // hucre = Lion

    }
}
