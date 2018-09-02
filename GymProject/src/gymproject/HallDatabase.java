
package gymproject;

import java.io.Serializable;

/**
 * Calls the hall list array.
 * @author Harry Clewlow, Leigh Lawley
 */
public class HallDatabase implements Serializable {
    private Hall hall1;
    private Hall hall2;

   
    public HallDatabase() {
        hall2 = new Hall(new Zone(1), new Zone(2), new Zone(3), new Zone(4));
        hall1 = new Hall(new Zone(1), new Zone(2), new Zone(3), new Zone(4));
    }
    
   public Hall getHall1() {
        return hall1;
    }

    public void setHall1(Hall hall1) {
        this.hall1 = hall1;
    }

    public Hall getHall2() {
        return hall2;
    }

    public void setHall2(Hall hall2) {
        this.hall2 = hall2;
    }

    
   
    
 }