package session;/* Created by Oussama on 14/12/2017. */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ConnectDb {
    boolean checkUsernamePassword(String username, String password);
    boolean checkUsername(String username);
    ArrayList getComments(String username);
}
