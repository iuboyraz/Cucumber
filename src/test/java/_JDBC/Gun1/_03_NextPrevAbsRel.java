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
        System.out.println("1.Satýr = " + rs.getString(2)); // 2. column alýndý - English

        rs.next();
        System.out.println("2.Satýr = " + rs.getString(2)); // 2. column alýndý - Italian

        rs.previous(); // önceki satýra gider
        System.out.println("1.Satýr = " + rs.getString(2)); // 2. column alýndý - English
    }

    @Test
    public  void  test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10); // baþtan 10. satýra direkt git.
        System.out.println("10.Satýr title = " + rs.getString("title"));

        rs.absolute(-5); // sondan 5. satýra direkt git.
        System.out.println("997.Satýr title = " + rs.getString("title"));

        rs.relative(3); // bulunduðun yerden 3 satýr ileri git.
        System.out.println("1000.Satýr title = " + rs.getString("title"));

        rs.relative(-3); // bulunduðun yerden 3 satýr geri gider.
        System.out.println("997.Satýr title = " + rs.getString("title"));
    }
    // rs.next() : sonraki satýr
    // rs.previous : önceki satýr
    // rs.absolute(10) : baþtan itibaren 10.satýra gider.
    // rs.relative(10) : bulunduðu yerden 10.satýra gider.
    // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satýr
    // rs.relative(-5) :  - (eksi) bulundu yerden 5 satýr geri
}
