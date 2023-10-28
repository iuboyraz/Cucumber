package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
//        Bir sorgunun çalýþmasý için yapýlanlar;
//        0- Öncelikle tanýmlamalar yapýldý.

        String HostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";//jdbc:mysql: eklendi
        String username="root";
        String password="'\"-LhCB'.%k[4S]z"; // ters slash (\) iþaretini týrnak iþaretinin (") javaya ait olmadýðýný (þifreye ait olduðunu) belirtmek için  kullandýk.

//        1- Baðlantý bilgilerini girdik / connection bilgileri set edildi.
        Connection connection = DriverManager.getConnection(HostUrl,username,password);

//        2- DB seçtik.

        // ilk adýmda seçtik -> String HostUrl="db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"

//        3- Sorgu ekranýný açtýk
        Statement statement = connection.createStatement();

//        4- Sorgu ekranýna sorguyu yazdým, çalýþtýrdým ve sonuçlarý aldým.
        ResultSet resultSet = statement.executeQuery("select * from customer");

//        5- Altta sonuçlar gözüktü
        resultSet.next(); // 1. satýrdayým


        String ad = resultSet.getString("first_name");
        String soyad = resultSet.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        resultSet.next(); // 2. satýrdayým

        ad = resultSet.getString("first_name");
        soyad = resultSet.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        connection.close(); // baðlantýyý kapattým
    }
}
