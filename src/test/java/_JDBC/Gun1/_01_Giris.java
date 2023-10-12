package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
//         Bir sorgunun çalýþmasý için yapýlanlar;
//        0- Öncelikle tanýmlamalar yapýldý.

        String HostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

//        1- Baðlantý bilgilerini girdik / connection bilgileri set edildi.
        Connection baglanti = DriverManager.getConnection(HostUrl,username,password);

//        2- DB seçtik.

        // ilk adýmda seçtik -> String HostUrl="db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"

//        3- Sorgu ekranýný açtýk
        Statement sorguEkrani = baglanti.createStatement();

//        4- Sorgu ekranýna sorguyu yazdým, çalýþtýrdým ve sonuçlarý aldým.
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer");

//        5- Altta sonuçlar gözüktü
        sonucTablosu.next(); // 1. satýrdayým

        String ad = sonucTablosu.getString("first_name");
        String soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); // 2. satýrdayým

        ad = sonucTablosu.getString("first_name");
        soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        baglanti.close(); // baðlantýyý kapattým
    }
}
