package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Kullanýcý aþaðýdaki excelde, 1.sutundaki bilgilerden istediðini girecek
 * karþýlýðýnda bu bilginin satýrýndaki karþýlýk gelen bilgilerin tamamý yazdýrýlacak.
 * yani metoda "Password" kelimesi gönderilecek, dönen deðer Password un deðeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanýnýz.
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

                // aradýðým satýrý buldum: i. satýr
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    donecek += sheet.getRow(i).getCell(j);
                }
            }
        }
        return donecek;
    }
}













