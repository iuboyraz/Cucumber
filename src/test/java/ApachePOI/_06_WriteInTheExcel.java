package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/ExcelFiles/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // dosya okuma yönü açýldý
        Workbook workbook = WorkbookFactory.create(inputStream); // dosyanýn kopyasý hafýzada oluþturuldu
        Sheet sheet = workbook.getSheetAt(0);

        // hafýzada yazma iþlemlerine baþlýyorum
        int sonSatirIndex = sheet.getPhysicalNumberOfRows();// son satýrýn indexi alýndý
        Row yeniSatir = sheet.createRow(sonSatirIndex);// en son sýradaki boþ yere satýr açýldý
        Cell yeniHucre = yeniSatir.createCell(0); // ilk hücre oluþturuldu
        yeniHucre.setCellValue("Merhaba Dünya");// yazma iþi yapýldý

        inputStream.close(); // dosya okuma yönü kapatýldý

        // dosyayý kaydetmeye baþlýyorum
        FileOutputStream outputStream = new FileOutputStream(path);// dosyaya yazma yönü açýldý
        workbook.write(outputStream); // dosyayý yaz
        workbook.close();// hafýzayý kapat/boþalt
        outputStream.close();// dosyaya yazma yönünü kapat

        System.out.println("iþlem bitti");


    }
}
