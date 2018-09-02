/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Allows modification of the booking frame, allowing edits to the time slot and
 * sport.
 *
 * @author Harry Clewlow, Leigh Lawley
 */
public class ModifyBookingFrame extends JFrame {

     BookingDatabase booking;
    MemberDatabase memberList;
    SportDatabase sportList;
    HallDatabase hallList;
    JList bookingList;
    MainFrame main;
    
    private Member m;
    private Sport  sport;
    private Hall hall1;
    private Booking b1;
    
    private String[] hours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31"};
    private String[] monthName = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    private String[] year = {"2012", "2013", "2014"};
    private String[] reservationType = {"Open Session", "Individual", "Team"};
    private String firstName, lastName;
    private String[] hall = {"Hall 1", "Hall 2"};
    private String[] courts = {"Court 1", "Court 2", "Court 3", "Court 4"};
    private String[] sports;
    JComboBox reservationTypeBox = new JComboBox(reservationType);
    JComboBox hallBox = new JComboBox(hall), hourBox = new JComboBox(hours),
            dayBox = new JComboBox(day), monthBox = new JComboBox(monthName),
            yearBox = new JComboBox(year);
    JCheckBox courtOne = new JCheckBox("1");
    JCheckBox courtTwo = new JCheckBox("2");
    JCheckBox courtThree = new JCheckBox("3");
    JCheckBox courtFour = new JCheckBox("4");
    JComboBox sportsBox;
    JTextArea noteArea = new JTextArea(2, 30);
    JPanel mainPanel;
    JTextField firstNameField = new JTextField(20), secondNameField = new JTextField(20);

