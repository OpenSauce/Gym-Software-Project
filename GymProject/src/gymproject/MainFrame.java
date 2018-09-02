package gymproject;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The mainframe showing a menu bar to make changes to files, member details,
 * hall selection, sport activity, bookings, management and settings, as well
 * as, the main menu to manage members and booking details.
 *
 * @author Harry Clewlow, Leigh Lawley
 */
public class MainFrame extends JFrame {

    OneDatabaseToRuleThemAll database;
    JLabel label1;
    boolean enlarge;
    boolean isAdmin;
    JLabel hall1Label = new JLabel("Hall 1");
    JLabel hall2Label = new JLabel("Hall 2");
    JLabel hall1Zone1Label = new JLabel("Zone 1");
    JLabel hall1Zone2Label = new JLabel("Zone 2");
    JLabel hall1Zone3Label = new JLabel("Zone 3");
    JLabel hall1Zone4Label = new JLabel("Zone 4");
    JLabel hall2Zone1Label = new JLabel("Zone 1");
    JLabel hall2Zone2Label = new JLabel("Zone 2");
    JLabel hall2Zone3Label = new JLabel("Zone 3");
    JLabel hall2Zone4Label = new JLabel("Zone 4");
    JList hall1Zone1List = new JList();
    JList hall1Zone2List = new JList();
    JList hall1Zone3List = new JList();
    JList hall1Zone4List = new JList();
    JList hall2Zone1List = new JList();
    JList hall2Zone2List = new JList();
    JList hall2Zone3List = new JList();
    JList hall2Zone4List = new JList();
     JScrollPane listScroller;
        JScrollPane listScroller1 ;
        JScrollPane listScroller2 ;
        JScrollPane listScroller3 ;
        
        JScrollPane listScroller4 ;
        JScrollPane listScroller5 ;
        JScrollPane listScroller6 ;
        JScrollPane listScroller7;
    JMenuBar menuBar;
    Font d;
    JMenu fileMenu, memberMenu, bookingsMenu, managementMenu, settingsMenu, helpMenu;
    JMenuItem createDBItem, magItem, loadDBItem, saveDBItem, quitItem, addMemberItem, deleteMemberItem,
            modifyMemberItem, ViewMemberItem, createBookingItem, modifyBookingItem, deleteBookingItem, viewBookingItem;
    JMenuItem addAccount, deleteAccount, modifyAccount, searchAccount, blacklistMenu, occupencyReportItem;

