/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;

/**
 * Calls and returns the member list array to be used.
 * @author Harry Clewlow, Leigh Lawley
 */
public class OneDatabaseToRuleThemAll implements Serializable {
    private static final long serialVersionUID = 19981017L;
    MemberDatabase memberList;
    StaffDatabase staffList;
    BookingDatabase bookingList;
    HallDatabase hallList;

    SportDatabase sportList;
    
    public OneDatabaseToRuleThemAll() {
        memberList = new MemberDatabase();
        staffList = new StaffDatabase();
        bookingList = new BookingDatabase();
        sportList = new SportDatabase();
        hallList = new HallDatabase();
        
        Sport ps1 = new Sport("Badminton", "Play Badminton in one or multiple zones", 4, 4, 2.50 ,null, 0);
        String fbEquip [] = {"Football"};
        Sport ps2 = new Sport("Indoor football", "Play Indoor football in one or multiple zones", 4, 4, 2.50 , fbEquip, 2.50);
         String bbEquip [] = {"Basketball"};
        Sport ps3 = new Sport("Basketball", "Play Basketball in one or multiple zones", 4, 4, 2.50 ,bbEquip, 2.50);
        Sport ps4 = new Sport("Judo", "Take part in Judo in one or multiple zones", 4, 4, 2.50 ,null, 0);
        Sport ps5 = new Sport("Karate", "Take part in Karate in one or multiple zones", 4, 4, 2.50 ,null, 0);
        Sport ps6 = new Sport("Pilates", "Take part in Pilates in one or multiple zones", 4, 4, 2.50 ,null, 0);
         String tEquip [] = {"Trampoline"};
        Sport ps7 = new Sport("Trampoline", "Play on Trampolines in one or multiple zones", 4, 4, 2.50 ,tEquip, 1.50);
        Sport ps8 = new Sport("Yoga", "Take part in Yoga in one or multiple zones", 4, 4, 2.50 ,null, 0);
        
       
        
        sportList.addSport(ps1);
        sportList.addSport(ps2);
        sportList.addSport(ps3);
        sportList.addSport(ps4);
        sportList.addSport(ps5);
        sportList.addSport(ps6);
        sportList.addSport(ps7);
        sportList.addSport(ps8);
    }
    
    /**
     * 
     * @return the memberList array
     */
    public MemberDatabase getMemberDatabase() {
        return memberList;
    }
    
    public StaffDatabase getStaffDatabase() {
        return staffList;
    }
    
    public BookingDatabase getBookingDatabase() {
        return bookingList;
    }
    
    public SportDatabase getSportDatabase() {
        return sportList;
    }
    
    public HallDatabase getHallDatabase() {
        return hallList;
    }
}
