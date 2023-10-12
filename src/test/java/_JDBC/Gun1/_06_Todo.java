package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Todo extends JDBCParent {

    // TODO : city tablosundaki t�m sat�rlardaki �ehir isimlerini absolute ile yazd�r�n�z
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last(); // son sat�ra gider
        int kacinciSatirdayim = rs.getRow(); // ka��nc� sat�rday�m
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);

        for (int i = 1; i <= kacinciSatirdayim; i++) {
            rs.absolute(i);
            System.out.println(i +".sat�r = " + rs.getString("city"));
        }
    }

    // TODO : city tablosundaki t�m sat�rlardaki �ehir isimlerini relative ile yazd�r�n�z
    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last(); // son sat�ra gider
        int kacinciSatirdayim = rs.getRow(); // ka��nc� sat�rday�m
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);
        rs.first(); // ilk sat�ra gider

        for (int i = 0; i <= kacinciSatirdayim-1; i++) {
            System.out.println(i+1 +".sat�r = " + rs.getString("city"));
            rs.relative(1);
        }
    }
}


