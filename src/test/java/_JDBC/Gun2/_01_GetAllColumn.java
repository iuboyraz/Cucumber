package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetAllColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");

        rs.last();

        String id = rs.getString(1);// 1. kolon city_id
        System.out.println("id = " + id);

        // eðer field'ýn tipi uygunsa deðer int olarakta alýnabilir.
        int intId = rs.getInt(1);
        System.out.println("intId = " + intId);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        // tablodaki verilerin haricindeki veriler; sütun/kolon sayýsý, sütun/kolon isim ve tipleri gibi.
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount(); // kaç tane sütun/kolon var

        rs.next(); // 1. satýra gittim.
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rs.getString(i) + " ");
            // 1.satýrýn sütunlarýnda bulunan tüm datayý yazdýrdým.
        }

        System.out.println();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));
            // rsmd bulunan sütunlarýn/kolonlarýn isimlerini ve tiplerini yazdýrdým.
        }
    }

    // language tablosundaki tüm satýrlarý ve tüm sütunlarý yazdýrýnýz,
    // ayný mysql sonuç ekranýnda olduðu gibi

    @Test
    public void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        // int columnCount = rsmd.getColumnCount(); // kaç tane sütun/kolon var

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
            // rsmd bulunan sütunlarýn/kolonlarýn isimlerini yazdýrdým.
        }

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
                // 1.satýrýn sütunlarýnda bulunan tüm datayý yazdýrdým.
            }
            System.out.println();
        }
    }

    // 2. testte printf kullanýmý
    /*
     % : deðiþkenin deðerini iþaret eder
     - : sola dayalý yazdýrýr, default saða dayalý
     20: kaç hane kullanýlacak onun bilgisi
     s : string deðerler için "s" , sayýsal deðerler için "d" kullanýlýr
     "%5.2f" : toplam 5 hane kullan, ondalýklý kýsým için 2 hane kullan, deðiþken tipi float
     */

    @Test
    public void test3_Printf() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        // int columnCount = rsmd.getColumnCount(); // kaç tane sütun/kolon var

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s", rsmd.getColumnName(i));
            // rsmd bulunan sütunlarýn/kolonlarýn isimlerini yazdýrdým.
        }

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%-20s", rs.getString(i));
                // 1.satýrýn sütunlarýnda bulunan tüm datayý yazdýrdým.
            }
            System.out.println();
        }
    }

    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasýný bir ArrayList olarak döndürsün
    @Test
    public void test4() throws SQLException {
        String sql = "select * from language";
        List<List<String>> returnList = getDataList(sql); // Dönen liste
        // System.out.println("returnList = " + returnList); // Dönen listedeki verileri yan yana yazdýrýyor

        //---------------------Liste Baþlýklarý-------------------

        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i)+" ");
        }

        System.out.println();

        //---------------------Dönen Listedeki Satýrlar-------------------

        for (int i = 0; i < returnList.size() ; i++) {
            System.out.println(returnList.get(i));
        }
        System.out.println();
    }

    public List<List<String>> getDataList(String sql) {
        List<List<String>> dataList = new ArrayList<>(); // row larý ekleyeceðim bir table oluþturdum
        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                List<String> rowList = new ArrayList<>(); // row lardaki datalarý ekleyeceðim bir liste oluþturdum
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i)); // satýrý okuyup row isimli listeye ekliyorum
                }
                dataList.add(rowList); // row'u table'a ekliyorum.
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dataList;
    }

    // TODO (Challenge) : DB den Customer tablosunu okuyarak , yeni bir EXCELE yazdýrýnýz.
}
