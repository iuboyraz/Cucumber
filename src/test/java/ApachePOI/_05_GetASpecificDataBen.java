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

public class _05_GetASpecificDataBen {

    public static Sheet getSheet() throws IOException {
        String path = "src/test/java/ApachePOI/ExcelFiles/LoginData.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    public static void main(String[] args) throws IOException {

        String username = getUsername();
        System.out.println("username: " + username);

        String password = getPassword();
        System.out.println("password: " + password);

        List adresList = getAddress();
        for (int i = 0; i < adresList.size(); i++) {
            System.out.println("address: " + adresList.get(i));
        }

        String zipcode = getZipcode();
        System.out.println("zipcode: " + zipcode);

        String city = getCity();
        System.out.println("city: " + city);

        String state = getState();
        System.out.println("state: " + state);
    }

    public static String getUsername() throws IOException {

        String username = getSheet().getRow(0).getCell(1) + "\t";
        return username;
    }

    public static String getPassword() throws IOException {

        String password = getSheet().getRow(1).getCell(1) + "\t";
        return password;
    }

    public static List getAddress() throws IOException {
        List addressList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String address = getSheet().getRow(2).getCell(i+1) + "\t";
           addressList.add(address);
        }
        return addressList;
    }

    public static String getZipcode() throws IOException {

        String zipcode = getSheet().getRow(3).getCell(1) + "\t";
        return zipcode;
    }

    public static String getCity() throws IOException {

        String city = getSheet().getRow(4).getCell(1) + "\t";
        return city;
    }

    public static String getState() throws IOException {

        String state = getSheet().getRow(5).getCell(1) + "\t";
        return state;
    }
}