    /**
     * Method to create the main frame which includes the menu bar and
     * positioning of JButtons and JPanels.
     */
    public MainFrame(OneDatabaseToRuleThemAll d1, boolean s, boolean enlarge) {
        super("Gym Booking Program");

        database = d1;
        this.enlarge = enlarge;
        this.isAdmin = s;

        d = UIManager.getDefaults().getFont("Frame.font");

        hall1Zone1List.setListData(d1.hallList.getHall1().z1.getBookingList().toArray());
        hall1Zone2List.setListData(d1.hallList.getHall1().z2.getBookingList().toArray());
        hall1Zone3List.setListData(d1.hallList.getHall1().z3.getBookingList().toArray());
        hall1Zone4List.setListData(d1.hallList.getHall1().z4.getBookingList().toArray());
        hall2Zone1List.setListData(d1.hallList.getHall2().z1.getBookingList().toArray());
        hall2Zone2List.setListData(d1.hallList.getHall2().z2.getBookingList().toArray());
        hall2Zone3List.setListData(d1.hallList.getHall2().z3.getBookingList().toArray());
        hall2Zone4List.setListData(d1.hallList.getHall2().z4.getBookingList().toArray());

         listScroller = new JScrollPane(hall1Zone1List);
         listScroller1 = new JScrollPane(hall1Zone2List);
         listScroller2 = new JScrollPane(hall1Zone3List);
         listScroller3 = new JScrollPane(hall1Zone4List);
        
         listScroller4 = new JScrollPane(hall2Zone1List);
         listScroller5 = new JScrollPane(hall2Zone2List);
         listScroller6 = new JScrollPane(hall2Zone3List);
         listScroller7 = new JScrollPane(hall2Zone4List);
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        memberMenu = new JMenu("Members");
        bookingsMenu = new JMenu("Bookings");
        managementMenu = new JMenu("Management");
        settingsMenu = new JMenu("Settings");
        helpMenu = new JMenu("Help");

        createDBItem = new JMenuItem("New Database", new ImageIcon("resources/images/menu_icons/file_menu/database_add.PNG"));
        magItem = new JMenuItem("Toggle Magnification", new ImageIcon("resources/images/menu_icons/disabled_user_menu/magnifier-left.PNG"));
        settingsMenu.add(magItem);
        magItem.addActionListener(new magMenuListener());
        createDBItem.setMnemonic(KeyEvent.VK_N);

        createDBItem.setMnemonic(KeyEvent.VK_N);
        loadDBItem = new JMenuItem("Load Database", new ImageIcon("resources/images/menu_icons/file_menu/database_refresh.PNG"));
        loadDBItem.setMnemonic(KeyEvent.VK_L);
        saveDBItem = new JMenuItem("Save Database", new ImageIcon("resources/images/menu_icons/file_menu/database_save.PNG"));
        loadDBItem.setMnemonic(KeyEvent.VK_L);
        quitItem = new JMenuItem("Exit", new ImageIcon("resources/images/menu_icons/file_menu/program_quit.PNG"));
        quitItem.setMnemonic(KeyEvent.VK_Q);

        addMemberItem = new JMenuItem("Add Members", new ImageIcon("resources/images/menu_icons/member_menu/user--plus.PNG"));
        deleteMemberItem = new JMenuItem("Delete Members", new ImageIcon("resources/images/menu_icons/member_menu/user--minus.PNG"));
        modifyMemberItem = new JMenuItem("Modify Members", new ImageIcon("resources/images/menu_icons/member_menu/user--pencil.PNG"));
        ViewMemberItem = new JMenuItem("View Members", new ImageIcon("resources/images/menu_icons/member_menu/user-share.PNG"));


        createBookingItem = new JMenuItem("Add Session", new ImageIcon("resources/images/menu_icons/booking_menu/book--plus.PNG"));
        modifyBookingItem = new JMenuItem("Modify Sessions", new ImageIcon("resources/images/menu_icons/booking_menu/book--pencil.PNG"));
        deleteBookingItem = new JMenuItem("Delete Session", new ImageIcon("resources/images/menu_icons/booking_menu/book--minus.PNG"));
        viewBookingItem = new JMenuItem("View Session", new ImageIcon("resources/images/menu_icons/booking_menu/book--arrow.PNG"));

        addAccount = new JMenuItem("Add Account", new ImageIcon("resources/images/menu_icons/account_menu/lock--plus.PNG"));
        addAccount.addActionListener(new AddStaffListener());

        deleteAccount = new JMenuItem("Delete Account", new ImageIcon("resources/images/menu_icons/account_menu/lock--minus.PNG"));
        deleteAccount.addActionListener(new ModifyStaffListener());

        modifyAccount = new JMenuItem("Modify Account", new ImageIcon("resources/images/menu_icons/account_menu/lock--pencil.PNG"));
        modifyAccount.addActionListener(new ModifyStaffListener());

        searchAccount = new JMenuItem("View Account", new ImageIcon("resources/images/menu_icons/account_menu/lock--arrow.PNG"));
        searchAccount.addActionListener(new ModifyStaffListener());

        blacklistMenu = new JMenuItem("BlackListed Members", new ImageIcon("resources/images/menu_icons/blacklisted_menu/user-silhouette.PNG"));
        blacklistMenu.addActionListener(new viewBlackListedistener());


        occupencyReportItem = new JMenuItem("Occupancy Report", new ImageIcon("resources/images/menu_icons/reports_menu/reports.PNG"));
        occupencyReportItem.addActionListener(new viewReportListener());

        fileMenu.add(createDBItem);
        fileMenu.addSeparator();
        fileMenu.add(loadDBItem);
        fileMenu.add(saveDBItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);


        bookingsMenu.add(createBookingItem);
        bookingsMenu.add(deleteBookingItem);
        bookingsMenu.add(modifyBookingItem);
        bookingsMenu.addSeparator();
        bookingsMenu.add(viewBookingItem);


        memberMenu.add(addMemberItem);
        memberMenu.add(deleteMemberItem);
        memberMenu.add(modifyMemberItem);
        memberMenu.addSeparator();
        memberMenu.add(ViewMemberItem);

        managementMenu.add(occupencyReportItem);
        managementMenu.addSeparator();
        managementMenu.add(addAccount);
        managementMenu.add(deleteAccount);
        managementMenu.add(modifyAccount);
        managementMenu.addSeparator();
        managementMenu.add(searchAccount);

        managementMenu.addSeparator();
        managementMenu.add(blacklistMenu);


        menuBar.add(fileMenu);
        menuBar.add(memberMenu);
        menuBar.add(bookingsMenu);
        menuBar.add(managementMenu);
        menuBar.add(settingsMenu);
        menuBar.add(Box.createHorizontalGlue());


        setJMenuBar(menuBar);

        saveDBItem.addActionListener(new saveDBItemItemListener());
        loadDBItem.addActionListener(new loadDBItemItemListener());
        createDBItem.addActionListener(new createDBItemItemListener());
        quitItem.addActionListener(new QuitItemListener());

        createBookingItem.addActionListener(new createBookingListener());
        modifyBookingItem.addActionListener(new modifyBookingListener());
        deleteBookingItem.addActionListener(new modifyBookingListener());
        viewBookingItem.addActionListener(new ViewBookingListener());

        addMemberItem.addActionListener(new AddMemberItemListener());
        deleteMemberItem.addActionListener(new ModifyMemberItemListener());
        modifyMemberItem.addActionListener(new ModifyMemberItemListener());
        ViewMemberItem.addActionListener(new viewMemberItemListener());

        add(middleMenu(), BorderLayout.CENTER);
        add(statusBar(), BorderLayout.PAGE_END);


        magItems();


        getFrame().pack();
        setLocation((int) GymProject.screenWidth / 2 - (this.getWidth() / 2), (int) GymProject.screenHeight / 2 - (this.getHeight() / 2));
        setVisible(true);

    }

