package gymproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Create and display the add booking frame, to allow bookings made by a member to be assigned a sport and hall.
 * @author Harry Clewlow, Leigh Lawley
 */
public class AddBookingFrame extends JFrame {

    BookingDatabase bookingList;
    MemberDatabase memberList;
    SportDatabase sportList;
    HallDatabase hallList;
    
    private String[] hours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31"};
    private String[] mins = {"00"};
    private String[] monthName = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    private String[] year = {"2012", "2013", "2014"};
    private String[] reservationType = {"Open Session", "Individual", "Team"};
    private String firstName, lastName;
    private String[] hall = {"Hall 1", "Hall 2"};
    private String[] courts = {"Court 1", "Court 2", "Court 3", "Court 4"};
    private String[] sports;

    private Member m, m1;
    private Sport  sport;
    private Hall hall1;
    private Booking b1;
    MainFrame main;
    JComboBox reservationTypeBox = new JComboBox(reservationType);
    JComboBox hallBox = new JComboBox(hall), hourBox = new JComboBox(hours),
            dayBox = new JComboBox(day), monthBox = new JComboBox(monthName), 
            minsBox = new JComboBox(mins),
            yearBox = new JComboBox(year);
    JCheckBox courtOne = new JCheckBox("1");
    JCheckBox courtTwo = new JCheckBox("2");
    JCheckBox courtThree = new JCheckBox("3");
    JCheckBox courtFour = new JCheckBox("4");
    JComboBox sportsBox;
    JTextArea noteArea = new JTextArea(2, 30);
    JPanel mainPanel;
    JList searchJList;
    JScrollPane listScroller;
    JTextField firstNameField = new JTextField(20), secondNameField = new JTextField(20);

    /**
     *
     * @param bookingList
     */
    public AddBookingFrame(BookingDatabase bookingList, MemberDatabase memberList, SportDatabase sportList1, HallDatabase hallList1, MainFrame main) {
        super("Create A Session");

        this.bookingList = bookingList;
        this.memberList = memberList;
        this.sportList = sportList1;
        this.hallList = hallList1;
        this.main = main;
               
        sports = new String[sportList.getList().size()];
        
        int i = 0 ;
          for (Sport s : sportList.getList()){
        
            sports[i] = sportList.getSportList().get(i).getSportTitle();
            i++;
        }
          
        sportsBox = new JComboBox(sports);


        searchJList = new JList();
        searchJList.addListSelectionListener(new ListListener());

        listScroller = new JScrollPane(searchJList);
                
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(createMemberPanel(), "Main");

        firstNameField.addKeyListener(new EnterKeyListener() );
        secondNameField.addKeyListener(new EnterKeyListener() );
        getContentPane().add(mainPanel);

        setLocation(300, 300);
        pack();
        setVisible(true);
    }

    private JPanel createMemberPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        JButton nextButton = new JButton("Finish");
        nextButton.addActionListener(new FinishButtonListener());

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
        
        JPanel searchPanel = new JPanel();
        searchPanel.add(listScroller);

        searchPanel.setBorder(new TitledBorder("Select Member:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 0;

        fieldPanel.add(searchPanel, c);
        

        JPanel hallPanel = new JPanel();
        hallPanel.add(hallBox);

        hallPanel.setBorder(new TitledBorder("Hall:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
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
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(courtPanel, c);

        JPanel datePanel = new JPanel();

        datePanel.setBorder(new TitledBorder("Date:"));
        datePanel.add(dayBox);
        datePanel.add(monthBox);
        datePanel.add(yearBox);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(datePanel, c);

        JPanel timePanel = new JPanel();
  
        timePanel.setBorder(new TitledBorder("Time:"));
        timePanel.add(hourBox);
        timePanel.add(minsBox);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 7;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(timePanel, c);
        
        JPanel sportPanel = new JPanel();

        sportPanel.setBorder(new TitledBorder("Sport:"));
        sportPanel.add(sportsBox);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 8;
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
        c.gridy = 9;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(notePanel, c);

        buttonPanel.add(nextButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }
    
    private void findMember() {
       ArrayList<Member> m = memberList.checkMember(firstNameField.getText(), secondNameField.getText());
        
        searchJList.setListData(m.toArray());
        searchJList.addListSelectionListener(new ListListener());

        repaint();
    }

    private JFrame getFrame() {
        return this;
    }

    private class FinishButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to save this booking?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                
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
                
                 //hall1.getZ1().addBooking(b1);
                 
               
                
                // add members , halls , sport
            
          
                
                Booking b1 = new Booking(m, resType, zone, hallString, hour, day1, month, year1, sportTwoPlay, notes1);
                   
                if (bookingList.checkBooking(hour, month, day1, year1))  {
                bookingList.addBooking(b1);
                main.refresh();
                dispose();
             }  
          else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Cannot Over book", "Adding Member", 0, null);
            }
                
            } 



        }
    }
    
     private class EnterKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
                        findMember();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
             findMember();
             pack();
        }
    }
    
    private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {

            if (e.getSource() == searchJList && !e.getValueIsAdjusting()) {
                int selectedIndex = searchJList.getSelectedIndex();

                System.out.println(selectedIndex);

                if (selectedIndex < 0) {
                    repaint();
                } else {
                    m = memberList.getList().get(selectedIndex);
                }
            }
        }
    }
}
