package UI;


import UI.ResetPassword;
import UI.SignUpNew;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import dashboard.dashboard;
import dashboard.sql_connect;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.dbConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bimsara Gimhan
 */
public class LogInnew extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    /**
     * Creates new form LogInnew
     */
    public LogInnew() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void login(){
        if(txt_username.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Please fill all fields"); 
        }
        else if(txt_password.getPassword().length == 0){
            JOptionPane.showMessageDialog(null, "Please fill all fields"); 
        }
        else{
            String user = txt_username.getText();
            char[] pwd = txt_password.getPassword();
            String password = String.copyValueOf(pwd);
            if(validate(user, password)){
                //JOptionPane.showMessageDialog(null, "Login Successful");
                dashboard d = new dashboard();
            d.setVisible(true);
            try {
                       d.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                    } catch (IOException ex) {
                        Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
            dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect login credentials"); 
            }
        }
    }
    
    public boolean validate(String username, String password){
        try{
            con = sql_connect.connectDB();
            String query = "SELECT * FROM users WHERE username = ? AND password = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            return rs.next();    
            
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex); 
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_register = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        backbtn3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 74, 95));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_register.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb_register.setForeground(new java.awt.Color(51, 204, 0));
        lb_register.setText("New User?");
        lb_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registerMouseClicked(evt);
            }
        });
        jPanel2.add(lb_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Log In |");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/icon_user.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 60, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/icon_password.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 50, 50));

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_username.setForeground(new java.awt.Color(153, 153, 153));
        txt_username.setText("User Name");
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_usernameMousePressed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 350, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Forgot password ?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, -1, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_password.setText("****************");
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passwordMousePressed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 350, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/icons8-person-80.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("______");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("User Name");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        backbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_login.png"))); // NOI18N
        backbtn3.setBorder(null);
        backbtn3.setBorderPainted(false);
        backbtn3.setContentAreaFilled(false);
        backbtn3.setFocusPainted(false);
        backbtn3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_login (1).png"))); // NOI18N
        backbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtn3ActionPerformed(evt);
            }
        });
        jPanel2.add(backbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 760, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registerMouseClicked

        SignUpNew signup = new SignUpNew();
            signup.setVisible(true);
            signup.setLocationRelativeTo(null);
            
            try {
                   signup.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_lb_registerMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        ResetPassword rst = new ResetPassword();
            rst.setLocationRelativeTo(null);
            rst.setVisible(true);
            
            try {
                   rst.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseClicked
      /*  txt_username.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    txt_username.setText("");
        
  }
});*/
        txt_username.setText(null);
    }//GEN-LAST:event_txt_usernameMouseClicked

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        txt_password.setText(null);
    }//GEN-LAST:event_txt_passwordMouseClicked

    private void txt_passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordMousePressed

    private void txt_usernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMousePressed
        txt_username.setText(null);
    }//GEN-LAST:event_txt_usernameMousePressed

    private void backbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtn3ActionPerformed
        login();
    }//GEN-LAST:event_backbtn3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInnew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogInnew l = new LogInnew();
                l.setVisible(true);
                l.setSize(1100,960);
                l.setLocationRelativeTo(null);
                
                try {
                   l.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(LogInnew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_register;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
