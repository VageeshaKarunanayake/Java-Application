/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Function;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import dashboard.dashboard;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Vageesha
 */
public class View_Divide extends javax.swing.JFrame {

    /**
     * Creates new form View_Divide
     */
    public View_Divide() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 74, 95));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(51, 90, 255));
        jButton1.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/complete_table_view.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/complete_table_view_rollover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 360, 640, 140);

        jButton2.setBackground(new java.awt.Color(51, 90, 255));
        jButton2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/individual_record_view.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/individual_record_view_rollover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(180, 550, 640, 140);

        jButton4.setBackground(new java.awt.Color(51, 90, 255));
        jButton4.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_rollover.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(880, 820, 190, 80);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Car Park View Options");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 130, 580, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(900, 570, 70, 100);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/table.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(900, 380, 70, 100);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parking_lot.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(780, 150, 70, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               Table_View TD = new Table_View();
               TD.setLocationRelativeTo(null);
               TD.setSize(1100,960);
               TD.setResizable(false);
               TD.setVisible(true);
               TD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   TD.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(Table_View.class.getName()).log(Level.SEVERE, null, ex);
                }
               this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               Select_Individual_Record SIR = new Select_Individual_Record();
               SIR.setLocationRelativeTo(null);
               SIR.setSize(1100, 960);
               SIR.setResizable(false);
               SIR.setVisible(true);
               SIR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   SIR.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(Select_Individual_Record.class.getName()).log(Level.SEVERE, null, ex);
                }
               this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dashboard d = new dashboard();
        d.setVisible(true);
        try {
                   d.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               View_Divide VD = new View_Divide();
               VD.setLocationRelativeTo(null);
               VD.setSize(1100, 960);
               VD.setResizable(false);
               VD.setVisible(true);
               VD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   VD.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(View_Divide.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}