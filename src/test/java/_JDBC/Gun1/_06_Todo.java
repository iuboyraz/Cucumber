package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Todo extends JDBCParent {

    // TODO : city tablosundaki tüm satýrlardaki þehir isimlerini absolute ile yazdýrýnýz
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last(); // son satýra gider
        int kacinciSatirdayim = rs.getRow(); // kaçýncý satýrdayým
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);

        for (int i = 1; i <= kacinciSatirdayim; i++) {
            rs.absolute(i);
            System.out.println(i +".satýr = " + rs.getString("city"));
        }
    }

    // TODO : city tablosundaki tüm satýrlardaki þehir isimlerini relative ile yazdýrýnýz
    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last(); // son satýra gider
        int kacinciSatirdayim = rs.getRow(); // kaçýncý satýrdayým
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);
        rs.first(); // ilk satýra gider

        for (int i = 0; i <= kacinciSatirdayim-1; i++) {
            System.out.println(i+1 +".satýr = " + rs.getString("city"));
            rs.relative(1);
        }
    }
}


