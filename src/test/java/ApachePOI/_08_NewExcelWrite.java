package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {

    public static void main(String[] args) throws IOException {
        //Hafýzada yeni dosya oluþturma iþlemlerini yap------------------------------------------------------------------------------------//

        // hafýzada worbook ve içinde sheet oluþtur.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");// sheet'e isim ver.

        //Ýþlemlerini yap------------------------------------------------------------------------------------//

        // hafýzadaki sheet te yeni bir satýr oluþtur
        Row yeniSatir = sheet.createRow(0);
        Cell hucre = yeniSatir.createCell(0);
        hucre.setCellValue("Merhaba Dünya"); // hücreye istediðini set et.

        //Dosyayý kaydet ve kapat------------------------------------------------------------------------------------//

        // dosyayý kaydet
        String path = "src/test/java/ApachePOI/ExcelFiles/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("iþlem tamamlandý");
    }
}
