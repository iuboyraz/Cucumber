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
        // dosyanýn olduðu yerle program (burada IntellijIDE) arasýnda bir doya yolu baðlantýsý gerekli.
        String path = "src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx";

        // Java dosya okuma nesnesine bu yolu vererek baðlantý kuruyorum.
        // Tek yönlü yani okuma olarak çalýþýyor.
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        // Dosya okuma baðlantýsý üzerinden çalýþma kitabýný alýyorum.
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        // Istenen isimdeki calisma sayfasini aliyorum.
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");

        // Istenen satiri aliyorum.
        Row satir = calismaSayfasi.getRow(0); // 0. satiri aldým.

        // Istenen hucreyi aliyorum.
        Cell hucre = satir.getCell(0); // Satirin 0. hucresini aldim.

        System.out.println("hucre = " + hucre); // hucre = Lion

    }
}
