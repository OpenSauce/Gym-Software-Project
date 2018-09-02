package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls the booking list array to add and delete bookings.
 *
 * @author Harry Clewlow, Leigh Lawley
 */
public class BookingDatabase implements Serializable {

    private ArrayList<Booking> bookingList = new ArrayList<Booking>();

    public BookingDatabase() {
    }

    public BookingDatabase(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void addBooking(Booking bookingToAdd) {
        if (bookingList.add(bookingToAdd)) {
        }
    }

    public ArrayList<Booking> getList() {
        return bookingList;
    }

    public void deleteBooking(Booking bookingToDelete) {
        for (Zone z : bookingToDelete.getZone()) {
            z.removeBooking(bookingToDelete);
        }

        if (bookingList.remove(bookingToDelete)) {
        } else {
        }
    }

    public boolean checkBooking(String hour, String month, String day1, String year1) {

        for (Booking b : bookingList) {



            if (b.getHour().equals(hour) && b.getDay().equals(day1) && b.getMonth().equals(month) && b.getYear().equals(year1)) {

                        return false;
                 
                
            }


        }
        return true;
    }
}