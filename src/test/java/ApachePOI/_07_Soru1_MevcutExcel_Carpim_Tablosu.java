package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpým tablosunu
 *  varolan boþ bir excel dosyasýna
 *  1 den 10 kadar çarpýmlar için yapýnýz.
 *  (ipucu önce sadece 1 leri yapýnýz sonra
 *  diðerlerini)
 */

public class _07_Soru1_MevcutExcel_Carpim_Tablosu {

    public static void main(String[] args) throws IOException {
        //Mevcut dosyanýn yolunu ve shhet ini belirle------------------------------------------------------------------------------------//

        String path = "src/test/java/ApachePOI/ExcelFiles/CarpimTablosu.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // dosya okuma yönü açýldý
        Workbook workbook = WorkbookFactory.create(inputStream); // dosyanýn kopyasý hafýzada oluþturuldu
        Sheet sheet = workbook.getSheetAt(0);

        //Ýþlemlerini yap------------------------------------------------------------------------------------//

        int yeniAcilacakSatirIndexi = 0; // Excel dosyasýna her zaman en baþtan baþlar alta eklemez.
        // sheet.getPhysicalNumberOfRows();// Kullanýlýrsa her çalýþtýrmada altýna ekler.

        for (int k = 1; k <= 10; k++) {

            for (int i = 1; i <= 10; i++) {
                // ++ her býr islemi yeni satýra yaz demek
                Row satir = sheet.createRow(yeniAcilacakSatirIndexi++);

                Cell hucre1 = satir.createCell(0); hucre1.setCellValue(k);
                Cell hucre2 = satir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3 = satir.createCell(2); hucre3.setCellValue(i);
                Cell hucre4 = satir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(4); hucre5.setCellValue(k*i);
            }
            Row bosSatir = sheet.createRow(yeniAcilacakSatirIndexi++);
        }

        //Dosyayý kapat------------------------------------------------------------------------------------//

        inputStream.close(); // dosya okuma yönü kapatýldý

        // dosyayý kaydetmeye baþlýyorum
        FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma yönü açýldý
        workbook.write(outputStream); // dosyayý yaz
        workbook.close();// hafýzayý kapat/boþalt
        outputStream.close();// dosyaya yazma yönünü kapat

        System.out.println("iþlem bitti");
    }
}

