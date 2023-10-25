package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public static List<List<String>> getDataList(String sql) {
        DBConnectionOpen();// Baðlantýyý açtým

        List<List<String>> dataList = new ArrayList<>(); // row larý ekleyeceðim bir table oluþturdum

        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                List<String> rowList = new ArrayList<>(); // row lardaki datalarý ekleyeceðim bir liste oluþturdum
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i)); // satýrý okuyup row isimli listeye ekliyorum
                }
                dataList.add(rowList); // row'u table'a ekliyorum.
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        DBConnectionClose();// Baðlantýyý kapattým
        return dataList;
    }

    public static void DBConnectionOpen(){
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(HostUrl, username, password);
            statement = connection.createStatement();
        }
        catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose() {

        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }
}
