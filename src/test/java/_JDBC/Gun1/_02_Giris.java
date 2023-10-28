package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Giris extends JDBCParent {

    @Test
    public  void  test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from customer");

        resultSet.next(); // 1.satýrdayým

        System.out.println("ad = " + resultSet.getString("first_name"));
        System.out.println("soyad = " + resultSet.getString("last_name"));

        resultSet.next(); // 2. satýrdayým

        System.out.println("ad = " + resultSet.getString("first_name"));
        System.out.println("soyad = " + resultSet.getString("last_name"));
    }
}
