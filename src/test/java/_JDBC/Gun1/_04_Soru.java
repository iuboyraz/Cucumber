package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

// city tablosundaki tüm satýrlardaki þehir isimlerini next ile yazdýrýnýz

public class _04_Soru extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        // 1. Yöntem
        while (rs.next())
            System.out.println(rs.getString("city"));

        // 2. Yöntem
        for (int i = 1; i <= 601; i++) {
            rs.next();
            System.out.println( i +".satýr = " + rs.getString(2)); // rs.getString("city") de kullanýlabilir.
        }
    }
}