    public ModifyBookingFrame(BookingDatabase booking, SportDatabase sportList1, MemberDatabase memberList, HallDatabase hallList1, MainFrame main) {
        super("Booking Account Details");

        this.main = main;
        this.booking = booking;
         this.memberList = memberList;
        this.sportList = sportList1;
        this.hallList = hallList1;

        sports = new String[sportList.getList().size()];




        int i = 0;
        for (Sport s : sportList.getList()) {

            sports[i] = sportList.getSportList().get(i).getSportTitle();
            i++;
        }

        sportsBox = new JComboBox(sports);

        setLocation(200, 200);

        JPanel infoPanel = new JPanel();

        bookingList = new JList(booking.getList().toArray());
        bookingList.addListSelectionListener(new ModifyBookingFrame.ListListener());

        JScrollPane listScroller = new JScrollPane(bookingList);



        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ModifyBookingFrame.CancelListener());
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ModifyBookingFrame.SaveListener());
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ModifyBookingFrame.ClearListener());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ModifyBookingFrame.DeleteListener());

        infoPanel.add(cancelButton);
        infoPanel.add(saveButton);
        infoPanel.add(clearButton);
        infoPanel.add(deleteButton);

        JTabbedPane tabPanel = new JTabbedPane();
        tabPanel.addTab("Booking Members Account Details", createMemberDetailPanel());

        add(tabPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        add(listScroller, BorderLayout.WEST);

        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createMemberDetailPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridBagLayout());

        JPanel reservationTypePanel = new JPanel();
        reservationTypePanel.add(reservationTypeBox);
        reservationTypePanel.setBorder(new TitledBorder("Reservation Type:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        fieldPanel.add(reservationTypePanel, c);

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.add(firstNameField);
        firstNamePanel.setBorder(new TitledBorder("First Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;

        fieldPanel.add(firstNamePanel, c);

        JPanel secondNamePanel = new JPanel();
        secondNamePanel.add(secondNameField);

        secondNamePanel.setBorder(new TitledBorder("Second Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0;

        fieldPanel.add(secondNamePanel, c);

        JPanel hallPanel = new JPanel();
        hallPanel.add(hallBox);

        hallPanel.setBorder(new TitledBorder("Hall:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(hallPanel, c);


        JPanel courtPanel = new JPanel();

        courtPanel.setBorder(new TitledBorder("Court:"));
        courtPanel.add(courtOne);
        courtPanel.add(courtTwo);
        courtPanel.add(courtThree);
        courtPanel.add(courtFour);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(courtPanel, c);

        JPanel datePanel = new JPanel();

        datePanel.setBorder(new TitledBorder("Date:"));
        datePanel.add(hourBox);
        datePanel.add(dayBox);
        datePanel.add(monthBox);
        datePanel.add(yearBox);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(datePanel, c);

        JPanel sportPanel = new JPanel();

        sportPanel.setBorder(new TitledBorder("Sport:"));
        sportPanel.add(sportsBox);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(sportPanel, c);

        JPanel notePanel = new JPanel();

        notePanel.setBorder(new TitledBorder("Notes:"));
        notePanel.add(noteArea);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 7;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(notePanel, c);

        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }

    private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {

            refreshList();
            
            if (e.getSource() == bookingList && !e.getValueIsAdjusting()) {
                int selectedIndex = bookingList.getSelectedIndex();


                if (selectedIndex < 0) {
                    repaint();
                } else {


                    Booking s1 = booking.getList().get(selectedIndex);

                    int i;

                    for (i = 0; i < reservationType.length; i++) {
                        if (reservationType[i].equalsIgnoreCase(s1.getReservationType())) {
                            reservationTypeBox.setSelectedIndex(i);
                        }
                    }

                    for (i = 0; i < hours.length; i++) {
                        if (hours[i].equalsIgnoreCase(s1.getHour())) {
                            hourBox.setSelectedIndex(i);
                        }
                    }

                    for (i = 0; i < day.length; i++) {
                        if (day[i].equalsIgnoreCase(s1.getDay())) {
                            dayBox.setSelectedIndex(i);
                        }
                    }


                    for (i = 0; i < monthName.length; i++) {
                        if (monthName[i].equalsIgnoreCase(s1.getMonth())) {
                            monthBox.setSelectedIndex(i);
                        }
                    }

                    for (i = 0; i < year.length; i++) {
                        if (year[i].equalsIgnoreCase(s1.getYear())) {
                            yearBox.setSelectedIndex(i);
                        }
                    }

                    for (i = 0; i < hall.length; i++) {
                        if (hall[i].equalsIgnoreCase(s1.getHall())) {
                            hallBox.setSelectedIndex(i);
                        }
                    }

                    firstNameField.setText(s1.getM().getFirstName());
                    secondNameField.setText(s1.getM().getThirdName());



                    for (i = 0; i < sports.length; i++) {
                        if (sports[i].equalsIgnoreCase(s1.getSport().getSportTitle())) {
                            sportsBox.setSelectedIndex(i);
                        }
                    }

                    noteArea.setText(s1.getNotes());


                    for (Zone z : s1.getZone()) {
                        switch (z.getNumber()) {
                            case 1:
                                courtOne.setSelected(true);
                                break;
                            case 2:
                                courtTwo.setSelected(true);
                                break;
                            case 3:
                                courtThree.setSelected(true);
                                break;
                            case 4:
                                courtFour.setSelected(true);
                                break;
                        }
                    }


                }
            }
        }
    }

    private JFrame getFrame() {
        return this;
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to cancel any changes?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                getFrame().dispose();
            }
        }
    }

    private class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
         int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to save this booking?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                int selectedIndex = bookingList.getSelectedIndex();
                Booking b1 = booking.getList().get(selectedIndex);
                String hour = (String) hourBox.getSelectedItem();
                String month = (String) monthBox.getSelectedItem();
                String day1 = (String) dayBox.getSelectedItem();
                String year1 = (String) yearBox.getSelectedItem();
                String notes1 = noteArea.getText();
                String resType = (String) reservationTypeBox.getSelectedItem();
                
                Sport sportTwoPlay = sportList.getList().get(sportsBox.getSelectedIndex());
                String hallString = null;
                
                if (hallBox.getSelectedIndex() == 0){
                    hall1 = hallList.getHall1();
                    hallString = "Hall 1";

                }
                else if (hallBox.getSelectedIndex() == 1){
                    hall1 = hallList.getHall2();
                    hallString = "Hall 2";
                }
                 
                
                 ArrayList<Zone> zone = new ArrayList <Zone>();
                
                if (courtOne.isSelected()){
                   zone.add(hall1.getZ1());
                }
                if (courtTwo.isSelected()){
                   zone.add(hall1.getZ2());
                }
                if (courtThree.isSelected()){
                   zone.add(hall1.getZ3());
                }
                if (courtFour.isSelected()){
                   zone.add(hall1.getZ4());
                }
                
                 
               b1.setZoneBooking(zone);
                
                // add members , halls , sport
            
                
                
                bookingList.repaint();
                    getFrame().repaint();
                booking.deleteBooking(b1);
                booking.addBooking(b1);

                    refreshList();
                    main.refresh();
                
          
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Cannot Over book", "Adding Member", 0, null);
            }



        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to delete this booking?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                int selectedIndex = bookingList.getSelectedIndex();

                if (selectedIndex < 0) {
                    //ADD ICON
                    JOptionPane.showMessageDialog(getFrame(), "ERROR: No booking was selected to be deleted", "Deleting A Booking", 0, null);
                } else {
                    Booking s1 = booking.getList().get(selectedIndex);

                    booking.deleteBooking(s1);
                    ClearList_Fields();

                    bookingList.setListData(booking.getList().toArray());
                    getFrame().repaint();
                }
            }
        }
    }

    private void refreshList() {

        
        courtOne.setSelected(false);
        courtTwo.setSelected(false);
        courtThree.setSelected(false);
        courtFour.setSelected(false);
        
        int selectedIndex = bookingList.getSelectedIndex();

        if (selectedIndex < 0) {

            repaint();
        } else {
            Booking s1 = booking.getList().get(selectedIndex);

            int i;

            for (i = 0; i < reservationType.length; i++) {
                if (reservationType[i].equalsIgnoreCase(s1.getReservationType())) {
                    reservationTypeBox.setSelectedIndex(i);
                }
            }

            for (i = 0; i < hours.length; i++) {
                if (hours[i].equalsIgnoreCase(s1.getHour())) {
                    hourBox.setSelectedIndex(i);
                }
            }

            for (i = 0; i < day.length; i++) {
                if (day[i].equalsIgnoreCase(s1.getDay())) {
                    dayBox.setSelectedIndex(i);
                }
            }


            for (i = 0; i < monthName.length; i++) {
                if (monthName[i].equalsIgnoreCase(s1.getMonth())) {
                    monthBox.setSelectedIndex(i);
                }
            }

            for (i = 0; i < year.length; i++) {
                if (year[i].equalsIgnoreCase(s1.getYear())) {
                    yearBox.setSelectedIndex(i);
                }
            }

            for (i = 0; i < hall.length; i++) {
                if (hall[i].equalsIgnoreCase(s1.getHall())) {
                    hallBox.setSelectedIndex(i);
                }
            }

            firstNameField.setText(s1.getM().getFirstName());
            secondNameField.setText(s1.getM().getThirdName());



            for (i = 0; i < sports.length; i++) {
                if (sports[i].equalsIgnoreCase(s1.getSport().getSportTitle())) {
                    sportsBox.setSelectedIndex(i);
                }
            }

            noteArea.setText(s1.getNotes());


            for (Zone z : s1.getZone()) {
                switch (z.getNumber()) {
                    case 1:
                        courtOne.setSelected(true);
                        break;
                    case 2:
                        courtTwo.setSelected(true);
                        break;
                    case 3:
                        courtThree.setSelected(true);
                        break;
                    case 4:
                        courtFour.setSelected(true);
                        break;
                }
            }

            repaint();
        }
    }

    private class ClearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ClearList_Fields();
        }
    }

    public void ClearList_Fields() {
        courtOne.setSelected(false);
        courtTwo.setSelected(false);
        courtThree.setSelected(false);
        courtFour.setSelected(false);
        firstNameField.setText("");
        secondNameField.setText("");
        noteArea.setText("");
        sportsBox.setSelectedIndex(0);
        hallBox.setSelectedIndex(0);
        hourBox.setSelectedIndex(0);
        reservationTypeBox.setSelectedIndex(0);
        dayBox.setSelectedIndex(0);
        monthBox.setSelectedIndex(0);


        bookingList.clearSelection();
        getFrame().repaint();
    }
}
