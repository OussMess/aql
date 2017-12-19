package Beans;

import session.ConnectDb;

import java.util.*;

public class Authentification {
    ConnectDb connectDb;


    public void setConnectBD(ConnectDb connectDb){
        this.connectDb =  connectDb;
    }

    public boolean isCorrectLoginPassword(String username, String password){
        return (connectDb.checkUsernamePassword(username, password));
    }
    public boolean isCorrectLogin(String login ){
        return connectDb.checkUsername(login);
    }

}
