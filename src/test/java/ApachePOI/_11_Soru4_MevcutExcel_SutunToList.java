package ApachePOI;

/*
   Main den bir metod �a��rmak suretiyle, path i ve sheetName i verilen excelden
   istenilen s�tun kadar veriyi okuyup bir ArrayList e at�p yazd�r�n�z.
   Bu soruda kaynak Excel i�in : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class _11_Soru4_MevcutExcel_SutunToList {

    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=3; // okunacak s�tun say�s�

        ArrayList<ArrayList<String>> data = getData(path, sheetName, sutunSayisi);
        System.out.println("data = " + data);
    }

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
}
