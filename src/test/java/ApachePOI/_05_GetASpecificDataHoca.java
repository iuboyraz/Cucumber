package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Kullan�c� a�a��daki excelde, 1.sutundaki bilgilerden istedi�ini girecek
 * kar��l���nda bu bilginin sat�r�ndaki kar��l�k gelen bilgilerin tamam� yazd�r�lacak.
 * yani metoda "Password" kelimesi g�nderilecek, d�nen de�er Password un de�eri olacak.
 * bulup ve sonucun d�nd�r�lmesi i�in metod kullan�n�z.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificDataHoca {

    public static void main(String[] args) throws IOException {

        String donenSonuc = exceldenGetir("Password");
        System.out.println(donenSonuc);
    }

    public static String exceldenGetir(String aranacakKelime) throws IOException {
        String donecek = "";

        String path = "src/test/java/ApachePOI/ExcelFiles/LoginData.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(aranacakKelime.toLowerCase())) {

                // arad���m sat�r� buldum: i. sat�r
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    donecek += sheet.getRow(i).getCell(j);
                }
            }
        }
        return donecek;
    }
}













