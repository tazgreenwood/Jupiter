import javax.swing.*;
import java.awt.*;

public class JupiterDemo extends javax.swing.JFrame {
    public int stdTextBoxWidth = 150;
    public int stdTextBoxHeight = 35;
    public int bgColor = 0;
    public int btnColor = 0;
    public int innerMargins = 5;

    public JupiterDemo() {
        initComponents();
        initLogin();
    }

    //Makes Window
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
