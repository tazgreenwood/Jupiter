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
        
        //create Username Field
        c.gridx = 0;
        c.gridy = 0;
        JTextField username = new JTextField("Username");
        username.setPreferredSize(new Dimension(stdTextBoxWidth, stdTextBoxHeight));
        getContentPane().add(username, c);
        
        //Create Password Field
        c.gridy = 1;
        JPasswordField passField =  new JPasswordField();
        passField.setPreferredSize(new Dimension(stdTextBoxWidth, stdTextBoxHeight));
        getContentPane().add(passField, c);
       
        //Add new employee button
        c.gridy = 2;
        JButton loginButton = new JButton("Add New Employee");
        loginButton.setPreferredSize(new Dimension(stdTextBoxWidth, stdTextBoxHeight));
        getContentPane().add(loginButton, c);
        
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
