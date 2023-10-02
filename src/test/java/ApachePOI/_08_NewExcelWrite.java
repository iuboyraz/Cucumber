package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {

    public static void main(String[] args) throws IOException {
        //Haf�zada yeni dosya olu�turma i�lemlerini yap------------------------------------------------------------------------------------//

        // haf�zada worbook ve i�inde sheet olu�tur.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");// sheet'e isim ver.

        //��lemlerini yap------------------------------------------------------------------------------------//

        // haf�zadaki sheet te yeni bir sat�r olu�tur
        Row yeniSatir = sheet.createRow(0);
        Cell hucre = yeniSatir.createCell(0);
        hucre.setCellValue("Merhaba D�nya"); // h�creye istedi�ini set et.

        //Dosyay� kaydet ve kapat------------------------------------------------------------------------------------//

        // dosyay� kaydet
        String path = "src/test/java/ApachePOI/ExcelFiles/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("i�lem tamamland�");
    }
}
