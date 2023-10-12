package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
//         Bir sorgunun �al��mas� i�in yap�lanlar;
//        0- �ncelikle tan�mlamalar yap�ld�.

        String HostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

//        1- Ba�lant� bilgilerini girdik / connection bilgileri set edildi.
        Connection baglanti = DriverManager.getConnection(HostUrl,username,password);

//        2- DB se�tik.

        // ilk ad�mda se�tik -> String HostUrl="db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"

//        3- Sorgu ekran�n� a�t�k
        Statement sorguEkrani = baglanti.createStatement();

//        4- Sorgu ekran�na sorguyu yazd�m, �al��t�rd�m ve sonu�lar� ald�m.
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer");

//        5- Altta sonu�lar g�z�kt�
        sonucTablosu.next(); // 1. sat�rday�m

        String ad = sonucTablosu.getString("first_name");
        String soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); // 2. sat�rday�m

        ad = sonucTablosu.getString("first_name");
        soyad = sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        baglanti.close(); // ba�lant�y� kapatt�m
    }
}
