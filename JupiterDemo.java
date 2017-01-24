import javax.swing.*;
import java.awt.*;

public class JupiterDemo extends javax.swing.JFrame {
    public int stdTextBoxWidth = 100;
    public int stdTextBoxHeight = 35;

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

        //Create Login Button
        c.gridy = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(stdTextBoxWidth, stdTextBoxHeight));
        getContentPane().add(loginButton, c);
        
        //draw everything
        pack();
    }

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
