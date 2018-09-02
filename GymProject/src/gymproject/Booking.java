/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The declaration and assignment of variable for the gym bookings. Get and set methods to be used within classes.
 * @author HopefulSplash
 */
public class Booking implements Serializable {
    //added <public> class 
    private Member m;
    private String reservationType;
    private String hour, day, month, year, notes;
    private Sport  sport;
    private String hall;

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }
     private ArrayList<Zone> zone = new ArrayList <Zone>();

    public Member getM() {
        return m;
    }

    public void setM(Member m) {
        this.m = m;
    }

    public Booking(Member m1, String reservation, ArrayList<Zone> hall1, String hall, 
            String hour, String day, String month, String year, Sport sport, String notes) {
        this.m = m1;
        this.reservationType = reservation;
        this.zone = hall1;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sport = sport;
        this.notes = notes;
        
        for(Zone z : hall1) {
            z.addBooking(this);
        }
    }

    public ArrayList<Zone> getZone() {
        return zone;
    }

    public void setZone(ArrayList<Zone> zone) {
        this.zone = zone;
    }

    public void setZoneBooking(ArrayList<Zone> zone) {
                for(Zone z : zone) {
            z.addBooking(this);
        }
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
     
        this.sport = sport;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String toString() {
        return "Time: "+ hour + " - Date: " + day + "/" + month + "/" + year + " - Sport: " + sport + " - Reservation Type: " + reservationType; 
    }
    
}
