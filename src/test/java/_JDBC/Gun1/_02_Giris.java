package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Giris extends JDBCParent {

    @Test
    public  void  test1() throws SQLException {
        ResultSet sonuc = sorguEkrani.executeQuery("select * from customer");

        sonuc.next(); // 1. satýrdayým

        System.out.println("ad = " + sonuc.getString("first_name"));
        System.out.println("soyad = " + sonuc.getString("last_name"));

        sonuc.next(); // 2. satýrdayým

        System.out.println("ad = " + sonuc.getString("first_name"));
        System.out.println("soyad = " + sonuc.getString("last_name"));
    }
}
