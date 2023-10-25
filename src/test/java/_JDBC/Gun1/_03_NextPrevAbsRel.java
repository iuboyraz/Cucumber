package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        System.out.println("1.Sat�r = " + rs.getString(2)); // 2. column al�nd� - English

        rs.next();
        System.out.println("2.Sat�r = " + rs.getString(2)); // 2. column al�nd� - Italian

        rs.previous(); // �nceki sat�ra gider
        System.out.println("1.Sat�r = " + rs.getString(2)); // 2. column al�nd� - English
    }

    @Test
    public  void  test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10); // ba�tan 10. sat�ra direkt git.
        System.out.println("10.Sat�r title = " + rs.getString("title"));

        rs.absolute(-5); // sondan 5. sat�ra direkt git.
        System.out.println("997.Sat�r title = " + rs.getString("title"));

        rs.relative(3); // bulundu�un yerden 3 sat�r ileri git.
        System.out.println("1000.Sat�r title = " + rs.getString("title"));

        rs.relative(-3); // bulundu�un yerden 3 sat�r geri gider.
        System.out.println("997.Sat�r title = " + rs.getString("title"));
    }
    // rs.next() : sonraki sat�r
    // rs.previous : �nceki sat�r
    // rs.absolute(10) : ba�tan itibaren 10.sat�ra gider.
    // rs.relative(10) : bulundu�u yerden 10.sat�ra gider.
    // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.sat�r
    // rs.relative(-5) :  - (eksi) bulundu yerden 5 sat�r geri
}
