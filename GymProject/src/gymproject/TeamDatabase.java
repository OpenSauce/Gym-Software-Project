
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls and returns the team list array to be used.
 * @author Harry Clewlow, Leigh Lawley
 */
public class TeamDatabase implements Serializable {
    private ArrayList<Staff> staffList = new ArrayList <Staff>();
    
    public TeamDatabase() {
        
    }
    
    public TeamDatabase(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }
    
    public void addStaff(Staff staffToAdd) {
        if(staffList.add(staffToAdd)) {
            System.out.println("Staff added!");
        }
    }
    
    public ArrayList<Staff> getList() {
        return staffList;
    }
    
    public void deleteStaff(Staff staffToDelete) {
        if(staffList.remove(staffToDelete)) {
            System.out.println("Staff deleted!");
        } else {
            System.out.println("Staff not added :(");
        }
    }
    
    public boolean checkDetails(String username, String password) {
        for(Staff s : staffList) {
            if(s.getUsername().equals(username) && s.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkUsername(String username) {
        for(Staff s : staffList) {
            if(s.getUsername().equals(username))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkStaffID(int staffID) {
        for(Staff s : staffList) {
            if(s.getStaffID() == (staffID))
            {
                return false;
            }
        }
        return true;
    }
}