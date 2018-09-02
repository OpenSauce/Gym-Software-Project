
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls and returns the staff list array to be used.
 * @author Harry Clewlow, Leigh Lawley
 */
public class StaffDatabase implements Serializable {
    private static final long serialVersionUID = 19981018L;
    private ArrayList<Staff> staffList = new ArrayList <Staff>();
    private Staff s1;
    public StaffDatabase() {
        
    }
    
    public Staff getStaff(){
        
        return s1;
    }
    
    public void seStaff(Staff staff){
        s1= staff;
    }
    
    public StaffDatabase(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }
    
    public void addStaff(Staff staffToAdd) {
        if(staffList.add(staffToAdd)) {
        }
    }
    
    public ArrayList<Staff> getList() {
        return staffList;
    }
    
    public void deleteStaff(Staff staffToDelete) {
        if(staffList.remove(staffToDelete)) {
        } else {
        }
    }
    
    public boolean checkDetails(String username, String password) {
        for(Staff s : staffList) {
            if(s.getUsername().equalsIgnoreCase(username) && s.getPassword().equals(password))
            {
                    s1 = s;
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