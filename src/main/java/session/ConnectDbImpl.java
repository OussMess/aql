package session;/* Created by Oussama on 14/12/2017. */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectDbImpl implements ConnectDb{
    private Connection con;

    public  ConnectDbImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  boolean checkUsernamePassword(String username, String password) {
        boolean st = false;
        try {

            PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return st;
        }

    }

    public  boolean checkUsername(String username) {
        boolean st = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from login where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return st;
        }

    }

}
