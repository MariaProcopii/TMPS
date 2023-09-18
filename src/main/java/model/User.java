package model;

import java.util.*;

public class User {

    private static int countID = 1;
    private int userID;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userID = countID++;
    }
    public User(){}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
