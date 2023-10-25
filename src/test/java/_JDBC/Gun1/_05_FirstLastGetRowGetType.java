package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstLastGetRowGetType extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city from city");

        rs.last(); // son sat�ra gider
        System.out.println("son sat�rdaki �ehir ad� = " + rs.getString(1));

        rs.first(); // ilk sat�ra gider
        System.out.println("ilk sat�rdaki �ehir ad� = " + rs.getString(1));

        rs.last(); // son sat�ra gider
        int kacinciSatirdayim = rs.getRow(); // ka��nc� sat�rday�m
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);
    }
}