    public void magItems() {
        if (enlarge) {

            Font f = new Font("arial", Font.PLAIN, 30);


            fileMenu.setFont(f);
            memberMenu.setFont(f);
            bookingsMenu.setFont(f);
            managementMenu.setFont(f);
            settingsMenu.setFont(f);
            createDBItem.setFont(f);
            saveDBItem.setFont(f);
            loadDBItem.setFont(f);
            addMemberItem.setFont(f);
            quitItem.setFont(f);
            deleteMemberItem.setFont(f);
            modifyMemberItem.setFont(f);
            ViewMemberItem.setFont(f);
            addAccount.setFont(f);
            deleteAccount.setFont(f);
            modifyAccount.setFont(f);
            searchAccount.setFont(f);
            hall1Label.setFont(f);
            hall2Label.setFont(f);
            hall1Zone1Label.setFont(f);;
            hall1Zone2Label.setFont(f);
            hall1Zone3Label.setFont(f);
            hall1Zone4Label.setFont(f);
            hall2Zone1Label.setFont(f);
            hall2Zone2Label.setFont(f);
            hall2Zone3Label.setFont(f);
            hall2Zone4Label.setFont(f);
            hall1Zone1List.setFont(f);
            hall1Zone2List.setFont(f);
            hall1Zone3List.setFont(f);
            hall1Zone4List.setFont(f);
            hall2Zone1List.setFont(f);
            hall2Zone2List.setFont(f);
            hall2Zone3List.setFont(f);
            hall2Zone4List.setFont(f);

  
            enlarge = false;

            getFrame().setExtendedState(getFrame().MAXIMIZED_BOTH);
            getFrame().setLocation(0, 0);
            
            getFrame().setLocation(0,0);
        } else {

            fileMenu.setFont(d);
            memberMenu.setFont(d);
            bookingsMenu.setFont(d);
            managementMenu.setFont(d);
            settingsMenu.setFont(d);
            createDBItem.setFont(d);
            saveDBItem.setFont(d);
            loadDBItem.setFont(d);
            addMemberItem.setFont(d);
            quitItem.setFont(d);
            deleteMemberItem.setFont(d);
            modifyMemberItem.setFont(d);
            ViewMemberItem.setFont(d);
            addAccount.setFont(d);
            deleteAccount.setFont(d);
            modifyAccount.setFont(d);
            searchAccount.setFont(d);
            hall1Label.setFont(d);
            hall2Label.setFont(d);
            hall1Zone1Label.setFont(d);;
            hall1Zone2Label.setFont(d);
            hall1Zone3Label.setFont(d);
            hall1Zone4Label.setFont(d);
            hall2Zone1Label.setFont(d);
            hall2Zone2Label.setFont(d);
            hall2Zone3Label.setFont(d);
            hall2Zone4Label.setFont(d);
            hall1Zone1List.setFont(d);
            hall1Zone2List.setFont(d);
            hall1Zone3List.setFont(d);
            hall1Zone4List.setFont(d);
            hall2Zone1List.setFont(d);
            hall2Zone2List.setFont(d);
            hall2Zone3List.setFont(d);
            hall2Zone4List.setFont(d);

            enlarge = true;

            getFrame().pack();
             

            getFrame().setLocation((int) GymProject.screenWidth / 2 - (getFrame().getWidth() / 2), (int) GymProject.screenHeight / 2 - (getFrame().getHeight() / 2));
        }

    }

