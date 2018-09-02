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
 *Modification of the Staff JFrame. Setting the positioning of text fields and buttons and modifying staff account details.
 * @author Harry Clewlow, Leigh Lawley
 */
public class ModifyStaffFrame extends JFrame {

    StaffDatabase staffs;
    JList staffList;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int staffID;
    private boolean isAdmin;
    JTextField staffIDField = new JTextField(25);
    JTextField firstNameField = new JTextField(25), secondNameField = new JTextField(25);
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20), passwordField1 = new JPasswordField(20);
    JCheckBox isAdminBox = new JCheckBox("Is Admin");

    public ModifyStaffFrame(StaffDatabase staffs) {
        super("Staff Account Details");

        this.staffs = staffs;

        setLocation(200, 200);

        JPanel infoPanel = new JPanel();

        staffList = new JList(staffs.getList().toArray());
        staffList.addListSelectionListener(new ListListener());

        JScrollPane listScroller = new JScrollPane(staffList);



        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener());
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener());
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearListener());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());

        infoPanel.add(cancelButton);
        infoPanel.add(saveButton);
        infoPanel.add(clearButton);
        infoPanel.add(deleteButton);

        JTabbedPane tabPanel = new JTabbedPane();
        tabPanel.addTab("Staff Members Account Details", createMemberDetailPanel());

        add(tabPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        add(listScroller, BorderLayout.WEST);

        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createMemberDetailPanel() {
        JPanel fieldPanel = new JPanel(new GridBagLayout());

        JPanel staffIDPanel = new JPanel();
        staffIDPanel.add(staffIDField);
        staffIDPanel.setBorder(new TitledBorder("Staff ID:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        fieldPanel.add(staffIDPanel, c);

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.add(firstNameField);

        firstNamePanel.setBorder(new TitledBorder("First Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;

        fieldPanel.add(firstNamePanel, c);

        JPanel secondNamePanel = new JPanel();
        secondNamePanel.add(secondNameField);

        secondNamePanel.setBorder(new TitledBorder("Last Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0;

        fieldPanel.add(secondNamePanel, c);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameField);

        usernamePanel.setBorder(new TitledBorder("Username:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(usernamePanel, c);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordField);
        passwordPanel.setBorder(new TitledBorder("Password:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 0.0;

        fieldPanel.add(passwordPanel, c);

        JPanel password1Panel = new JPanel();
        password1Panel.add(passwordField1);

        password1Panel.setBorder(new TitledBorder("Confirm Password:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 0;

        fieldPanel.add(password1Panel, c);

        JPanel isAdminPanel = new JPanel();
        isAdminPanel.add(isAdminBox);

        isAdminPanel.setBorder(new TitledBorder("Account Type:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 0.0;

        fieldPanel.add(isAdminPanel, c);


        return fieldPanel;
    }

    private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {

            if (e.getSource() == staffList && !e.getValueIsAdjusting()) {
                int selectedIndex = staffList.getSelectedIndex();

                System.out.println(selectedIndex);

                if (selectedIndex < 0) {
                    repaint();
                } else {
                    Staff s1 = staffs.getList().get(selectedIndex);

                    String s1ID = Integer.toString(s1.getStaffID());

                    staffIDField.setText(s1ID);
                    firstNameField.setText(s1.getFirstName());
                    secondNameField.setText(s1.getLastName());
                    usernameField.setText(s1.getUsername());
                    passwordField.setText(s1.getPassword());
                    passwordField1.setText(s1.getPassword());
                    isAdminBox.setSelected(s1.isIsAdmin());


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
                    "Are you sure you want to save any changes?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {

                int selectedIndex = staffList.getSelectedIndex();

                if (selectedIndex < 0) {
                    //ADD ICON
                    JOptionPane.showMessageDialog(getFrame(), "ERROR: No staff acoount was selected to be Saved", "Saving A Staff Account", 0, null);
                } else {

                    Staff s1 = staffs.getList().get(selectedIndex);


                    s1.setFirstName(firstNameField.getText());
                    s1.setLastName(secondNameField.getText());
          

                    boolean isAdmin1 = Boolean.getBoolean(isAdminBox.getText());

                    s1.setIsAdmin(isAdmin1);

                    
                    
            if (staffs.checkStaffID(Integer.parseInt(staffIDField.getText()))) {
                s1.setStaffID(Integer.parseInt(staffIDField.getText()));
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: The StaffID is already taken", "Creating Staff Account", 0, null);
            }


            if (staffs.checkUsername(usernameField.getText())) {
                s1.setUsername(usernameField.getText());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: The username is already taken", "Creating Staff Account", 0, null);
            }

                    
                    if (passwordField.getText().equals(passwordField1.getText())) {

                        s1.setPassword(passwordField.getText());

                    } else {
                        JOptionPane.showMessageDialog(getFrame(), "ERROR: The username or password is incorrect", "Creating Staff Account", 0, null);
                    }


                    staffList.repaint();
                    getFrame().repaint();
                    staffs.deleteStaff(s1);
                    staffs.addStaff(s1);

                    refreshList();
                }
            }
        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to delete this staff account?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                int selectedIndex = staffList.getSelectedIndex();

                if (selectedIndex < 0) {
                    //ADD ICON
                    JOptionPane.showMessageDialog(getFrame(), "ERROR: No staff was selected to be deleted", "Deleting A Staff Account", 0, null);
                } else {
                    Staff s1 = staffs.getList().get(selectedIndex);

                    staffs.deleteStaff(s1);
                    ClearList_Fields();

                    staffList.setListData(staffs.getList().toArray());
                    getFrame().repaint();
                }
            }
        }
    }

    private void refreshList() {
        int selectedIndex = staffList.getSelectedIndex();


        if (selectedIndex < 0) {
            repaint();
        } else {
            Staff s1 = staffs.getList().get(selectedIndex);

            String s1ID = Integer.toString(s1.getStaffID());

            staffIDField.setText(s1ID);
            firstNameField.setText(s1.getFirstName());
            secondNameField.setText(s1.getLastName());
            usernameField.setText(s1.getUsername());
            passwordField.setText(s1.getPassword());
            passwordField1.setText(s1.getPassword());
            isAdminBox.setSelected(s1.isIsAdmin());


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

        staffIDField.setText("");
        firstNameField.setText("");
        secondNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        passwordField1.setText("");
        isAdminBox.setSelected(false);

        staffList.clearSelection();
        getFrame().repaint();



    }
}
