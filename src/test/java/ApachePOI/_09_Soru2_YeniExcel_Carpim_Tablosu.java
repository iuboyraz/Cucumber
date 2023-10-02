package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpým tablosunu
 *  YENÝ bir excel dosyasýna
 *  1 den 10 kadar çarpýmlar için yapýnýz.
 *  (ipucu önce sadece 1 leri yapýnýz sonra
 *  diðerlerini)
 */

public class _09_Soru2_YeniExcel_Carpim_Tablosu {

    public static void main(String[] args) throws IOException {
        //Hafýzada yeni dosya oluþturma iþlemlerini yap------------------------------------------------------------------------------------//

        // hafýzada worbook ve içinde sheet oluþtur.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // sheet'e isim ver.

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

        //Dosyayý kaydet ve kapat------------------------------------------------------------------------------------//

        // dosyayý kaydet
        String path = "src/test/java/ApachePOI/ExcelFiles/YeniExcelCarpimTablosu.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("iþlem tamamlandý");
    }
}
