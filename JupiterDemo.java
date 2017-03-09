import javax.swing.*;
import java.awt.*;

public class JupiterDemo extends javax.swing.JFrame {
    public int stdTextBoxWidth = 150;
    public int stdTextBoxHeight = 35;
    public int bgColor = 0;
    public int btnColor = 0;
    public int innerMargins = 5;

    public JupiterDemo() {
        // initComponents();
//         initLogin();
//         initChangePassword();
//         initNewBanker();
//         initNewClient();
        initBalanceDrawer();
    }

    //Makes Window
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        setBounds(new java.awt.Rectangle(0, 22, 800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169, 132, 99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setOpaque(true);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));

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

        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        jLabel1.setText("LOGO");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setText("Balance Drawer");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Coins:");

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("Pennies");

        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Quarters");

        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField3.setText("Nickels");

        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField4.setText("Half Dollars");

        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField5.setText("Dimes");

        jTextField6.setBackground(new java.awt.Color(173, 188, 167));
        jTextField6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField6.setText("Dollar Coins");

        jTextField7.setBackground(new java.awt.Color(173, 188, 167));
        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField7.setText("Necessary Drawer Amount");

        jTextField8.setBackground(new java.awt.Color(173, 188, 167));
        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField8.setText("Actual Drawer Amount");

        jTextField9.setBackground(new java.awt.Color(173, 188, 167));
        jTextField9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField9.setText("Ones");

        jTextField10.setBackground(new java.awt.Color(173, 188, 167));
        jTextField10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField10.setText("Twenties");

        jTextField11.setBackground(new java.awt.Color(173, 188, 167));
        jTextField11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField11.setText("Twos");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel4.setText("Bills:");

        jTextField12.setBackground(new java.awt.Color(173, 188, 167));
        jTextField12.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField12.setText("Fifties");

        jTextField13.setBackground(new java.awt.Color(173, 188, 167));
        jTextField13.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField13.setText("Fives");

        jTextField14.setBackground(new java.awt.Color(173, 188, 167));
        jTextField14.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField14.setText("Hundreds");

        jTextField15.setBackground(new java.awt.Color(173, 188, 167));
        jTextField15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField15.setText("Tens");

        jTextField16.setBackground(new java.awt.Color(173, 188, 167));
        jTextField16.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField16.setText("Misc.");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Balanced:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Balanced");

