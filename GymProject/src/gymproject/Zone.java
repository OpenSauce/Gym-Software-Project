/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls the booking array list to assign a zone.
 * @author HopefulSplash
 */
public class Zone implements Serializable {
//added 'public'
   private ArrayList<Booking> bookingList = new ArrayList <Booking>();
   private int number;

    public Zone(int number) {
        this.number = number;
    }

    public void addBooking(Booking b){
        this.bookingList.add(b);
    }
    
    public void removeBooking(Booking b){
        this.bookingList.remove(b);
    }
    
    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