    private class magMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {


            magItems();



        }
    }

    public void refresh() {
        hall1Zone1List.setListData(database.hallList.getHall1().z1.getBookingList().toArray());
        hall1Zone2List.setListData(database.hallList.getHall1().z2.getBookingList().toArray());
        hall1Zone3List.setListData(database.hallList.getHall1().z3.getBookingList().toArray());
        hall1Zone4List.setListData(database.hallList.getHall1().z4.getBookingList().toArray());
        hall2Zone1List.setListData(database.hallList.getHall2().z1.getBookingList().toArray());
        hall2Zone2List.setListData(database.hallList.getHall2().z2.getBookingList().toArray());
        hall2Zone3List.setListData(database.hallList.getHall2().z3.getBookingList().toArray());
        hall2Zone4List.setListData(database.hallList.getHall2().z4.getBookingList().toArray());
        repaint();
        getFrame().pack();
                    getFrame().setLocation((int) GymProject.screenWidth / 2 - (getFrame().getWidth() / 2), (int) GymProject.screenHeight / 2 - (getFrame().getHeight() / 2));

    }

    /**
     * Method to return the JFrame
     *
     * @return
     */
    private MainFrame getFrame() {
        return this;
    }

    /**
     * Method to read from file.
     *
     * @param f
     * @return
     */
    private OneDatabaseToRuleThemAll loadDatabase(File f) {
        OneDatabaseToRuleThemAll d = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
            d = (OneDatabaseToRuleThemAll) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return d;
    }

    private class ViewOccipancyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    /**
     * Method to create a confirmation message for exiting the program.
     */
    private class QuitItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to quit?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                System.exit(0);
            }
        }
    }

    /**
     * Method to create a new add member frame.
     */
    private class AddMemberItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new AddMemberFrame(database.getMemberDatabase());
        }
    }

    /**
     * Method to edit the member frame.
     */
    private class ModifyMemberItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ModifyMemberFrame(database.getMemberDatabase());
        }
    }

    private class viewMemberItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ModifyMemberFrame(database.getMemberDatabase());
        }
    }

    /**
     * Method to create new database.
     */
    private class createDBItemItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (isAdmin) {

                database = new OneDatabaseToRuleThemAll();
                final JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Database Files", "dat");
                fc.setFileFilter(filter);
                fc.setCurrentDirectory(new java.io.File("."));
                int returnVal = fc.showSaveDialog(MainFrame.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile();
                        String filePath = file.getPath();
                        if (!filePath.toLowerCase().endsWith(".dat")) {
                            file = new File(filePath + ".dat");
                        }
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(database);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Only admins can access this", "Admin Access Right", 0, null);

            }
            getFrame().refresh();
        }
    }

    /**
     * Method to read a previous database.
     */
    private class loadDBItemItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            final JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Database Files", "dat");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory(new java.io.File("."));
            int returnVal = fc.showOpenDialog(MainFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                database = loadDatabase(fc.getSelectedFile());
            }
            getFrame().refresh();
        }
    }

    /**
     * Method to save database.
     */
    private class saveDBItemItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            final JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Database Files", "dat");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory(new java.io.File("."));
            int returnVal = fc.showSaveDialog(MainFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();
                    String filePath = file.getPath();
                    if (!filePath.toLowerCase().endsWith(".dat")) {
                        file = new File(filePath + ".dat");
                    }
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                    out.writeObject(database);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method to view the JButtons and work with action listeners.
     *
     * @return
     */
    private JPanel middleMenu() {
        JPanel menuPanel = new JPanel(new GridBagLayout());

        JPanel hall1Panel = new JPanel();
        hall1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hall1Panel.add(hall1Label);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;

        menuPanel.add(hall1Label, c);

        JPanel zL1Panel = new JPanel();
        zL1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zL1Panel.add(hall1Zone1Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;

        menuPanel.add(zL1Panel, c);

        JPanel zL2Panel = new JPanel();
        zL2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zL2Panel.add(hall1Zone2Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;

        menuPanel.add(zL2Panel, c);

        JPanel zL3Panel = new JPanel();
        zL3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zL3Panel.add(hall1Zone3Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1;
        menuPanel.add(zL3Panel, c);

        JPanel zL4Panel = new JPanel();
        zL4Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zL4Panel.add(hall1Zone4Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 1;
        menuPanel.add(zL4Panel, c);

        JPanel zLi1Panel = new JPanel(new BorderLayout());
        zLi1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zLi1Panel.add(listScroller, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(zLi1Panel, c);

        JPanel zLi2Panel = new JPanel(new BorderLayout());
        zLi2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zLi2Panel.add(listScroller1, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(zLi2Panel, c);

        JPanel zLi3Panel = new JPanel(new BorderLayout());
        zLi3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zLi3Panel.add(listScroller2, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(zLi3Panel, c);

        JPanel zLi4Panel = new JPanel(new BorderLayout());
        zLi4Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zLi4Panel.add(listScroller3, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(zLi4Panel, c);

        JPanel hall2Panel = new JPanel();
        hall2Panel.add(hall2Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 4;

        menuPanel.add(hall2Panel, c);

        JPanel z1L1Panel = new JPanel();
        z1L1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1L1Panel.add(hall2Zone1Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1;

        menuPanel.add(z1L1Panel, c);

        JPanel z1L2Panel = new JPanel();
        z1L2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1L2Panel.add(hall2Zone2Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 1;

        menuPanel.add(z1L2Panel, c);

        JPanel z1L3Panel = new JPanel();
        z1L3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1L3Panel.add(hall2Zone3Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 4;
        c.weightx = 1;
        menuPanel.add(z1L3Panel, c);

        JPanel z1L4Panel = new JPanel();
        z1L4Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1L4Panel.add(hall2Zone4Label);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 4;
        c.weightx = 1;
        menuPanel.add(z1L4Panel, c);

        JPanel z1Li1Panel = new JPanel(new BorderLayout());
        z1Li1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1Li1Panel.add(listScroller4, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(z1Li1Panel, c);

        JPanel z1Li2Panel = new JPanel(new BorderLayout());
        z1Li2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1Li2Panel.add(listScroller5, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(z1Li2Panel, c);

        JPanel z1Li3Panel = new JPanel(new BorderLayout());
        z1Li3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1Li3Panel.add(listScroller6, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 5;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(z1Li3Panel, c);

        JPanel z1Li4Panel = new JPanel(new BorderLayout());
        z1Li4Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        z1Li4Panel.add(listScroller7, BorderLayout.CENTER);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 5;
        c.weightx = 1;
        c.weighty = 1;
        menuPanel.add(z1Li4Panel, c);

        return menuPanel;
    }

    /**
     * Method to display the date.
     *
     * @return
     */
    private JPanel statusBar() {



        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        getFrame().add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(getFrame().getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));




        return statusPanel;
    }

    private class AddStaffListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {


            if (isAdmin) {

                new AddStaffFrame(database.getStaffDatabase());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Only admins can access this", "Admin Access Right", 0, null);

            }
        }
    }

    private class ModifyStaffListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (isAdmin) {
                new ModifyStaffFrame(database.getStaffDatabase());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Only admins can access this", "Admin Access Right", 0, null);

            }
        }
    }

    private class viewBlackListedistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (isAdmin) {
                new ViewBlacklistedFrame(database.getMemberDatabase());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Only admins can access this", "Admin Access Right", 0, null);

            }
        }
    }

    private class createBookingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new AddBookingFrame(database.getBookingDatabase(), database.getMemberDatabase(), database.getSportDatabase(), database.getHallDatabase(), getFrame());

        }
    }

    private class modifyBookingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ModifyBookingFrame(database.getBookingDatabase(), database.getSportDatabase(), database.getMemberDatabase(), database.getHallDatabase(), getFrame());
        }
    }

    private class ViewBookingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ModifyBookingFrame(database.getBookingDatabase(), database.getSportDatabase(), database.getMemberDatabase(), database.getHallDatabase(), getFrame());
        }
    }

    private class viewReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (isAdmin) {
                new ViewReportsFrame(database.getBookingDatabase(), database.getSportDatabase(), database.getMemberDatabase(), database.getHallDatabase());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: Only admins can access this", "Admin Access Right", 0, null);

            }
        }
    }
}
