package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel �arp�m tablosunu
 *  varolan bo� bir excel dosyas�na
 *  1 den 10 kadar �arp�mlar i�in yap�n�z.
 *  (ipucu �nce sadece 1 leri yap�n�z sonra
 *  di�erlerini)
 */

public class _07_Soru1_MevcutExcel_Carpim_Tablosu {

    public static void main(String[] args) throws IOException {
        //Mevcut dosyan�n yolunu ve shhet ini belirle------------------------------------------------------------------------------------//

        String path = "src/test/java/ApachePOI/ExcelFiles/CarpimTablosu.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // dosya okuma y�n� a��ld�
        Workbook workbook = WorkbookFactory.create(inputStream); // dosyan�n kopyas� haf�zada olu�turuldu
        Sheet sheet = workbook.getSheetAt(0);

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

        //Dosyay� kapat------------------------------------------------------------------------------------//

        inputStream.close(); // dosya okuma y�n� kapat�ld�

        // dosyay� kaydetmeye ba�l�yorum
        FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma y�n� a��ld�
        workbook.write(outputStream); // dosyay� yaz
        workbook.close();// haf�zay� kapat/bo�alt
        outputStream.close();// dosyaya yazma y�n�n� kapat

        System.out.println("i�lem bitti");
    }
}

