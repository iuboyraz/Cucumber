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

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // sayfadaki her bir sat�r�

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {// s�tun say�s� kadar dola�
                satir.add(sheet.getRow(i).getCell(j).toString());
            }
            tablo.add(satir);
        }
        return tablo;
    }

    public static void writeToExcel (String path, Scenario scenario){

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
            hucre.setCellValue(scenario.getName()); // 0.h�creye �al��an senaryonun ad�n� set et.

            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(scenario.getStatus().toString()); // 1.h�creye �al��an senaryonun sonucunu set et.
            // h�cre say�s�n� istedi�in kadar art�rabilirsin.
            // �r: 3. h�creyi olu�turup browser ad� verebilirsin. (tabiki excel dosyanda ve metod parameterinde tan�mlamak �art�yla)

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

            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(scenario.getName()); // h�creye �al��an senaryonun ad�n� set et.

            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(scenario.getStatus().toString()); // h�creye �al��an senaryonun sonucunu set et.

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
