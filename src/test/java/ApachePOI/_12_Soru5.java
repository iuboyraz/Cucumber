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

        writeToExcel(path,bilgi);// excel dosyas� create oluyor
        writeToExcel(path,bilgi);// excel dosyas� art�k var, alt taraftaki kodlar �al��acak
        writeToExcel(path,bilgi);
        writeToExcel(path,bilgi);
    }

    public static void writeToExcel (String path, String bilgi){

        File file = new File(path);

        if (!file.exists()){

            //Yeni excel dosyas� a��lmas� i�in yap�lacak i�lemler

            //Haf�zada yeni dosya olu�turma i�lemlerini yap------------------------------------------------------------------------------------//

            // haf�zada workbook ve i�inde sheet olu�tur.
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            //��lemlerini yap------------------------------------------------------------------------------------//

            // haf�zadaki sheet te yeni bir sat�r olu�tur
            Row yeniSatir = sheet.createRow(0);
            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(bilgi + " dosya create oldu."); // h�creye istedi�ini set et.

            //Dosyay� kapat------------------------------------------------------------------------------------//

            try {
                // dosyay� kaydet
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

            //var olan excel i�lemleri
            FileInputStream inputStream =null;
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                inputStream = new FileInputStream(path); // dosya okuma y�n� a��ld�
                workbook = WorkbookFactory.create(inputStream); // dosyan�n kopyas� haf�zada olu�turuldu
                sheet = workbook.getSheetAt(0);

            } catch (Exception ex){
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            // haf�zada yazma i�lemlerine ba�l�yorum
            int sonSatirIndex = sheet.getPhysicalNumberOfRows();// son sat�r�n indexi al�nd�
            Row yeniSatir = sheet.createRow(sonSatirIndex);// en son s�radaki bo� yere sat�r a��ld�
            Cell yeniHucre = yeniSatir.createCell(0); // ilk h�cre olu�turuldu
            yeniHucre.setCellValue(bilgi);// yazma i�i yap�ld�

            try {
                inputStream.close(); // dosya okuma y�n� kapat�ld�
                // dosyay� kaydetmeye ba�l�yorum
                FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma y�n� a��ld�
                workbook.write(outputStream); // dosyay� yaz
                workbook.close();// haf�zay� kapat/bo�alt
                outputStream.close();// dosyaya yazma y�n�n� kapat
            }
            catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }
    }
}

