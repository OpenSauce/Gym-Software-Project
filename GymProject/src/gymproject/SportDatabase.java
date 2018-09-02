
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls and returns the sport array list.
 * @author Harry Clewlow, Leigh Lawley
 */
public class SportDatabase implements Serializable {
    private static final long serialVersionUID = 19981018L;
    private ArrayList<Sport> sportList = new ArrayList <Sport>();
    private Sport s1;
    
    public SportDatabase() {
        
        
        
    }

    public ArrayList<Sport> getSportList() {
        return sportList;
    }

    public void setSportList(ArrayList<Sport> sportList) {
        this.sportList = sportList;
    }

    public Sport getS1() {
        return s1;
    }

    public void setS1(Sport s1) {
        this.s1 = s1;
    }
    
     public void addSport(Sport sportToAdd) {
        if(sportList.add(sportToAdd)) {
            
        }
     }
    
    public void deleteStaff(Sport sportToDelete) {
        if(sportList.remove(sportToDelete)) {
        }

            }

    
  

 public Sport getSport(){
        
        return s1;
    }
    
    public void setSport(Sport sport){
        s1= sport;
    }
    
    public SportDatabase(ArrayList<Sport> sportList) {
        this.sportList = sportList;
    }
    
    
    
    public ArrayList<Sport> getList() {
        return sportList;
    }
}
