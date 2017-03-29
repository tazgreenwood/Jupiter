import javax.swing.*;
import java.awt.*;
import Database.*;
import TextField.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class JupiterDemo extends javax.swing.JFrame {
    public int stdTextBoxWidth = 150;
    public int stdTextBoxHeight = 35;
    public int bgColor = 0;
    public int btnColor = 0;
    public int innerMargins = 5;
    public Database DB;
    private int cBanker_ID = -1;

    public JupiterDemo() {
        initComponents();
        DB = new Database();
        DB.showTable("employees");
        cBanker_ID = 1;
        initAddClient();
    }

    //Makes Window
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>

    //makes the comboBoxObject used in most screens
    public JComboBox makeComboBox(){
        JComboBox jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169,132,99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Account Search", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setMinimumSize(null);
        jComboBox1.setOpaque(true);
        jComboBox1.setPreferredSize(null);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));
        jComboBox1.addActionListener(
            (ActionEvent e) -> {
                if (jComboBox1.getSelectedItem().toString().equals("Sign Out")){
                    initLogin();
                }
                else if (jComboBox1.getSelectedItem().toString().equals("Balance Drawer")){
                    initBalanceDrawer();
                }
                else if (jComboBox1.getSelectedItem().toString().equals("Account Search")){
                    initClientSearch();
                }
                else if (jComboBox1.getSelectedItem().toString().equals("Change Password")){
                    initChangePassword();
                }
                else if (jComboBox1.getSelectedItem().toString().equals("Reverse Transaction")){
                    initReverseTransaction();
                }
            });
        return jComboBox1;
    }

    //draws login page
    public void initLogin(){
        //Removes everything from screen
        clearScreen();

        //initialize positioning object
        GridBagConstraints c = new GridBagConstraints();

        //create inner panel
        JPanel innerPanel = new JPanel(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(650,400));
        innerPanel.setBackground(new Color(125,40,37));
        innerPanel.setBorder(BorderFactory.createLineBorder(new Color(126,79,36)));
        getContentPane().add(innerPanel, c);

        // Add Jupiter Logo
        c.weightx = 5;
        c.weighty = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        logoLabel.setSize(new Dimension(100, 100));
        innerPanel.add(logoLabel, c);

        // Create page title
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        JLabel title = new JLabel("Login");
        title.setFont(new Font("", Font.PLAIN,40));
        innerPanel.add(title, c);

        //create Username Field
        c.gridx = 1;
        c.gridy = 1;
        JTextField username = new JTextField("Username");
        username.setBackground(new Color(173,188,167));
        username.setFont(new Font("", Font.PLAIN,24));
        username.setPreferredSize(new Dimension(300, 50));
        innerPanel.add(username, c);

        //Create Password Field
        c.gridx = 1;
        c.gridy = 2;
        JPasswordField passField =  new JPasswordField();
        passField.setBackground(new Color(173,188,167));
        passField.setFont(new Font("", Font.PLAIN,24));
        passField.setPreferredSize(new Dimension(300, 50));
        innerPanel.add(passField, c);

        //Put Text Boxes on array for Login function
        ArrayList <JTextField> textBoxes = new ArrayList<JTextField>();
        textBoxes.add(username);
        textBoxes.add(passField);

        //Add login button
        c.gridx = 0;
        c.gridy = 3;
        JButton loginButton = new JButton("Login");
        //Function that gets called when clicked
        loginButton.addActionListener(
                (ActionEvent e) -> {bankerLogin(textBoxes);});


        loginButton.setBackground(new Color(24,74,76));
        loginButton.setFont(new Font("", Font.PLAIN,24));
        loginButton.setForeground(new Color(169,132,99));
        loginButton.setPreferredSize(new Dimension(150, 50));
        innerPanel.add(loginButton, c);

        //Add new employee button
        c.gridx = 2;
        c.gridy = 3;
        JButton newUserButton = new JButton("New User");
        newUserButton.setBackground(new Color(24,74,76));
        newUserButton.setFont(new Font("", Font.PLAIN,24));
        newUserButton.setForeground(new Color(169,132,99));
        newUserButton.setPreferredSize(new Dimension(150, 50));
        newUserButton.addActionListener(
                (ActionEvent e) -> {initAddBanker();});
        innerPanel.add(newUserButton, c);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        //draw everything
        pack();
    }

    //CHECKs IF TEXT BOXES ARE FILLED
    public boolean checkFillTextBoxes(ArrayList<JTextField> textFieldsList){
        for(int i=0; i< textFieldsList.size(); i++)
        {
            if(textFieldsList.get(i).getText().trim().isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    //function called by login button
    public void bankerLogin(ArrayList<JTextField> textFieldsList){
        if (checkFillTextBoxes(textFieldsList))
        {
            //Gets data from text boxes
            String username = textFieldsList.get(0).getText().trim();
            String password = textFieldsList.get(1).getText().trim();
            String query = "Select emp_id FROM employees WHERE emp_user = '"+ username +"' AND password = '"+password+"';";
            String data;
            data = DB.getValue(query ,1);
            //If user_id uis found for usename and password
            if (data != "getValue() Error")
            {
                cBanker_ID = Integer.parseInt(data);
                System.out.println(cBanker_ID);
                //Change screen to
                initClientSearch();
            }
            else
            {
                //If reselut was empty password or username was wrong
                JOptionPane.showMessageDialog(null, "Incorrect username/password","Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Incorrect username/password ");
            }
        }
        else
        {
            //if input boxes where not filled
            System.out.println("Must provide a username/password");
            JOptionPane.showMessageDialog(null, "username and password required","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //draws main menu page
    public void initClientSearch(){
        clearScreen();
        javax.swing.JTextField AccountSearch;
        javax.swing.JPanel BGPanel;
        javax.swing.JComboBox<String> DDMenu;
        javax.swing.JPanel FGPanel;
        javax.swing.JTextField NameSearch;
        javax.swing.JScrollPane SResult;
        javax.swing.JTextField SSNSearch;
        javax.swing.JLabel Symbol;
        javax.swing.JLabel jLabel1;
        javax.swing.JPanel jPanel1;
        javax.swing.JButton searchButton;
        javax.swing.JTextArea searchResults;
        BGPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        DDMenu = makeComboBox();
        FGPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        NameSearch = new javax.swing.JTextField();
        SResult = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JTextArea();
        SSNSearch = new javax.swing.JTextField();
        AccountSearch = new javax.swing.JTextField();
        Symbol = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));

        BGPanel.setBackground(new java.awt.Color(24, 74, 76));
        BGPanel.setPreferredSize(new java.awt.Dimension(1200, 800));
        BGPanel.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));

        //DDMenu.setBackground(new java.awt.Color(125, 40, 37));
        //DDMenu.setForeground(new java.awt.Color(169, 132, 99));
        //DDMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Till", "Reverse Transaction", "Account Settings", "Home", "Logout" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DDMenu, 0, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DDMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        BGPanel.add(jPanel1);
        jPanel1.setBounds(680, 140, 200, 70);

        FGPanel.setBackground(new java.awt.Color(125, 40, 37));
        FGPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 79, 36), 1, true));
        FGPanel.setForeground(new java.awt.Color(173, 188, 167));
        FGPanel.setPreferredSize(new java.awt.Dimension(450, 450));
        FGPanel.setVerifyInputWhenFocusTarget(false);

        searchButton.setBackground(new java.awt.Color(24, 74, 76));
        searchButton.setForeground(new java.awt.Color(173, 188, 167));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initClientProfile();
            }
        });

        NameSearch.setBackground(new java.awt.Color(173, 188, 167));
        NameSearch.setText("Name");
        NameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //NameSearchActionPerformed(evt);
            }
        });

        searchResults.setBackground(new java.awt.Color(173, 188, 167));
        searchResults.setColumns(20);
        searchResults.setRows(5);
        searchResults.setText("Search Results");
        searchResults.setPreferredSize(new java.awt.Dimension(250, 50));
        SResult.setViewportView(searchResults);

        SSNSearch.setBackground(new java.awt.Color(173, 188, 167));
        SSNSearch.setText("SSN");
        SSNSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //SSNSearchActionPerformed(evt);
            }
        });

        AccountSearch.setBackground(new java.awt.Color(173, 188, 167));
        AccountSearch.setText("Account #");

        Symbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Account Search");

        javax.swing.GroupLayout FGPanelLayout = new javax.swing.GroupLayout(FGPanel);
        FGPanel.setLayout(FGPanelLayout);
        FGPanelLayout.setHorizontalGroup(
            FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FGPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SSNSearch)
                    .addComponent(NameSearch)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanelLayout.createSequentialGroup()
                        .addGroup(FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(AccountSearch))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SResult, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(FGPanelLayout.createSequentialGroup()
                .addComponent(Symbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FGPanelLayout.setVerticalGroup(
            FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanelLayout.createSequentialGroup()
                .addGroup(FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanelLayout.createSequentialGroup()
                        .addComponent(Symbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(FGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FGPanelLayout.createSequentialGroup()
                        .addComponent(NameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SSNSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AccountSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SResult, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        BGPanel.add(FGPanel);
        FGPanel.setBounds(330, 200, 550, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //draw a client's screen
    public void initClientProfile(){
         clearScreen();
        javax.swing.JButton AOwnership;
        javax.swing.JRadioButton ATChecking;
        javax.swing.JRadioButton ATLoan;
        javax.swing.JRadioButton ATSavings;
        javax.swing.JButton Aaccount;
        javax.swing.JScrollPane Accounts;
        javax.swing.JTextField City;
        javax.swing.JTextField DoB;
        javax.swing.JButton Eaddress;
        javax.swing.JButton Edob;
        javax.swing.JButton Ename;
        javax.swing.JButton Ephone;
        javax.swing.JButton Essn;
        javax.swing.JTextField Fname;
        javax.swing.JTextField Lname;
        javax.swing.JLabel Logo;
        javax.swing.JTextField Mname;
        javax.swing.JTextField OAccount;
        javax.swing.JLabel PName;
        javax.swing.JTextField Phone;
        javax.swing.JTextField SSN;
        javax.swing.JTextField Saddress;
        javax.swing.JTextField State;
        javax.swing.JTextField Zip;
        javax.swing.JComboBox<String> jComboBox1;
        javax.swing.JList<String> jList1;
        javax.swing.JPanel jPanel1;
        javax.swing.JPanel jPanel2;
        javax.swing.JPanel jPanel3;
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = makeComboBox();
        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        PName = new javax.swing.JLabel();
        Fname = new javax.swing.JTextField();
        Lname = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        Saddress = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Zip = new javax.swing.JTextField();
        State = new javax.swing.JTextField();
        DoB = new javax.swing.JTextField();
        SSN = new javax.swing.JTextField();
        Ename = new javax.swing.JButton();
        Ephone = new javax.swing.JButton();
        Eaddress = new javax.swing.JButton();
        Edob = new javax.swing.JButton();
        Essn = new javax.swing.JButton();
        Accounts = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        ATChecking = new javax.swing.JRadioButton();
        ATSavings = new javax.swing.JRadioButton();
        ATLoan = new javax.swing.JRadioButton();
        Aaccount = new javax.swing.JButton();
        OAccount = new javax.swing.JTextField();
        AOwnership = new javax.swing.JButton();
        Mname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(24, 74, 76));
        jPanel1.setForeground(new java.awt.Color(24, 74, 76));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(125, 40, 37));

        //jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(680, 120, 220, 70);

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 79, 36), 1, true));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png"))); // NOI18N

        PName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        PName.setText("Client Profile");

        Fname.setBackground(new java.awt.Color(173, 188, 167));
        Fname.setText("First Name");

        Lname.setBackground(new java.awt.Color(173, 188, 167));
        Lname.setText("Last");

        Phone.setBackground(new java.awt.Color(173, 188, 167));
        Phone.setText("Phone # (000) 000-0000");

        Saddress.setBackground(new java.awt.Color(173, 188, 167));
        Saddress.setText("Street Address");

        City.setBackground(new java.awt.Color(173, 188, 167));
        City.setText("City");

        Zip.setBackground(new java.awt.Color(173, 188, 167));
        Zip.setText("Zip code");

        State.setBackground(new java.awt.Color(173, 188, 167));
        State.setText("State");

        DoB.setBackground(new java.awt.Color(173, 188, 167));
        DoB.setText("Date of Birth");

        SSN.setBackground(new java.awt.Color(173, 188, 167));
        SSN.setText("SSN#");
        SSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //SSNActionPerformed(evt);
            }
        });

        Ename.setBackground(new java.awt.Color(24, 74, 76));
        Ename.setForeground(new java.awt.Color(173, 188, 167));
        Ename.setText("edit");

        Ephone.setBackground(new java.awt.Color(24, 74, 76));
        Ephone.setForeground(new java.awt.Color(173, 188, 167));
        Ephone.setText("edit");

        Eaddress.setBackground(new java.awt.Color(24, 74, 76));
        Eaddress.setForeground(new java.awt.Color(173, 188, 167));
        Eaddress.setText("edit");
        Eaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //EaddressActionPerformed(evt);
            }
        });

        Edob.setBackground(new java.awt.Color(24, 74, 76));
        Edob.setForeground(new java.awt.Color(173, 188, 167));
        Edob.setText("edit");

        Essn.setBackground(new java.awt.Color(24, 74, 76));
        Essn.setForeground(new java.awt.Color(173, 188, 167));
        Essn.setText("Edit");

        jList1.setBackground(new java.awt.Color(173, 188, 167));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Accounts" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Accounts.setViewportView(jList1);

        ATChecking.setBackground(new java.awt.Color(125, 40, 37));
        ATChecking.setForeground(new java.awt.Color(173, 188, 167));
        ATChecking.setText("Checking");

        ATSavings.setBackground(new java.awt.Color(125, 40, 37));
        ATSavings.setForeground(new java.awt.Color(173, 188, 167));
        ATSavings.setText("Savings");

        ATLoan.setBackground(new java.awt.Color(125, 40, 37));
        ATLoan.setForeground(new java.awt.Color(173, 188, 167));
        ATLoan.setText("Loan");

        Aaccount.setBackground(new java.awt.Color(24, 74, 76));
        Aaccount.setForeground(new java.awt.Color(173, 188, 167));
        Aaccount.setText("Add Account");
        Aaccount.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initAccountProfile();
            }
        });
        OAccount.setBackground(new java.awt.Color(173, 188, 167));
        OAccount.setText("Account #");

        AOwnership.setBackground(new java.awt.Color(24, 74, 76));
        AOwnership.setForeground(new java.awt.Color(173, 188, 167));
        AOwnership.setText("Add Ownership");

        Mname.setBackground(new java.awt.Color(173, 188, 167));
        Mname.setText("MI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Logo)
                .addGap(83, 83, 83)
                .addComponent(PName, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DoB)
                            .addComponent(City)
                            .addComponent(Saddress)
                            .addComponent(Phone)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Zip, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Edob)
                            .addComponent(Eaddress)
                            .addComponent(Ephone)
                            .addComponent(Ename)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(SSN, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Essn)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ATChecking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ATSavings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Aaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ATLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(AOwnership, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Accounts))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logo)
                    .addComponent(PName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Accounts, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ATChecking)
                            .addComponent(Aaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ename, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ephone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Saddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Eaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Zip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Edob, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATSavings)
                    .addComponent(OAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Essn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ATLoan)
                        .addComponent(AOwnership, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SSN))
                .addGap(67, 67, 67))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(240, 170, 660, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //draw an account's screen
    public void initAccountProfile(){
              clearScreen();
        javax.swing.JPanel BGPanel1;
        javax.swing.JPanel FGPanel4;
        javax.swing.JLabel LabelMinBalance3;
        javax.swing.JScrollPane TextboxATransactions3;
        javax.swing.JTextField TextboxCCAmount3;
        javax.swing.JTextField TextboxDCash3;
        javax.swing.JTextField TextboxDCheck3;
        javax.swing.JTextField TextboxTAccountNum3;
        javax.swing.JTextField TextboxTAmount3;
        javax.swing.JTextField TextboxWAmount3;
        javax.swing.JButton btnCheckCash3;
        javax.swing.JButton btnDeposit3;
        javax.swing.JButton btnTransfer3;
        javax.swing.JButton btnWithdrawal3;
        javax.swing.JComboBox<String> jComboBox5;
        javax.swing.JLabel jLabel5;
        javax.swing.JPanel jPanel1;
        javax.swing.JScrollPane jScrollPane7;
        javax.swing.JTextArea jTextArea8;
        javax.swing.JTextArea jTextArea9;
        javax.swing.JTextField jTextField18;
        javax.swing.JTextField jTextField19;
        javax.swing.JTextField jTextField20;
        javax.swing.JTextField jTextField4;
        javax.swing.JLabel labelAccountInfo3;
        javax.swing.JLabel labelAccountOwn3;
        javax.swing.JLabel labelAccountType3;
        javax.swing.JLabel labelAcctTitle3;
        javax.swing.JLabel labelIntRate3;
        javax.swing.JLabel labelOverdraftFee3;
        javax.swing.JLabel labelRTransactions3;
        BGPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox5 = makeComboBox();
        FGPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnWithdrawal3 = new javax.swing.JButton();
        btnDeposit3 = new javax.swing.JButton();
        btnCheckCash3 = new javax.swing.JButton();
        btnTransfer3 = new javax.swing.JButton();
        TextboxDCash3 = new javax.swing.JTextField();
        TextboxWAmount3 = new javax.swing.JTextField();
        TextboxCCAmount3 = new javax.swing.JTextField();
        TextboxTAccountNum3 = new javax.swing.JTextField();
        TextboxDCheck3 = new javax.swing.JTextField();
        TextboxTAmount3 = new javax.swing.JTextField();
        TextboxATransactions3 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        labelAccountInfo3 = new javax.swing.JLabel();
        labelAccountOwn3 = new javax.swing.JLabel();
        labelIntRate3 = new javax.swing.JLabel();
        labelAccountType3 = new javax.swing.JLabel();
        labelOverdraftFee3 = new javax.swing.JLabel();
        LabelMinBalance3 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        labelRTransactions3 = new javax.swing.JLabel();
        labelAcctTitle3 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        BGPanel1.setBackground(new java.awt.Color(24, 74, 76));
        BGPanel1.setForeground(new java.awt.Color(173, 188, 167));
        BGPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        BGPanel1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));

        //jComboBox5.setBackground(new java.awt.Color(125, 40, 37));
        //jComboBox5.setForeground(new java.awt.Color(169, 132, 99));
        //jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Till", "Reverse Transaction", "Account Settings", "Home", "Logout" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BGPanel1.add(jPanel1);
        jPanel1.setBounds(710, 90, 220, 70);

        FGPanel4.setBackground(new java.awt.Color(125, 40, 37));
        FGPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 79, 36), 1, true));
        FGPanel4.setForeground(new java.awt.Color(173, 188, 167));
        FGPanel4.setPreferredSize(new java.awt.Dimension(450, 450));
        FGPanel4.setVerifyInputWhenFocusTarget(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png"))); // NOI18N

        btnWithdrawal3.setBackground(new java.awt.Color(24, 74, 76));
        btnWithdrawal3.setForeground(new java.awt.Color(173, 188, 167));
        btnWithdrawal3.setText("Withdrawal");

        btnDeposit3.setBackground(new java.awt.Color(24, 74, 76));
        btnDeposit3.setForeground(new java.awt.Color(173, 188, 167));
        btnDeposit3.setText("Deposit");

        btnCheckCash3.setBackground(new java.awt.Color(24, 74, 76));
        btnCheckCash3.setForeground(new java.awt.Color(173, 188, 167));
        btnCheckCash3.setText("Cash Check");

        btnTransfer3.setBackground(new java.awt.Color(24, 74, 76));
        btnTransfer3.setForeground(new java.awt.Color(173, 188, 167));
        btnTransfer3.setText("Transfer");

        TextboxDCash3.setText("Cash Amt");
        TextboxDCash3.setBorder(null);
        TextboxDCash3.setBackground(new java.awt.Color(173, 188, 167));
        TextboxDCash3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        TextboxWAmount3.setText("Amount");
        TextboxWAmount3.setBorder(null);
        TextboxWAmount3.setBackground(new java.awt.Color(173, 188, 167));
        TextboxWAmount3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TextboxWAmountActionPerformed(evt);
            }
        });

        TextboxCCAmount3.setText("Amount");
        TextboxCCAmount3.setBackground(new java.awt.Color(173, 188, 167));

        TextboxTAccountNum3.setText("Account #");
        TextboxTAccountNum3.setBackground(new java.awt.Color(173, 188, 167));

        TextboxDCheck3.setText("Check Amt");
        TextboxDCheck3.setBackground(new java.awt.Color(173, 188, 167));
        TextboxDCheck3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        TextboxTAmount3.setText("Amount");
        TextboxTAmount3.setBackground(new java.awt.Color(173, 188, 167));

        jTextArea8.setBackground(new java.awt.Color(173, 188, 167));
        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        TextboxATransactions3.setViewportView(jTextArea8);

        labelAccountInfo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAccountInfo3.setText("Account Info");

        labelAccountOwn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAccountOwn3.setText("Account Owner");

        labelIntRate3.setText("Intrest Rate");

        labelAccountType3.setText("Account Type");
        labelAccountType3.setBackground(new java.awt.Color(173, 188, 167));
        labelAccountType3.setMaximumSize(new java.awt.Dimension(35, 15));
        labelAccountType3.setMinimumSize(new java.awt.Dimension(35, 15));
        labelAccountType3.setName(""); // NOI18N
        labelAccountType3.setPreferredSize(new java.awt.Dimension(35, 15));

        labelOverdraftFee3.setText("Overdaft Fee");

        LabelMinBalance3.setText("Min. Balance");

        jTextField19.setText("jTextField9");
        jTextField19.setBackground(new java.awt.Color(173, 188, 167));

        jTextField20.setText("jTextField9");
        jTextField20.setBackground(new java.awt.Color(173, 188, 167));

        jTextField4.setText("jTextField1");
        jTextField4.setBackground(new java.awt.Color(173, 188, 167));

        labelRTransactions3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelRTransactions3.setText("Recent Transactions");

        labelAcctTitle3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelAcctTitle3.setText("Account (account number) ");

        jTextField18.setText("jTextField9");
        jTextField18.setBackground(new java.awt.Color(173, 188, 167));

        jTextArea9.setBackground(new java.awt.Color(173, 188, 167));
        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane7.setViewportView(jTextArea9);

        javax.swing.GroupLayout FGPanel4Layout = new javax.swing.GroupLayout(FGPanel4);
        FGPanel4.setLayout(FGPanel4Layout);
        FGPanel4Layout.setHorizontalGroup(
            FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FGPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelRTransactions3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(labelAcctTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(115, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanel4Layout.createSequentialGroup()
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeposit3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWithdrawal3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCheckCash3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTransfer3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FGPanel4Layout.createSequentialGroup()
                                .addComponent(TextboxDCash3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextboxDCheck3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextboxWAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FGPanel4Layout.createSequentialGroup()
                                .addComponent(TextboxTAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextboxTAccountNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextboxCCAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAccountInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FGPanel4Layout.createSequentialGroup()
                                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelOverdraftFee3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(LabelMinBalance3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelIntRate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelAccountType3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FGPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(FGPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FGPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextboxATransactions3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(labelAccountOwn3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );
        FGPanel4Layout.setVerticalGroup(
            FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FGPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanel4Layout.createSequentialGroup()
                        .addComponent(labelAcctTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRTransactions3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FGPanel4Layout.createSequentialGroup()
                                .addComponent(btnDeposit3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnWithdrawal3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnCheckCash3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnTransfer3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FGPanel4Layout.createSequentialGroup()
                                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextboxDCash3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextboxDCheck3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(TextboxWAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FGPanel4Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(TextboxTAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FGPanel4Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(TextboxTAccountNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TextboxCCAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextboxATransactions3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(labelAccountOwn3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FGPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelAccountInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelAccountType3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelIntRate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelMinBalance3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FGPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelOverdraftFee3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        BGPanel1.add(FGPanel4);
        FGPanel4.setBounds(160, 150, 770, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BGPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BGPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    //draw teller Balance screen
    public void initBalanceDrawer(){
        clearScreen();
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel jPanel2 = new javax.swing.JPanel();
        JComboBox jComboBox1 = makeComboBox();
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();
        JTextField jTextField6 = new javax.swing.JTextField();
        JLabel jTextField7 = new javax.swing.JLabel();
        JLabel jTextField8 = new javax.swing.JLabel();
        JTextField jTextField9 = new javax.swing.JTextField();
        JTextField jTextField10 = new javax.swing.JTextField();
        JTextField jTextField11 = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField jTextField12 = new javax.swing.JTextField();
        JTextField jTextField13 = new javax.swing.JTextField();
        JTextField jTextField14 = new javax.swing.JTextField();
        JTextField jTextField15 = new javax.swing.JTextField();
        JTextField jTextField16 = new javax.swing.JTextField();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel pennyLabel = new javax.swing.JLabel();
        JLabel nickelLabel = new javax.swing.JLabel();
        JLabel dimeLabel = new javax.swing.JLabel();
        JLabel quarterLabel = new javax.swing.JLabel();
        JLabel halfDollarLabel = new javax.swing.JLabel();
        JLabel dollarCoinLabel = new javax.swing.JLabel();
        JLabel onesLabel = new javax.swing.JLabel();
        JLabel twosLabel = new javax.swing.JLabel();
        JLabel fivesLabel = new javax.swing.JLabel();
        JLabel tensLabel = new javax.swing.JLabel();
        JLabel twentiesLabel = new javax.swing.JLabel();
        JLabel fiftiesLabel = new javax.swing.JLabel();
        JLabel hundredsLabel = new javax.swing.JLabel();
        JLabel miscLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, 0, 220, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, -8, 41);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 79, 36), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        // JUPITER LOGO
        jLabel1 = new JLabel(new ImageIcon(getClass().getResource("logo2.png")));

        // SCREEN TITLE
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Balance Drawer");

        // COINS SUB TITLE
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Coins:");

        // PENNY LABEL
        pennyLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        pennyLabel.setText("Pennies");

        // PENNIES TEXT BOX
        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("Pennies");

        // QUARTER LABEL
        quarterLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        quarterLabel.setText("Quarters");

        // QUARTER TEXT BOX
        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Quarters");

        // NICKEL LABEL
        nickelLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        nickelLabel.setText("Nickels");

        // NICKEL TEXT BOX
        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField3.setText("Nickels");

        // HALF DOLLAR LABEL
        halfDollarLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        halfDollarLabel.setText("Half Dollars");

        // HALF DOLLAR TEXT BOX
        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField4.setText("Half Dollars");

        // DIME LABEL
        dimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        dimeLabel.setText("Dimes");

        // DIME TEXT BOX
        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField5.setText("Dimes");

        // DOLLAR COIN LABEL
        dollarCoinLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        dollarCoinLabel.setText("Dollar Coins");

        // DOLLAR COIN TEXT BOX
        jTextField6.setBackground(new java.awt.Color(173, 188, 167));
        jTextField6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField6.setText("Dollar Coins");

        // NECESSARY DRAWER AMOUNT TEXT
        jTextField7.setBackground(new java.awt.Color(173, 188, 167));
        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField7.setText("Necessary Drawer Amount");

        // ACTUAL DRAWER AMOUNT TEXT
        jTextField8.setBackground(new java.awt.Color(173, 188, 167));
        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField8.setText("Actual Drawer Amount");

        // ONES LABEL
        onesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        onesLabel.setText("Ones");

        // ONES TEXT BOX
        jTextField9.setBackground(new java.awt.Color(173, 188, 167));
        jTextField9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField9.setText("Ones");

        // TWENTIES LABEL
        twentiesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        twentiesLabel.setText("Twenties");

        // TWENTIES TEXT BOX
        jTextField10.setBackground(new java.awt.Color(173, 188, 167));
        jTextField10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField10.setText("Twenties");

        // TWOS LABEL
        twosLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        twosLabel.setText("Twos");

        // TWOS TEXT BOX
        jTextField11.setBackground(new java.awt.Color(173, 188, 167));
        jTextField11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField11.setText("Twos");

        // BILLS SUB TITLE
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel4.setText("Bills:");

        // FIFTIES LABEL
        fiftiesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        fiftiesLabel.setText("Fifties");

        // FIFTIES TEXT BOX
        jTextField12.setBackground(new java.awt.Color(173, 188, 167));
        jTextField12.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField12.setText("Fifties");

        // FIVES LABEL
        fivesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        fivesLabel.setText("Fives");

        // FIVES TEXT BOX
        jTextField13.setBackground(new java.awt.Color(173, 188, 167));
        jTextField13.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField13.setText("Fives");

        // HUNDREDS LABEL
        hundredsLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        hundredsLabel.setText("Hundreds");

        // HUNDREDS TEXT BOX
        jTextField14.setBackground(new java.awt.Color(173, 188, 167));
        jTextField14.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField14.setText("Hundreds");

        // TENS LABEL
        tensLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        tensLabel.setText("Tens");

        // TENS TEXT BOX
        jTextField15.setBackground(new java.awt.Color(173, 188, 167));
        jTextField15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField15.setText("Tens");

        // MISCELLANEOUS LABEL
        miscLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        miscLabel.setText("Misc.");

        // MISCELLANEOUS TEXT BOX
        jTextField16.setBackground(new java.awt.Color(173, 188, 167));
        jTextField16.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField16.setText("Misc.");

        // BALANCED LABEL
        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Balanced:");

        // BALANCED CONFIRMATION TEXT
        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Balanced");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pennyLabel)
                                .addComponent(nickelLabel)
                                .addComponent(dimeLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(quarterLabel)
                                            .addComponent(halfDollarLabel)
                                            .addComponent(dollarCoinLabel)
                                            .addComponent(jTextField4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))))
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(onesLabel)
                                .addComponent(twosLabel)
                                .addComponent(fivesLabel)
                                .addComponent(tensLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))

                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(twentiesLabel)
                                .addComponent(fiftiesLabel)
                                .addComponent(hundredsLabel)
                                .addComponent(miscLabel))
                            ))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField9)
                    .addComponent(jTextField10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pennyLabel)
                    .addComponent(quarterLabel)
                    .addComponent(onesLabel)
                    .addComponent(twentiesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nickelLabel)
                    .addComponent(halfDollarLabel)
                    .addComponent(twosLabel)
                    .addComponent(fiftiesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dimeLabel)
                    .addComponent(dollarCoinLabel)
                    .addComponent(fivesLabel)
                    .addComponent(hundredsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField16))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tensLabel)
                    .addComponent(miscLabel))
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -98;
        gridBagConstraints.ipady = -73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 41, 0, 41);
        getContentPane().add(jPanel1, gridBagConstraints);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        pack();
    }

    //draw change Pass screen
    public void initChangePassword(){
        clearScreen();
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel jPanel2 = new javax.swing.JPanel();
        JComboBox jComboBox1 = makeComboBox();
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JButton jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(
                (ActionEvent e) -> {
                    ArrayList <JTextField> textBoxes = new ArrayList<JTextField>();
                    textBoxes.add(jTextField1); //current pass
                    textBoxes.add(jTextField2); //new pass
                    textBoxes.add(jTextField3); //new passconf
                    changePassword(textBoxes);
                });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, 0, 220, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, -8, 41);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 79, 36), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1 = new JLabel(new ImageIcon(getClass().getResource("logo.png")));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Change Password");

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField1.setText("Current Password");
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 40));
        jTextField1.setSize(new java.awt.Dimension(200, 40));

        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField2.setText("New Password");

        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField3.setText("Verify New Password");

        jButton1.setBackground(new java.awt.Color(24, 74, 76));
        jButton1.setForeground(new java.awt.Color(169,132,99));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton1.setLabel("Apply Changes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -98;
        gridBagConstraints.ipady = -73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 41, 0, 41);
        getContentPane().add(jPanel1, gridBagConstraints);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        //draw everything
        pack();
    }

    //function called by change password button
    public void changePassword(ArrayList<JTextField> textFieldsList){
        if (checkFillTextBoxes(textFieldsList))
        {
            //Gets data from text boxes
            String oldPass = textFieldsList.get(0).getText().trim();
            String newPass = textFieldsList.get(1).getText().trim();
            String newPassConf = textFieldsList.get(2).getText().trim();
            if(! newPass.equals(newPassConf)){
                JOptionPane.showMessageDialog(null, "Passwords Don't Match","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "select password from employees where emp_id="+ cBanker_ID +"";
            String data = DB.getValue(query ,1);
            if(!data.equals(oldPass)){
                JOptionPane.showMessageDialog(null, "Old Password Doesn't Match","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            query = "update employees set password ='"+newPass+"' where emp_id="+cBanker_ID+"";
            boolean noProb = DB.execute(query);
            if(noProb == false){
                JOptionPane.showMessageDialog(null, "Error Updating Password","Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, " Password changed successfully","Success!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

   //draw Reverse Transaction screen
    public void initReverseTransaction(){
        clearScreen();
        javax.swing.JTextField ASearchText;
        javax.swing.JPanel BGpanel;
        javax.swing.JPanel FGpanel;
        javax.swing.JButton RTransactionBtn;
        javax.swing.JScrollPane SearchResults;
        javax.swing.JButton Searchbtn;
        javax.swing.JPanel Tab;
        javax.swing.JLabel Title;
        javax.swing.JCheckBox VerificationCheck;
        javax.swing.JComboBox<String> jComboBox1;
        javax.swing.JTable jTable1;
        javax.swing.JLabel logo;
        BGpanel = new javax.swing.JPanel();
        Tab = new javax.swing.JPanel();
        jComboBox1 = makeComboBox();
        FGpanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        ASearchText = new javax.swing.JTextField();
        Searchbtn = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        SearchResults = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RTransactionBtn = new javax.swing.JButton();
        VerificationCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        BGpanel.setBackground(new java.awt.Color(24, 74, 76));
        BGpanel.setLayout(null);

        Tab.setBackground(new java.awt.Color(125, 40, 37));

        javax.swing.GroupLayout TabLayout = new javax.swing.GroupLayout(Tab);
        Tab.setLayout(TabLayout);
        TabLayout.setHorizontalGroup(
            TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabLayout.setVerticalGroup(
            TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        BGpanel.add(Tab);
        Tab.setBounds(740, 110, 220, 70);

        FGpanel.setBackground(new java.awt.Color(125, 40, 37));
        FGpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 79, 36), 1, true));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png"))); // NOI18N

        ASearchText.setBackground(new java.awt.Color(173, 188, 167));
        ASearchText.setText("Account #");

        Searchbtn.setBackground(new java.awt.Color(24, 74, 76));
        Searchbtn.setForeground(new java.awt.Color(173, 188, 167));
        Searchbtn.setText("Search");

        Title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Title.setText("Reverse Transaction");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(173, 188, 167));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Account", "Type of Transaction", "Date", "Ammount", "Ending Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SearchResults.setViewportView(jTable1);

        RTransactionBtn.setBackground(new java.awt.Color(24, 74, 76));
        RTransactionBtn.setForeground(new java.awt.Color(173, 188, 167));
        RTransactionBtn.setText("Reverse Selected");

        VerificationCheck.setBackground(new java.awt.Color(125, 40, 37));
        VerificationCheck.setForeground(new java.awt.Color(173, 188, 167));
        VerificationCheck.setText("Are you Sure?");

        javax.swing.GroupLayout FGpanelLayout = new javax.swing.GroupLayout(FGpanel);
        FGpanel.setLayout(FGpanelLayout);
        FGpanelLayout.setHorizontalGroup(
            FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FGpanelLayout.createSequentialGroup()
                .addGroup(FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FGpanelLayout.createSequentialGroup()
                        .addGroup(FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo)
                            .addGroup(FGpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ASearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FGpanelLayout.createSequentialGroup()
                                .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                            .addGroup(FGpanelLayout.createSequentialGroup()
                                .addComponent(Title)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(VerificationCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        FGpanelLayout.setVerticalGroup(
            FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FGpanelLayout.createSequentialGroup()
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FGpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(SearchResults, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FGpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerificationCheck))
                .addGap(98, 98, 98))
        );

        BGpanel.add(FGpanel);
        FGpanel.setBounds(180, 160, 780, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BGpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //draw add banker screen
    public void initAddBanker(){
        clearScreen();
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel jPanel2 = new javax.swing.JPanel();
        JPanel jPanel1 = new javax.swing.JPanel();
        JButton jButton2 = new javax.swing.JButton();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2, 0, 220, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, -8, 41);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 79, 36), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1 = new JLabel(new ImageIcon(getClass().getResource("logo2.png")));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Add New Banker");

        jButton1.setBackground(new java.awt.Color(24, 74, 76));
        jButton1.setForeground(new java.awt.Color(169,132,99));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(
                (ActionEvent e) -> {
                    ArrayList <JTextField> textBoxes = new ArrayList<JTextField>();
                    textBoxes.add(jTextField1); //fname
                    textBoxes.add(jTextField2); //lname
                    textBoxes.add(jTextField3); //username
                    textBoxes.add(jTextField4); //pass
                    textBoxes.add(jTextField5); //pass conf
                    createBanker(textBoxes);
                });

        jButton2.setBackground(new java.awt.Color(24, 74, 76));
        jButton2.setForeground(new java.awt.Color(169,132,99));
        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(
                (ActionEvent e) -> {initLogin();});

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Banker Info:");

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("First Name");

        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Last Name");

        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField3.setText("User Name");

        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField4.setText("New Password");

        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField5.setText("Verify New Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -98;
        gridBagConstraints.ipady = -73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 41, 0, 41);
        getContentPane().add(jPanel1, gridBagConstraints);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        pack();
    }

    //function called by add banker button
    public void createBanker(ArrayList<JTextField> textFieldsList){
        if (checkFillTextBoxes(textFieldsList))
        {
            //Gets data from text boxes
            String fname = textFieldsList.get(0).getText().trim();
            String lname = textFieldsList.get(1).getText().trim();
            String username = textFieldsList.get(2).getText().trim();
            String pass = textFieldsList.get(3).getText().trim();
            String passconf = textFieldsList.get(4).getText().trim();
            if(! pass.equals(passconf)){
                JOptionPane.showMessageDialog(null, "Passwords Don't Match","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String query = "select max(emp_id) from employees";
            int data = Integer.parseInt(DB.getValue(query ,1));
            query = "insert into employees values ("+ (data+1) +",'"+ fname +"', '"+lname+"','"+username+"','"+pass+"',NULL);";
            boolean noProb = DB.execute(query);
            if(noProb == false){
                JOptionPane.showMessageDialog(null, "Error Creating New Employee, make sure username doesn't already exist.","Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, username+" added successfully","Success!", JOptionPane.INFORMATION_MESSAGE);
                ArrayList <JTextField> textBoxes = new ArrayList<JTextField>();
                textBoxes.add(textFieldsList.get(2)); //fname
                textBoxes.add(textFieldsList.get(3)); //lname
                bankerLogin(textBoxes);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

     //draw add client screen
    public void initAddClient(){
        clearScreen();
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel jPanel2 = new javax.swing.JPanel();
        JComboBox jComboBox1 = makeComboBox();
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel3 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();
        JTextField jTextField6 = new javax.swing.JTextField();
        JTextField jTextField7 = new javax.swing.JTextField();
        JTextField jTextField8 = new javax.swing.JTextField();
        JTextField jTextField9 = new javax.swing.JTextField();
        JTextField jTextField10 = new javax.swing.JTextField();
        JTextField jTextField11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, 0, 220, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, -8, 41);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(125, 40, 37));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 79, 36), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1 = new JLabel(new ImageIcon(getClass().getResource("logo2.png")));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Add New Client");

        jButton1.setBackground(new java.awt.Color(24, 74, 76));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(169, 132, 99));
        jButton1.setText("Save");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Client Info:");

        //TEXT FIELDS
        //First Name
        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("First Name");

        //Last Name
        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Last Name");

        //Phone 1
        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setDocument(new JTextFieldLimit(3));//Stes limit to 3 chars
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        //Phone 2
        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setDocument(new JTextFieldLimit(3));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        //Phone 3
        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setDocument(new JTextFieldLimit(4));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        //Street
        jTextField6.setBackground(new java.awt.Color(173, 188, 167));
        jTextField6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField6.setText("Street");

        //City
        jTextField7.setBackground(new java.awt.Color(173, 188, 167));
        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField7.setText("City");

        //State
        jTextField8.setBackground(new java.awt.Color(173, 188, 167));
        jTextField8.setDocument(new JTextFieldLimit(2));
        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField8.setText("ST");

        //ZIP
        jTextField9.setBackground(new java.awt.Color(173, 188, 167));
        jTextField9.setDocument(new JTextFieldLimit(5));
        jTextField9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField9.setText("Zip");

        //Birthdate
        jTextField10.setBackground(new java.awt.Color(173, 188, 167));
        jTextField10.setDocument(new JTextFieldLimit(10));
        jTextField10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField10.setText("Birthdate");

        jTextField11.setBackground(new java.awt.Color(173, 188, 167));
        jTextField11.setDocument(new JTextFieldLimit(9));
        jTextField11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField11.setText("SSN");

        //Put Text Boxes on array for Create Client function
        ArrayList <JTextField> textBoxes = new ArrayList<JTextField>();
        textBoxes.add(jTextField1);
        textBoxes.add(jTextField2);
        textBoxes.add(jTextField3);
        textBoxes.add(jTextField4);
        textBoxes.add(jTextField5);
        textBoxes.add(jTextField6);
        textBoxes.add(jTextField7);
        textBoxes.add(jTextField8);
        textBoxes.add(jTextField9);
        textBoxes.add(jTextField10);
        textBoxes.add(jTextField11);

        //Function that gets called when save button is clicked
        jButton1.addActionListener(
                (ActionEvent e) -> {createClient(textBoxes);});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField5))
                                .addComponent(jTextField6)
                                .addComponent(jTextField7)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField11)))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel2)))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jTextField10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -98;
        gridBagConstraints.ipady = -73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 41, 0, 41);
        getContentPane().add(jPanel1, gridBagConstraints);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        pack();
    }

    //CREATE CLIENT FUNCTION
    public void createClient(ArrayList<JTextField> textFieldsList)
    {
        //Proceed if boxes are filled with valid info
        if (validateClientInfo(textFieldsList))
        {
            //Gets data from text boxes
            String fname = textFieldsList.get(0).getText().trim();
            String lname = textFieldsList.get(1).getText().trim();
            String phone = textFieldsList.get(2).getText().trim()+ textFieldsList.get(3).getText().trim() + textFieldsList.get(4).getText().trim();
            String address = textFieldsList.get(5).getText().trim();
            String city = textFieldsList.get(6).getText().trim();
            String state = textFieldsList.get(7).getText().trim();
            String zip = textFieldsList.get(8).getText().trim();
            String bd = textFieldsList.get(9).getText().trim();
            String ssn = textFieldsList.get(10).getText().trim();
            String query = "INSERT INTO  clients (fname, lname, ssn, birthday, address, city, state, zipcode, phone_number)" +
                    " VALUES ('"+ fname +"', '" + lname +"', '" + ssn +"', '" + bd +"', '" + address +"', '" + city +
                    "', '" + state + "', '" + zip+ "', '" + phone+"');";
            boolean Success;
            Success = DB.execute(query);
            //If user_id uis found for usename and password
            if (Success)
            {
                //If reselut was empty password or username was wrong
                JOptionPane.showMessageDialog(null, "Client created","Success!", JOptionPane.PLAIN_MESSAGE);
                System.out.println("Client created");
            }
            else
            {
                //If reselut was empty password or username was wrong
                JOptionPane.showMessageDialog(null, "Client not created","Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Client not created");
            }
        }
    }

    //Validate client info from form, returns false if input is wrong
    public boolean validateClientInfo(ArrayList<JTextField> textFieldsList){
        String Field;
        int Phone1 = 3;
        int Phone2 = 3;
        int Phone3 = 4;
        int State = 2;
        int Zip = 5;
        int BD = 10;
        int SSN = 9;
        boolean PhoneSuccess = true;
        for(int i=0; i< textFieldsList.size(); i++)
        {
            switch (i) {
            case 0: //First Name
                if (textFieldsList.get(i).getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Must provide first name","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                    break;

            case 1: //Last Name
                if (textFieldsList.get(i).getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Must provide last name","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                    break;

            case 2: //Phone1
                Field = textFieldsList.get(i).getText().trim();
                //fail if field contains letters or it doesn't have the correct ammount of digits
                if (Field.length()<Phone1 || !onlyDigits(Field)){
                    PhoneSuccess = false;
                }
                    break;

            case 3:  //Phone2
                Field = textFieldsList.get(i).getText().trim();
                if (Field.length()<Phone2 || !onlyDigits(Field)){
                    PhoneSuccess = false;
                }
                     break;

            case 4:  //Phone3
                Field = textFieldsList.get(i).getText().trim();
                if (Field.length()<Phone3 || !onlyDigits(Field)){
                    PhoneSuccess = false;
                }
                if(!PhoneSuccess){
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number \nMust only contain numbers","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                    break;

            case 5: //Address
                if (textFieldsList.get(i).getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Must provide an address","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                    break;

            case 6: //City
                if (textFieldsList.get(i).getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Must provide a city","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                    break;
            case 7: //State
                Field = textFieldsList.get(i).getText().trim();
                if (Field.length()<State){
                    JOptionPane.showMessageDialog(null, "Invalid State \nEX: UT","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                     break;
            case 8: //Zip
                Field = textFieldsList.get(i).getText().trim();
                if (Field.length()<Zip || !onlyDigits(Field)){
                    JOptionPane.showMessageDialog(null, "Invalid Zip Code\nMust only contain numbers","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                     break;
            case 9: //BirthDate
                Field = textFieldsList.get(i).getText().trim();
                // Faild if not enough input chars or invalid date format
                if (Field.length()<BD || !checkDate(Field)){
                    JOptionPane.showMessageDialog(null, "Invalid Date \nEX: mm/dd/year","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                     break;
            case 10: //SSN
                                Field = textFieldsList.get(i).getText().trim();
                if (Field.length()<SSN || !onlyDigits(Field)){
                    JOptionPane.showMessageDialog(null, "Invalid SSN \nEX: 123456789","Error!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                     break;
            }
        }
        return true;
    }

    //Finds if String only contains digits
    public boolean onlyDigits(String Field){
        for(int i=0; i< Field.length(); i++)
        {
            //Compare ASCII values --  48 to 57 are numbers
            if((int) Field.charAt(i) < 48 || (int) Field.charAt(i) > 57)
            {
                return false;
            }
        }
        return true;
    }

    //Checks if date is in correct format --- returns true if correct, false otherwise
    public boolean checkDate(String Field){
        int dashIndex1 = 2;
        int dashIndex2 = 5;
        int month1stDigitIndex = 0;
        int day1stDigitIndex = 3;
        for(int i=0; i< Field.length(); i++)
        {
            //check if dashes are not right place
            if(i == dashIndex1 || i == dashIndex2)
            {
                if(Field.charAt(i) != '/' || Field.charAt(i) != '/')
                {
                    return false;
                }
            }
            else//check numbers
            {
                //if not numbers
                if(((int) Field.charAt(i) < 48 || (int) Field.charAt(i) > 57))
                {
                    return false;
                }
                else if(i==month1stDigitIndex && (int) Field.charAt(i) > 49) //if month's first digit is >1
                {
                    return false;
                }
                else if(i==day1stDigitIndex || (int) Field.charAt(i) <= 51) //if days's first digit is >3
                {
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //clear all objects from the screen so another can be drawn
    public void clearScreen(){
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    //Don't Touch
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JupiterDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JupiterDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JupiterDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JupiterDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JupiterDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    // End of variables declaration
}
