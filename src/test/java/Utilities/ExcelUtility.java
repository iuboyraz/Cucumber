package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        Sheet sheet= null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("e= " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // sayfadaki her bir satýrý

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {// sütun sayýsý kadar dolaþ
                satir.add(sheet.getRow(i).getCell(j).toString());
            }
            tablo.add(satir);
        }
        return tablo;
    }

    public static void writeToExcel (String path, Scenario scenario){

        File file = new File(path);

        if (!file.exists()){

            //Yeni excel dosyasý açýlmasý için yapýlacak iþlemler

            //Hafýzada yeni dosya oluþturma iþlemlerini yap------------------------------------------------------------------------------------//

            // hafýzada workbook ve içinde sheet oluþtur.
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            //Ýþlemlerini yap------------------------------------------------------------------------------------//

            // hafýzadaki sheet te yeni bir satýr oluþtur
            Row yeniSatir = sheet.createRow(0);
            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(scenario.getName()); // 0.hücreye çalýþan senaryonun adýný set et.

            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(scenario.getStatus().toString()); // 1.hücreye çalýþan senaryonun sonucunu set et.
            // hücre sayýsýný istediðin kadar artýrabilirsin.
            // Ör: 3. hücreyi oluþturup browser adý verebilirsin. (tabiki excel dosyanda ve metod parameterinde tanýmlamak þartýyla)

            //Dosyayý kapat------------------------------------------------------------------------------------//

            try {
                // dosyayý kaydet
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }
        else {

            //var olan excel iþlemleri
            FileInputStream inputStream =null;
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                inputStream = new FileInputStream(path); // dosya okuma yönü açýldý
                workbook = WorkbookFactory.create(inputStream); // dosyanýn kopyasý hafýzada oluþturuldu
                sheet = workbook.getSheetAt(0);

            } catch (Exception ex){
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            // hafýzada yazma iþlemlerine baþlýyorum
            int sonSatirIndex = sheet.getPhysicalNumberOfRows();// son satýrýn indexi alýndý
            Row yeniSatir = sheet.createRow(sonSatirIndex);// en son sýradaki boþ yere satýr açýldý

            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(scenario.getName()); // hücreye çalýþan senaryonun adýný set et.

            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(scenario.getStatus().toString()); // hücreye çalýþan senaryonun sonucunu set et.

            try {
                inputStream.close(); // dosya okuma yönü kapatýldý
                // dosyayý kaydetmeye baþlýyorum
                FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma yönü açýldý
                workbook.write(outputStream); // dosyayý yaz
                workbook.close();// hafýzayý kapat/boþalt
                outputStream.close();// dosyaya yazma yönünü kapat
            }
            catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }
    }
}
