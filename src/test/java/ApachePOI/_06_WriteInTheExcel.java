package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/ExcelFiles/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // dosya okuma y�n� a��ld�
        Workbook workbook = WorkbookFactory.create(inputStream); // dosyan�n kopyas� haf�zada olu�turuldu
        Sheet sheet = workbook.getSheetAt(0);

        // haf�zada yazma i�lemlerine ba�l�yorum
        int sonSatirIndex = sheet.getPhysicalNumberOfRows();// son sat�r�n indexi al�nd�
        Row yeniSatir = sheet.createRow(sonSatirIndex);// en son s�radaki bo� yere sat�r a��ld�
        Cell yeniHucre = yeniSatir.createCell(0); // ilk h�cre olu�turuldu
        yeniHucre.setCellValue("Merhaba D�nya");// yazma i�i yap�ld�

        inputStream.close(); // dosya okuma y�n� kapat�ld�

        // dosyay� kaydetmeye ba�l�yorum
        FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma y�n� a��ld�
        workbook.write(outputStream); // dosyay� yaz
        workbook.close();// haf�zay� kapat/bo�alt
        outputStream.close();// dosyaya yazma y�n�n� kapat

        System.out.println("i�lem bitti");


    }
}
