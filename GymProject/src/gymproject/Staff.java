/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;

/**
 *
 * @author HopefulSplash
 */
class Staff implements Serializable {
    private static final long serialVersionUID = 19981019L;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int staffID;
    private boolean isAdmin;

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Staff(String firstName, String lastName, String username, String password, int staffID, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.staffID = staffID;
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    public String toString() {
        return firstName + " " + lastName; 
    }
}
