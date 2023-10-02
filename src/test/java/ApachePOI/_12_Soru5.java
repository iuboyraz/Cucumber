package ApachePOI;

import Utilities.ExcelUtility;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _12_Soru5 {

    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/ExcelFiles/SenaryoSonuclari.xlsx";
        String bilgi="test passed";

        writeToExcel(path,bilgi);// excel dosyasý create oluyor
        writeToExcel(path,bilgi);// excel dosyasý artýk var, alt taraftaki kodlar çalýþacak
        writeToExcel(path,bilgi);
        writeToExcel(path,bilgi);
    }

    public static void writeToExcel (String path, String bilgi){

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
            hucre.setCellValue(bilgi + " dosya create oldu."); // hücreye istediðini set et.

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
            Cell yeniHucre = yeniSatir.createCell(0); // ilk hücre oluþturuldu
            yeniHucre.setCellValue(bilgi);// yazma iþi yapýldý

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

