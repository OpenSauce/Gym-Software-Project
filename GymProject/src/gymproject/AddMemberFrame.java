package gymproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Create and display the add member frame, to allow editing of gym member details.
 * @author Harry Clewlow, Leigh Lawley
 */
public class AddMemberFrame extends JFrame {

    MemberDatabase memberList;
    private final String MEMBERDETAILS = "Member Details";
    private final String CONTACTDETAILS = "Contact Details";
    private final String DOCTORDETAILS = "Doctor Details";
    private final String CARDDETAILS = "Card Details";
    private String firstName, middleName, thirdName;
    private int age, expiryYearDate, expiryMonthDate, validYearDate, validMonthDate;
    private String addressOne, addressTwo, city, county, postcode;
    private String daytimeNumber, eveningNumber, mobileNumber;
    private String emailAddress;
    private String gpFristName, gpLastName, gpAddressOne, gpAddressTwo, gpPostcode, gpNumber;
    private String gpCity, gpCounty;
    private String kinName, kinNumber;
    private String cardNumber, cardName, securityNumber, cardType;
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
    JTextField gpCountyField = new JTextField(25), gpPhoneField = new JTextField(11);
    JTextField cardNumberField = new JTextField(16), cardNameField = new JTextField(30);
    JTextField securityNumberField = new JTextField(3);
    JTextField kinNameField = new JTextField(25), kinPhoneField = new JTextField(11);
    JComboBox expiryDateBox, expiryMonthsBox, validDateBox, validMonthsBox, cardTypeBox;
    JPanel mainPanel;

    
    
    public AddMemberFrame(MemberDatabase memberList) {
        super("Member Registration Form");

        this.memberList = memberList;

        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(createMemberPanel(), MEMBERDETAILS);
        mainPanel.add(createContactPanel(), CONTACTDETAILS);
        mainPanel.add(createDoctorPanel(), DOCTORDETAILS);
        mainPanel.add(createCardPanel(), CARDDETAILS);

        getContentPane().add(mainPanel);

        setLocation(300, 300);
        pack();
        setVisible(true);
    }

    
    private JPanel getFrame(){
        
        return mainPanel;
        
    }
    
    private JPanel createMemberPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new FirstNextButtonListener());

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

        buttonPanel.add(nextButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }

    private JPanel createContactPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        JButton nextButton = new JButton("Next"), previousButton = new JButton("Previous");
        nextButton.addActionListener(new SecondNextButtonListener());
        previousButton.addActionListener(new previousButtonListener());

        JPanel firstAddressPanel = new JPanel();
        firstAddressPanel.add(firstAddressField);
        firstAddressPanel.setBorder(new TitledBorder("Address Line 1:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
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
        c.gridy = 1;
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
        c.gridy = 2;
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
        c.gridy = 3;
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
        c.gridy = 4;
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
        c.gridy = 5;
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
        c.gridy = 6;
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
        c.gridy = 7;
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
        c.gridy = 8;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(mobilePhonePanel, c);

        buttonPanel.add(previousButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }

    private JPanel createDoctorPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JButton nextButton = new JButton("Next"), previousButton = new JButton("Previous");
        nextButton.addActionListener(new ThirdNextButtonListener());
        previousButton.addActionListener(new previousButtonListener());

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

        buttonPanel.add(previousButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }

    private JPanel createCardPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JButton finishButton = new JButton("Finish"), previousButton = new JButton("Previous");
        finishButton.addActionListener(new FinishButtonListener());
        previousButton.addActionListener(new previousButtonListener());

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

        buttonPanel.add(previousButton, BorderLayout.WEST);
        buttonPanel.add(finishButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel);
        return memberPanel;
    }

    private class FirstNextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (Validation.isNameField(firstNameField.getText())) {
                if (Validation.isNameField(secondNameField.getText())) {
                    if (Validation.isIntegerField(ageField.getText())) {
                        firstName = firstNameField.getText();
                        middleName = middleNameField.getText();
                        thirdName = secondNameField.getText();
                        age = Integer.parseInt(ageField.getText());
                        CardLayout cl = (CardLayout) (mainPanel.getLayout());
                        cl.next(mainPanel);
                    }
                }
            }
        }
    }

    private class SecondNextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (Validation.isAddressField(firstAddressField.getText())) {
                if (Validation.isAddressField(cityField.getText())) {
                    if (Validation.isAddressField(countyField.getText())) {
                        if (Validation.isAddressField(postcodeField.getText())) {
                            if (Validation.isEmailField(emailField.getText())) {
                                if (Validation.isPhoneNumberField(daytimePhoneField.getText())) {
                                    if (Validation.isPhoneNumberField(eveningPhoneField.getText())) {
                                        if (Validation.isPhoneNumberField(mobilePhoneField.getText())) {
                                            addressOne = firstAddressField.getText();
                                            addressTwo = secondAddressField.getText();
                                            city = cityField.getText();
                                            county = countyField.getText();
                                            postcode = postcodeField.getText();
                                            emailAddress = emailField.getText();
                                            daytimeNumber = daytimePhoneField.getText();
                                            eveningNumber = eveningPhoneField.getText();
                                            mobileNumber = mobilePhoneField.getText();
                                            CardLayout cl = (CardLayout) (mainPanel.getLayout());
                                            cl.next(mainPanel);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    private class ThirdNextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            gpFristName = gpFirstNameField.getText();
            gpLastName = gpSecondNameField.getText();
            gpAddressOne = gpFirstAddressField.getText();
            gpAddressTwo = gpSecondAddressField.getText();
            gpCity = gpCityField.getText();
            gpCounty = gpCountyField.getText();
            gpPostcode = gpPostcodeField.getText();
            gpNumber = gpPhoneField.getText();
            kinName = kinNameField.getText();
            kinNumber = kinPhoneField.getText();
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.next(mainPanel);
        }
    }

    private class previousButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.previous(mainPanel);
        }
    }

    private class FinishButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
             int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to save this member?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
            
                
                
            cardName = cardNameField.getText();
            cardNumber = cardNumberField.getText();
            securityNumber = securityNumberField.getText();
            validMonthDate = Integer.parseInt((String) validMonthsBox.getSelectedItem());
            validYearDate = Integer.parseInt((String) validDateBox.getSelectedItem());
            expiryMonthDate = Integer.parseInt((String) expiryMonthsBox.getSelectedItem());
            expiryYearDate = Integer.parseInt((String) expiryDateBox.getSelectedItem());
            cardType = (String) cardTypeBox.getSelectedItem();
            Member m = new Member(firstName, middleName, thirdName, age,
            addressOne, addressTwo, city, county, postcode,
            daytimeNumber, eveningNumber,
            mobileNumber, emailAddress, gpFristName, gpLastName,
            gpAddressOne, gpAddressTwo, gpCity,
            gpCounty, gpPostcode,
            gpNumber, kinName, kinNumber, cardName,
            cardNumber, securityNumber, cardType,
            validMonthDate, validYearDate, expiryMonthDate, expiryYearDate);
            
            if(memberList.checkDetails(m)){
            
            memberList.addMember(m);
             dispose();
            }
            else {
                   JOptionPane.showMessageDialog(getFrame(), "ERROR: Person is blacklisted", "Adding Member", 0, null);
            }
            
 
            }
           
                      
        }
    }
}
