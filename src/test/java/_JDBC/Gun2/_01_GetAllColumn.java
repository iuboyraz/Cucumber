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

        // e�er field'�n tipi uygunsa de�er int olarakta al�nabilir.
        int intId = rs.getInt(1);
        System.out.println("intId = " + intId);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        // tablodaki verilerin haricindeki veriler; s�tun/kolon say�s�, s�tun/kolon isim ve tipleri gibi.
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount(); // ka� tane s�tun/kolon var

        rs.next(); // 1. sat�ra gittim.
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rs.getString(i) + " ");
            // 1.sat�r�n s�tunlar�nda bulunan t�m datay� yazd�rd�m.
        }

        System.out.println();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i));
            // rsmd bulunan s�tunlar�n/kolonlar�n isimlerini ve tiplerini yazd�rd�m.
        }
    }

    // language tablosundaki t�m sat�rlar� ve t�m s�tunlar� yazd�r�n�z,
    // ayn� mysql sonu� ekran�nda oldu�u gibi

    @Test
    public void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        // int columnCount = rsmd.getColumnCount(); // ka� tane s�tun/kolon var

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
            // rsmd bulunan s�tunlar�n/kolonlar�n isimlerini yazd�rd�m.
        }

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
                // 1.sat�r�n s�tunlar�nda bulunan t�m datay� yazd�rd�m.
            }
            System.out.println();
        }
    }

    // 2. testte printf kullan�m�
    /*
     % : de�i�kenin de�erini i�aret eder
     - : sola dayal� yazd�r�r, default sa�a dayal�
     20: ka� hane kullan�lacak onun bilgisi
     s : string de�erler i�in "s" , say�sal de�erler i�in "d" kullan�l�r
     "%5.2f" : toplam 5 hane kullan, ondal�kl� k�s�m i�in 2 hane kullan, de�i�ken tipi float
     */

    @Test
    public void test3_Printf() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        // int columnCount = rsmd.getColumnCount(); // ka� tane s�tun/kolon var

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s", rsmd.getColumnName(i));
            // rsmd bulunan s�tunlar�n/kolonlar�n isimlerini yazd�rd�m.
        }

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%-20s", rs.getString(i));
                // 1.sat�r�n s�tunlar�nda bulunan t�m datay� yazd�rd�m.
            }
            System.out.println();
        }
    }

    // bir metoda sorguyu("select * from language") g�nderiniz,
    // metod size sorgunun datas�n� bir ArrayList olarak d�nd�rs�n
    @Test
    public void test4() throws SQLException {
        String sql = "select * from language";
        List<List<String>> returnList = getDataList(sql); // D�nen liste
        // System.out.println("returnList = " + returnList); // D�nen listedeki verileri yan yana yazd�r�yor

        //---------------------Liste Ba�l�klar�-------------------

        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i)+" ");
        }

        System.out.println();

        //---------------------D�nen Listedeki Sat�rlar-------------------

        for (int i = 0; i < returnList.size() ; i++) {
            System.out.println(returnList.get(i));
        }
        System.out.println();
    }

    public List<List<String>> getDataList(String sql) {
        List<List<String>> dataList = new ArrayList<>(); // row lar� ekleyece�im bir table olu�turdum
        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                List<String> rowList = new ArrayList<>(); // row lardaki datalar� ekleyece�im bir liste olu�turdum
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i)); // sat�r� okuyup row isimli listeye ekliyorum
                }
                dataList.add(rowList); // row'u table'a ekliyorum.
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dataList;
    }

    // TODO (Challenge) : DB den Customer tablosunu okuyarak , yeni bir EXCELE yazd�r�n�z.
}
