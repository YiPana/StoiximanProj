/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stoiximan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jonnie
 */
public class ConnectMSSQLServer {

    private Connection conn;

    public void dbConnect(String db_connect_string,
            String db_userid,
            String db_password) {
        try {
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(db_connect_string,
                    db_userid, db_password);
            System.out.println("database connected");
//            java.sql.Statement statement = conn.createStatement();
//            String queryString = "select * from logging";
//            ResultSet rs = statement.executeQuery(queryString);
//            while (rs.next()) {
//                System.out.println(rs.getString("Full name"));
//            }
        } catch (SQLException sqlerr) {
            System.out.println(sqlerr.getMessage());
            System.out.println("Error code : " + sqlerr.getErrorCode() + " message " + sqlerr.getMessage());
        } catch (ClassNotFoundException classnot) {
            System.out.println(classnot.getException());
        }

    }

    public void userConnect(String userid, String password) {

        try {
            java.sql.Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String queryString = "select * from logging";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()) {
                if (userid.trim().equals(rs.getString("Username").trim())) {
                    if (password.trim().equals(rs.getString("Password").trim())) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println("Welcome " + rs.getString("Full name") + " datetime : " + dtf.format(now));

                        rs.updateString("Last log in", dtf.format(now));
                        rs.updateRow();
                    }
                }
            }
        } catch (SQLException sqlerr) {
            System.out.println(sqlerr.getMessage());
            System.out.println("Error code : " + sqlerr.getErrorCode() + " message " + sqlerr.getMessage());
            //add comment
        }
    }
}
