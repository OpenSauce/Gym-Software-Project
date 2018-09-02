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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Creation of the member blacklist frame. New and existing member details can be added.
 * @author Harry Clewlow, Leigh Lawley
 */
public class ViewBlacklistedFrame extends JFrame {
    
    MemberDatabase members;
    JList memberList;

    JTextField firstNameField = new JTextField(25), secondNameField = new JTextField(25);
    JTextField middleNameField = new JTextField(25), ageField = new JTextField(2);
    JTextField firstAddressField = new JTextField(25), postcodeField = new JTextField(10);
    JTextField secondAddressField = new JTextField(25), cityField = new JTextField(25);
    JTextField countyField = new JTextField(25), emailField = new JTextField(25);
    JTextField daytimePhoneField = new JTextField(11), eveningPhoneField = new JTextField(11);
    JTextField mobilePhoneField = new JTextField(11);
    JTextField gpFirstNameField = new JTextField(25), gpSecondNameField = new JTextField(25);
    JTextField gpFirstAddressField = new JTextField(25), gpPostcodeField = new JTextField(10);
    JTextField gpSecondAddressField = new JTextField(25), gpCityField = new JTextField(25);
    JTextField gpCountyField = new JTextField(25);
    JTextField gpPhoneField = new JTextField(11);
    JPasswordField cardNumberField = new JPasswordField(16), securityNumberField = new JPasswordField(3);
    ;
    JTextField cardNameField = new JTextField(30);
    JTextField kinNameField = new JTextField(25), kinPhoneField = new JTextField(11);
    JComboBox expiryDateBox, expiryMonthsBox, validDateBox, validMonthsBox, cardTypeBox;
    
    
    /**
     * Method positions the first outer frame of the window including buttons and text fields.
     * @param members parameter relative to the member list array
     */
    public ViewBlacklistedFrame(MemberDatabase members) {
        super("Gym Membership Blacklist");
        
        this.members = members;
        
        Dimension d = new Dimension(1400, 800);
        
        
        setLocation(200, 200);
        
        JPanel infoPanel = new JPanel();
        
        memberList = new JList(members.getBlackListedMemberList().toArray());
        memberList.addListSelectionListener(new ListListener());
        
        JScrollPane listScroller = new JScrollPane(memberList);
        
        
        
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener());
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearListener());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());
        
        infoPanel.add(cancelButton);
        infoPanel.add(clearButton);
        infoPanel.add(deleteButton);
        
        JTabbedPane tabPanel = new JTabbedPane();
        tabPanel.addTab("Member Details", createMemberDetailPanel());
        tabPanel.addTab("Doctor Details", createDoctorDetailPanel());
        tabPanel.addTab("Card Details", createCardDetailPanel());
        
        add(tabPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        add(listScroller, BorderLayout.WEST);

        
           firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        secondNameField.setEditable(false);
        ageField.setEditable(false);
        
        firstAddressField.setEditable(false);
        postcodeField.setEditable(false);
        secondAddressField.setEditable(false);
        cityField.setEditable(false);
        countyField.setEditable(false);
        emailField.setEditable(false);
        daytimePhoneField.setEditable(false);
        eveningPhoneField.setEditable(false);
        mobilePhoneField.setEditable(false);
        
        gpFirstNameField.setEditable(false);
        gpSecondNameField.setEditable(false);
        gpFirstAddressField.setEditable(false);
        gpPostcodeField.setEditable(false);
        gpSecondAddressField.setEditable(false);
        gpCityField.setEditable(false);
        gpCountyField.setEditable(false);
        gpPhoneField.setEditable(false);
        
        
        cardNumberField.setEditable(false);
        securityNumberField.setEditable(false);
        cardNameField.setEditable(false);
        
        kinNameField.setEditable(false);
        kinPhoneField.setEditable(false);
        
        cardTypeBox.setEditable(false);

        expiryDateBox.setEditable(false);
        expiryMonthsBox.setEditable(false);
        
        validDateBox.setEditable(false);
        validMonthsBox.setEditable(false);
        
        
        pack();
        setResizable(false);
        setVisible(true);
    }
    
    /**
     * Method to create the positioning of the member details to be entered. 
     * Text field panel and borders for the name, address, county and phone number.
     * @return fieldpanel to be called
     */
    private JPanel createMemberDetailPanel() {
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        
        JPanel firstNamePanel = new JPanel();
        firstNamePanel.add(firstNameField);
        firstNamePanel.setBorder(new TitledBorder("First Name:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        
        fieldPanel.add(firstNamePanel, c);
        
        JPanel middleNamePanel = new JPanel();
        middleNamePanel.add(middleNameField);
        
        middleNamePanel.setBorder(new TitledBorder("Middle Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(middleNamePanel, c);
        
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
        
        JPanel agePanel = new JPanel();
        agePanel.add(ageField);
        
        agePanel.setBorder(new TitledBorder("Age:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        fieldPanel.add(agePanel, c);
        
        JPanel firstAddressPanel = new JPanel();
        firstAddressPanel.add(firstAddressField);
        firstAddressPanel.setBorder(new TitledBorder("Address Line 1:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.0;
        c.weighty = 0.0;
        
        fieldPanel.add(firstAddressPanel, c);
        
        JPanel secondAddressPanel = new JPanel();
        secondAddressPanel.add(secondAddressField);
        
        secondAddressPanel.setBorder(new TitledBorder("Address Line 2:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(secondAddressPanel, c);
        
        JPanel cityPanel = new JPanel();
        cityPanel.add(cityField);
        
        cityPanel.setBorder(new TitledBorder("City:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(cityPanel, c);
        
        JPanel countyPanel = new JPanel();
        countyPanel.add(countyField);
        
        countyPanel.setBorder(new TitledBorder("County:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 7;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(countyPanel, c);
        
        JPanel postcodePanel = new JPanel();
        postcodePanel.add(postcodeField);
        
        postcodePanel.setBorder(new TitledBorder("Postcode:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 8;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(postcodePanel, c);
        
        JPanel emailPanel = new JPanel();
        emailPanel.add(emailField);
        
        emailPanel.setBorder(new TitledBorder("E-mail:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 9;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(emailPanel, c);
        
        JPanel daytimePhonePanel = new JPanel();
        daytimePhonePanel.add(daytimePhoneField);
        
        daytimePhonePanel.setBorder(new TitledBorder("Daytime Phone Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 10;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(daytimePhonePanel, c);
        
        JPanel eveningPhonePanel = new JPanel();
        eveningPhonePanel.add(eveningPhoneField);
        
        eveningPhonePanel.setBorder(new TitledBorder("Evening Phone Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 11;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(eveningPhonePanel, c);
        
        JPanel mobilePhonePanel = new JPanel();
        mobilePhonePanel.add(mobilePhoneField);
        
        mobilePhonePanel.setBorder(new TitledBorder("Mobile Phone Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 12;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        fieldPanel.add(mobilePhonePanel, c);
        
        return fieldPanel;
    }
    
   /**
    * Method to create the positioning of the doctor details.
    * @return fieldpanel to be returned
    */
    private JPanel createDoctorDetailPanel() {
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        
        JPanel gpFirstNamePanel = new JPanel();
        gpFirstNamePanel.add(gpFirstNameField);
        gpFirstNamePanel.setBorder(new TitledBorder("Doctor's First Name:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpFirstNamePanel, c);
        
        JPanel gpSecondNamePanel = new JPanel();
        gpSecondNamePanel.add(gpSecondNameField);
        
        gpSecondNamePanel.setBorder(new TitledBorder("Doctor's Second Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(gpSecondNamePanel, c);
        
        JPanel gpFirstAddressPanel = new JPanel();
        gpFirstAddressPanel.add(gpFirstAddressField);
        gpFirstAddressPanel.setBorder(new TitledBorder("Doctor's Address Line 1:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpFirstAddressPanel, c);
        
        JPanel gpSecondAddressPanel = new JPanel();
        gpSecondAddressPanel.add(gpSecondAddressField);
        
        gpSecondAddressPanel.setBorder(new TitledBorder("Doctor's Address Line 2:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(gpSecondAddressPanel, c);
        
        JPanel gpCityPanel = new JPanel();
        gpCityPanel.add(gpCityField);
        
        gpCityPanel.setBorder(new TitledBorder("Doctor's City:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpCityPanel, c);
        
        JPanel gpCountyPanel = new JPanel();
        gpCountyPanel.add(gpCountyField);
        
        gpCountyPanel.setBorder(new TitledBorder("Doctor's County:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpCountyPanel, c);
        
        JPanel gpPostcodePanel = new JPanel();
        gpPostcodePanel.add(gpPostcodeField);
        
        gpPostcodePanel.setBorder(new TitledBorder("Doctor's Postcode:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpPostcodePanel, c);
        
        JPanel gpPhonePanel = new JPanel();
        gpPhonePanel.add(gpPhoneField);
        
        gpPhonePanel.setBorder(new TitledBorder("Doctor's Phone Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 7;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(gpPhonePanel, c);
        
        JPanel kinNamePanel = new JPanel();
        kinNamePanel.add(kinNameField);
        
        kinNamePanel.setBorder(new TitledBorder("Next of Kin's Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 8;
        c.weightx = 1.0;
        c.weighty = 0.0;
        
        fieldPanel.add(kinNamePanel, c);
        
        JPanel kinPhonePanel = new JPanel();
        kinPhonePanel.add(kinPhoneField);
        
        kinPhonePanel.setBorder(new TitledBorder("Next of Kin's Phone Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 9;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        fieldPanel.add(kinPhonePanel, c);
        
        return fieldPanel;
    }
    
    /**
     * Method to create the positioning of the member's card details to be entered.
     * @return fieldPanel to be called.
     */
    private JPanel createCardDetailPanel() {
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        
        JPanel cardNamePanel = new JPanel();
        cardNamePanel.add(cardNameField);
        cardNamePanel.setBorder(new TitledBorder("Cardholder's Name:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        
        fieldPanel.add(cardNamePanel, c);
        
        JPanel cardTypePanel = new JPanel();
        String[] cardTypes = {"Credit Card", "Debit Card"};
        cardTypeBox = new JComboBox(cardTypes);
        cardTypePanel.add(cardTypeBox);
        
        cardTypePanel.setBorder(new TitledBorder("Card Type:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(cardTypePanel, c);
        
        JPanel cardNumberPanel = new JPanel();
        cardNumberPanel.add(cardNumberField);
        
        cardNumberPanel.setBorder(new TitledBorder("Card Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(cardNumberPanel, c);
        
        Calendar d = new GregorianCalendar();
        int v = d.get(Calendar.YEAR);
        int v1 = v - 5, v2 = v - 4, v3 = v - 3, v4 = v - 2, v5 = v - 1;
        String[] years = {Integer.toString(v1), Integer.toString(v2), Integer.toString(v3), Integer.toString(v4), Integer.toString(v5)};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",};
        validDateBox = new JComboBox(years);
        validMonthsBox = new JComboBox(months);
        
        JPanel validDatePanel = new JPanel();
        validDatePanel.add(validMonthsBox);
        validDatePanel.add(new JLabel("/"));
        validDatePanel.add(validDateBox);
        
        validDatePanel.setBorder(new TitledBorder("Valid From Date:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(validDatePanel, c);
        
        int eV = d.get(Calendar.YEAR);
        int eV1 = eV + 1, eV2 = eV + 2, eV3 = eV + 3, eV4 = eV + 4, eV5 = eV + 5;
        String[] eYears = {Integer.toString(eV),
            Integer.toString(eV1), Integer.toString(eV2), Integer.toString(eV3), Integer.toString(eV4), Integer.toString(eV5)};
        String[] eMonths = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        expiryDateBox = new JComboBox(eYears);
        expiryMonthsBox = new JComboBox(eMonths);
        
        JPanel expiryDatePanel = new JPanel();
        expiryDatePanel.add(expiryMonthsBox);
        expiryDatePanel.add(new JLabel("/"));
        expiryDatePanel.add(expiryDateBox);
        
        expiryDatePanel.setBorder(new TitledBorder("Expiry Date:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 0;
        
        fieldPanel.add(expiryDatePanel, c);
        
        JPanel securityNumberPanel = new JPanel();
        securityNumberPanel.add(securityNumberField);
        
        securityNumberPanel.setBorder(new TitledBorder("Card Security Number:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        fieldPanel.add(securityNumberPanel, c);
        return fieldPanel;
    }
    
    
    private class ListListener implements ListSelectionListener {
        /**
         * Method to set labels of text.
         * @param e calls memberlist array
         */
        public void valueChanged(ListSelectionEvent e) {
            
            if (e.getSource() == memberList && !e.getValueIsAdjusting()) {
                int selectedIndex = memberList.getSelectedIndex();
                
                System.out.println(selectedIndex);
                
                if (selectedIndex < 0) {
                    repaint();
                } else {
                    Member m1 = members.getBlackListedMemberList().get(selectedIndex);
                    
                    firstNameField.setText(m1.getFirstName());
                    middleNameField.setText(m1.getMiddleName());
                    secondNameField.setText(m1.getThirdName());
                    
                    String age = String.valueOf(m1.getAge());
                    ageField.setText(age);
                    
                    firstAddressField.setText(m1.getAddressOne());
                    postcodeField.setText(m1.getPostcode());
                    secondAddressField.setText(m1.getAddressTwo());
                    cityField.setText(m1.getCity());
                    countyField.setText(m1.getCounty());
                    emailField.setText(m1.getEmailAddress());
                    daytimePhoneField.setText(m1.getDaytimeNumber());
                    eveningPhoneField.setText(m1.getEveningNumber());
                    mobilePhoneField.setText(m1.getMobileNumber());
                    
                    gpFirstNameField.setText(m1.getGpFirstName());
                    gpSecondNameField.setText(m1.getGpLastName());
                    gpFirstAddressField.setText(m1.getGpAddressOne());
                    gpPostcodeField.setText(m1.getGpPostcode());
                    gpSecondAddressField.setText(m1.getGpAddressTwo());
                    gpCityField.setText(m1.getGpCity());
                    gpCountyField.setText(m1.getGpCounty());
                    gpPhoneField.setText(m1.getGpNumber());
                    
                    
                    cardNumberField.setText(m1.getCardNumber()); // star out all but last 4 
                    securityNumberField.setText(m1.getSecurityNumber());
                    cardNameField.setText(m1.getCardName());
                    
                    kinNameField.setText(m1.getKinName());
                    kinPhoneField.setText(m1.getKinNumber());
                    
                    cardTypeBox.setSelectedItem(m1.getCardType()); // dont 

                    expiryDateBox.setSelectedItem(m1.getExpiryYearDate());
                    expiryMonthsBox.setSelectedItem(m1.getExpiryMonthDate());
                    
                    validDateBox.setSelectedItem(m1.getValidYearDate());
                    validMonthsBox.setSelectedItem(m1.getValidMonthDate());
                }
            }
        }
    }
    
    /**
     * Method to get the JFrame to be used.
     * @return JFrame to be used.
     */
    private JFrame getFrame() {
        return this;
    }
    
    /**
     * Method for a confirmation message to appear for input details.
     * 
     */
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
    
  
    /**
     * Method for a confirmation message to appear if wanting to detail a record.
     */
    private class DeleteListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
                int c = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to unblacklist this member?",
                    "",
                    JOptionPane.YES_NO_OPTION);

            if (c == 0) {
                int selectedIndex = memberList.getSelectedIndex();
                
                if (selectedIndex < 0) {
                    //ADD ICON
                    JOptionPane.showMessageDialog(getFrame(), "ERROR: No member was selected to be deblacklisted", "Unblacklisting A Member", 0, null);
                } else {
                    Member m1 = members.getBlackListedMemberList().get(selectedIndex);
                                                         
                    members.deleteBLMember(m1);
                    ClearList_Fields();
                    
                    memberList.setListData(members.getBlackListedMemberList().toArray());
                    getFrame().repaint();
                }
            }
            
            }
    }
           
    
    
    /**
     * Method to refresh the member records. Calls from the memberlist array.
     */
    private void refreshList() {
        int selectedIndex = memberList.getSelectedIndex();
        
        
        if (selectedIndex < 0) {
            repaint();
        } else {
            Member m1 = members.getBlackListedMemberList().get(selectedIndex);
            
            firstNameField.setText(m1.getFirstName());
            middleNameField.setText(m1.getMiddleName());
            secondNameField.setText(m1.getThirdName());
            
            String age = String.valueOf(m1.getAge());
            ageField.setText(age);
            
            firstAddressField.setText(m1.getAddressOne());
            postcodeField.setText(m1.getPostcode());
            secondAddressField.setText(m1.getAddressTwo());
            cityField.setText(m1.getCity());
            countyField.setText(m1.getCounty());
            emailField.setText(m1.getEmailAddress());
            daytimePhoneField.setText(m1.getDaytimeNumber());
            eveningPhoneField.setText(m1.getEveningNumber());
            mobilePhoneField.setText(m1.getMobileNumber());
            
            gpFirstNameField.setText(m1.getGpFirstName());
            gpSecondNameField.setText(m1.getGpLastName());
            gpFirstAddressField.setText(m1.getGpAddressOne());
            gpPostcodeField.setText(m1.getGpPostcode());
            gpSecondAddressField.setText(m1.getGpAddressTwo());
            gpCityField.setText(m1.getGpCity());
            gpCountyField.setText(m1.getGpCounty());
            gpPhoneField.setText(m1.getGpNumber());
            
            
            cardNumberField.setText(m1.getCardNumber()); // star out all but last 4 
            securityNumberField.setText(m1.getSecurityNumber());
            cardNameField.setText(m1.getCardName());
            
            kinNameField.setText(m1.getKinName());
            kinPhoneField.setText(m1.getKinNumber());
            
            cardTypeBox.setSelectedItem(m1.getCardType()); // dont 

            expiryDateBox.setSelectedItem(m1.getExpiryYearDate());
            expiryMonthsBox.setSelectedItem(m1.getExpiryMonthDate());
            
            validDateBox.setSelectedItem(m1.getValidYearDate());
            validMonthsBox.setSelectedItem(m1.getValidMonthDate());
            
            repaint();
        }
    }
    /**
     * Method to clear what currently in the text fields. Calls the clearlist method.
     */
    private class ClearListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ClearList_Fields();
        }
    }
    /**
     * Method to set the fields to empty.
     */
    public void ClearList_Fields() {
        
        firstNameField.setText("");
        middleNameField.setText("");
        secondNameField.setText("");
        
        String age = String.valueOf("");
        ageField.setText(age);
        
        firstAddressField.setText("");
        postcodeField.setText("");
        secondAddressField.setText("");
        cityField.setText("");
        countyField.setText("");
        emailField.setText("");
        daytimePhoneField.setText("");
        eveningPhoneField.setText("");
        mobilePhoneField.setText("");
        
        gpFirstNameField.setText("");
        gpSecondNameField.setText("");
        gpFirstAddressField.setText("");
        gpPostcodeField.setText("");
        gpSecondAddressField.setText("");
        gpCityField.setText("");
        gpCountyField.setText("");
        gpPhoneField.setText("");
        
        
        cardNumberField.setText("");
        securityNumberField.setText("");
        cardNameField.setText("");
        
        kinNameField.setText("");
        kinPhoneField.setText("");
        
        cardTypeBox.setSelectedIndex(0); // dont 

        expiryDateBox.setSelectedIndex(0);
        expiryMonthsBox.setSelectedIndex(0);
        
        validDateBox.setSelectedIndex(0);
        validMonthsBox.setSelectedIndex(0);
        
        memberList.clearSelection();
        getFrame().repaint();
        
        
        
    }
}
