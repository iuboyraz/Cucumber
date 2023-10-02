package ApachePOI;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/ExcelFiles/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // sheet te fiziki olarak kullan�lan toplam sat�r say�s�
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {// sat�r say�s�
            // Burada her bir sat�r�n ka� h�cresi var onu bulup
            // oraya kadar olan h�creleri alaca��z.
            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();// s�tun say�s�

            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j); // j s�tun
                System.out.println(cell + "\t");
            }
            System.out.println();
        }

        //2. Yol
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {// sat�r say�s�

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.println(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }

    }
}
