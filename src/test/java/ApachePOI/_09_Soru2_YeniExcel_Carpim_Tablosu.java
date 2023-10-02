package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel �arp�m tablosunu
 *  YEN� bir excel dosyas�na
 *  1 den 10 kadar �arp�mlar i�in yap�n�z.
 *  (ipucu �nce sadece 1 leri yap�n�z sonra
 *  di�erlerini)
 */

public class _09_Soru2_YeniExcel_Carpim_Tablosu {

    public static void main(String[] args) throws IOException {
        //Haf�zada yeni dosya olu�turma i�lemlerini yap------------------------------------------------------------------------------------//

        // haf�zada worbook ve i�inde sheet olu�tur.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // sheet'e isim ver.

        //��lemlerini yap------------------------------------------------------------------------------------//

        int yeniAcilacakSatirIndexi = 0; // Excel dosyas�na her zaman en ba�tan ba�lar alta eklemez.
        // sheet.getPhysicalNumberOfRows();// Kullan�l�rsa her �al��t�rmada alt�na ekler.

        for (int k = 1; k <= 10; k++) {

            for (int i = 1; i <= 10; i++) {
                // ++ her b�r islemi yeni sat�ra yaz demek
                Row satir = sheet.createRow(yeniAcilacakSatirIndexi++);

                Cell hucre1 = satir.createCell(0); hucre1.setCellValue(k);
                Cell hucre2 = satir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3 = satir.createCell(2); hucre3.setCellValue(i);
                Cell hucre4 = satir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(4); hucre5.setCellValue(k*i);
            }
            Row bosSatir = sheet.createRow(yeniAcilacakSatirIndexi++);
        }

        //Dosyay� kaydet ve kapat------------------------------------------------------------------------------------//

        // dosyay� kaydet
        String path = "src/test/java/ApachePOI/ExcelFiles/YeniExcelCarpimTablosu.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("i�lem tamamland�");
    }
}