        jButton1.setText("jButton1");

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
                                            .addComponent(jTextField4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))))
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addComponent(jLabel6)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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

        pack();
    }// </editor-fold>

    //draws login page
    public void initLogin(){

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

        //Add login button
        c.gridx = 0;
        c.gridy = 3;
        JButton loginButton = new JButton("Login");
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
        innerPanel.add(newUserButton, c);

        // Set Background Color
        getContentPane().setBackground(new Color(24,74,76));

        //draw everything
        pack();
    }

        //draw change password screen
    public void initChangePassword(){
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        setBounds(new java.awt.Rectangle(0, 22, 800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169,132,99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setMinimumSize(null);
        jComboBox1.setOpaque(true);
        jComboBox1.setPreferredSize(null);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));

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
        jLabel2.setText("Change Password");

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextField1.setText("Current Password");
        jTextField1.setPreferredSize(new java.awt.Dimension(240, 40));

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)))
                .addGap(40, 40, 40)
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

    public void initNewBanker() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        setBounds(new java.awt.Rectangle(0, 22, 800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169, 132, 99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setOpaque(true);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));

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
        jLabel2.setText("Add New Banker");

        jButton1.setBackground(new java.awt.Color(24, 74, 76));
        jButton1.setForeground(new java.awt.Color(169,132,99));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jButton1.setText("Save");

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

    public void initNewClient() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        setBounds(new java.awt.Rectangle(0, 22, 800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169, 132, 99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setOpaque(true);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));

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

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("First Name");

        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Last Name");

        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N

        jTextField6.setBackground(new java.awt.Color(173, 188, 167));
        jTextField6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField6.setText("Street");

        jTextField7.setBackground(new java.awt.Color(173, 188, 167));
        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField7.setText("City");

        jTextField8.setBackground(new java.awt.Color(173, 188, 167));
        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField8.setText("State");

        jTextField9.setBackground(new java.awt.Color(173, 188, 167));
        jTextField9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField9.setText("Zip");

        jTextField10.setBackground(new java.awt.Color(173, 188, 167));
        jTextField10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField10.setText("Birthdate");

        jTextField11.setBackground(new java.awt.Color(173, 188, 167));
        jTextField11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField11.setText("SSN");

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

    //draws main menu page
    public void initMainMenu(){

    //variables
    JTextField cSearch = new JTextField();
    JScrollPane jScrollPane1 = new JScrollPane();
    JButton searchButton = new JButton();
    JTextArea searchResults = new JTextArea();
    JButton telButton = new JButton();

        //Client Search bar
        cSearch = new JTextField();
        cSearch.setText("Client Search");
        cSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //when butttn is pressed
           }
        });

        //Search Button
        searchButton = new JButton();
        searchButton.setText("Search");


        //Teller Options Button
        telButton = new javax.swing.JButton();
        telButton.setText("Teller Options");


        //Search Results Field
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JTextArea();
        searchResults.setColumns(20);
        searchResults.setRows(5);
        searchResults.setText("Search Results");
        jScrollPane1.setViewportView(searchResults);

        //Set and initilize main menu jframe
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telButton, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(cSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 651, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(telButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    public void initBalanceDrawer() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 74, 76));
        setBounds(new java.awt.Rectangle(0, 22, 800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(125, 40, 37));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox1.setBackground(new java.awt.Color(125, 40, 37));
        jComboBox1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(169, 132, 99));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teller Options", "Balance Drawer", "Reverse Transaction", "Change Password", "Sign Out" }));
        jComboBox1.setOpaque(true);
        jComboBox1.setSize(new java.awt.Dimension(288, 50));

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
        jLabel2.setText("Balance Drawer");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Coins:");

        jTextField1.setBackground(new java.awt.Color(173, 188, 167));
        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.setText("Pennies");

        jTextField2.setBackground(new java.awt.Color(173, 188, 167));
        jTextField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField2.setText("Quarters");

        jTextField3.setBackground(new java.awt.Color(173, 188, 167));
        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField3.setText("Nickels");

        jTextField4.setBackground(new java.awt.Color(173, 188, 167));
        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField4.setText("Half Dollars");

        jTextField5.setBackground(new java.awt.Color(173, 188, 167));
        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField5.setText("Dimes");

        jTextField6.setBackground(new java.awt.Color(173, 188, 167));
        jTextField6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField6.setText("Dollar Coins");

        jTextField7.setBackground(new java.awt.Color(173, 188, 167));
        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField7.setText("Necessary Drawer Amount");

        jTextField8.setBackground(new java.awt.Color(173, 188, 167));
        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField8.setText("Actual Drawer Amount");

        jTextField9.setBackground(new java.awt.Color(173, 188, 167));
        jTextField9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField9.setText("Ones");

        jTextField10.setBackground(new java.awt.Color(173, 188, 167));
        jTextField10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField10.setText("Twenties");

        jTextField11.setBackground(new java.awt.Color(173, 188, 167));
        jTextField11.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField11.setText("Twos");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel4.setText("Bills:");

        jTextField12.setBackground(new java.awt.Color(173, 188, 167));
        jTextField12.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField12.setText("Fifties");

        jTextField13.setBackground(new java.awt.Color(173, 188, 167));
        jTextField13.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField13.setText("Fives");

        jTextField14.setBackground(new java.awt.Color(173, 188, 167));
        jTextField14.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField14.setText("Hundreds");

        jTextField15.setBackground(new java.awt.Color(173, 188, 167));
        jTextField15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField15.setText("Tens");

        jTextField16.setBackground(new java.awt.Color(173, 188, 167));
        jTextField16.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField16.setText("Misc.");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Balanced:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Balanced");

        jButton1.setText("jButton1");

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
                                            .addComponent(jTextField4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))))
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addComponent(jLabel6)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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

    //draw a client's screen
    public void initClientScreen(){
        //show client's personal information
        //show clients account'sand loans basic info
    }

    //draw an account's screen
    public void initAccountScreen(){
        //show balance
        //show recent transactions
        //deposit button
        //withdrawal button
        //transfer button
    }

    //draw a loan/card screen
    public void initLoanScreen(){
        //draw balance
        //draw loan recent transactions
        //draw payment button
        //loan draw button (if it is a rotating loan)
    }

    //draw teller funtions screen
    public void initTellerFunctions(){
    //Change Employee Password Button
    //Change Client Information Button
    //Reverse a Transaction Button
    //Balance Drawer Button
    }

    //clear all objects from the screen
    public void clearScreen(){

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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration
}
