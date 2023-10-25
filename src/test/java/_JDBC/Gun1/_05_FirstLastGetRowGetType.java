package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstLastGetRowGetType extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city from city");

        rs.last(); // son satýra gider
        System.out.println("son satýrdaki þehir adý = " + rs.getString(1));

        rs.first(); // ilk satýra gider
        System.out.println("ilk satýrdaki þehir adý = " + rs.getString(1));

        rs.last(); // son satýra gider
        int kacinciSatirdayim = rs.getRow(); // kaçýncý satýrdayým
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);
    }
}
