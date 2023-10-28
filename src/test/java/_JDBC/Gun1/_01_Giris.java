package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
//        Bir sorgunun �al��mas� i�in yap�lanlar;
//        0- �ncelikle tan�mlamalar yap�ld�.

        String HostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";//jdbc:mysql: eklendi
        String username="root";
        String password="'\"-LhCB'.%k[4S]z"; // ters slash (\) i�aretini t�rnak i�aretinin (") javaya ait olmad���n� (�ifreye ait oldu�unu) belirtmek i�in  kulland�k.

//        1- Ba�lant� bilgilerini girdik / connection bilgileri set edildi.
        Connection connection = DriverManager.getConnection(HostUrl,username,password);

//        2- DB se�tik.

        // ilk ad�mda se�tik -> String HostUrl="db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"

//        3- Sorgu ekran�n� a�t�k
        Statement statement = connection.createStatement();

//        4- Sorgu ekran�na sorguyu yazd�m, �al��t�rd�m ve sonu�lar� ald�m.
        ResultSet resultSet = statement.executeQuery("select * from customer");

//        5- Altta sonu�lar g�z�kt�
        resultSet.next(); // 1. sat�rday�m


        String ad = resultSet.getString("first_name");
        String soyad = resultSet.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        resultSet.next(); // 2. sat�rday�m

        ad = resultSet.getString("first_name");
        soyad = resultSet.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        connection.close(); // ba�lant�y� kapatt�m
    }
}
