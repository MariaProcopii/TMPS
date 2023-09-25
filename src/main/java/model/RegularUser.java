package model;


public class RegularUser implements User {

    private static int countID = 1;
    private int userID;
    private String username;

    public RegularUser(String username) {
        userID = countID++;
        this.username = username;
    }

    public boolean isAdmin() {
        return false;
    }

    @Override
    public String toString() {
        return "RegularUser: " + "UserID=" + userID +
                " username='" + username ;
    }
}
