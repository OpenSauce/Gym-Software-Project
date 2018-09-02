/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;

/**
 * The declaration and assignment of variable for sport team members. Get and set methods to be used within classes.
 * @author HopefulSplash
 */
public class Team implements Serializable {
//added 'public' 
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int staffID;
    private boolean isAdmin;
/**
 * Method to return whether the account has admin access.
 * @return true or false boolean
 */
    public boolean isIsAdmin() {
        return isAdmin;
    }
/**
 * Method to set admin access.
 * @param isAdmin true or false boolean
 */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Method to set staff account details.
     * @param firstName staff first name
     * @param lastName staff last name
     * @param username staff user name log in
     * @param password staff log in password
     * @param staffID staff ID assigned to the account
     * @param isAdmin boolean for whether the account has admin rights
     */
    public Team(String firstName, String lastName, String username, String password, int staffID, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.staffID = staffID;
        this.isAdmin = isAdmin;
    }

    /**
     * Method to set the account first name detail
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }
/**
 * Method to set the first name
 * @param firstName 
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Method to get the last name
 * @return 
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Method to set the last name
 * @param lastName 
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * Method to return the user name
 * @return 
 */
    public String getUsername() {
        return username;
    }
/**
 * Method to set the user name
 * @param username 
 */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method to return the password
     * @return 
     */
    public String getPassword() {
        return password;
    }
/**
 * Method to set the password
 * @param password 
 */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to return staff ID
     * @return 
     */
    public int getStaffID() {
        return staffID;
    }
/**
 * Method to set staff ID to account
 * @param staffID 
 */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
}
