/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import UI.CurrentUsers;
import UI.LogInnew;
import reportnSearch.main_report;
import reportnSearch.vehicle_search;
import View_Function.Payment;
import View_Function.View_Divide;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Chamod Sachin
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    private static dashboard d; 
    
    public dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        profile = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        payment = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        report = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        view = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        backbtn2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 50));
        setResizable(false);

        bg.setBackground(new java.awt.Color(51, 74, 95));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setBackground(new java.awt.Color(51, 74, 95));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(240, 241, 242));
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
        });
        profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 74, 95));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-male-80.png"))); // NOI18N
        jLabel11.setText("Users");
        profile.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        main.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 320, 160));

        payment.setBackground(new java.awt.Color(240, 241, 242));
        payment.setPreferredSize(new java.awt.Dimension(400, 150));
        payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentMouseExited(evt);
            }
        });
        payment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 74, 95));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-expensive-price-80.png"))); // NOI18N
        jLabel9.setText("Payments");
        payment.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        main.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 320, 160));

        add.setBackground(new java.awt.Color(240, 241, 242));
        add.setPreferredSize(new java.awt.Dimension(400, 150));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMousePressed(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(51, 74, 95));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 74, 95));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-plus-80.png"))); // NOI18N
        jLabel4.setText("Add Vehicle");
        add.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        main.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 320, 160));

        report.setBackground(new java.awt.Color(240, 241, 242));
        report.setPreferredSize(new java.awt.Dimension(400, 150));
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportMouseExited(evt);
            }
        });
        report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(51, 74, 95));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 74, 95));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-document-80.png"))); // NOI18N
        jLabel7.setText("Reports");
        report.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        main.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 320, 160));

        view.setBackground(new java.awt.Color(240, 241, 242));
        view.setPreferredSize(new java.awt.Dimension(400, 150));
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewMouseExited(evt);
            }
        });
        view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(51, 74, 95));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 74, 95));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hierarchy-80.png"))); // NOI18N
        jLabel8.setText("View All");
        view.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        main.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 320, 160));

        update.setBackground(new java.awt.Color(240, 241, 242));
        update.setPreferredSize(new java.awt.Dimension(400, 150));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 74, 95));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-refresh-80.png"))); // NOI18N
        jLabel5.setText("Update Vehicle");
        update.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        main.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 320, 160));

        delete.setBackground(new java.awt.Color(240, 241, 242));
        delete.setPreferredSize(new java.awt.Dimension(400, 150));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 74, 95));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-trash-can-80.png"))); // NOI18N
        jLabel6.setText("Delete Vehicle");
        delete.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        main.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 320, 160));

        search.setBackground(new java.awt.Color(240, 241, 242));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 74, 95));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-80.png"))); // NOI18N
        jLabel10.setText("Search");
        search.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        main.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 320, 160));

        bg.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 1040, 560));

        jLabel1.setFont(new java.awt.Font("Open Sans Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(201, 199, 199));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Vehicles Today");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 530, 140));

        jLabel2.setFont(new java.awt.Font("Open Sans Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(201, 199, 199));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("$ Total Income Today");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 540, 140));

        jLabel12.setFont(new java.awt.Font("Open Sans", 1, 72)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(201, 199, 199));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("00");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 530, 210));

        try{
            Connection con = sql_connect.connectDB();
            PreparedStatement st = null;
            ResultSet rs = null;
            SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateF.format(new Date());

            String query = "SELECT * FROM carDetails";
            st = con.prepareStatement(query);

            rs = st.executeQuery();
            int count = 0;
            while(rs.next())
            {
                Date date = rs.getDate("arrival_date_time");
                String DDateS = dateF.format(date);

                if(DDateS.equals(dateString))
                count++;
            }

            jLabel12.setText(Integer.toString(count));
            con.close();
            st.close();
            rs.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }

        backbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_logout.png"))); // NOI18N
        backbtn2.setBorderPainted(false);
        backbtn2.setContentAreaFilled(false);
        backbtn2.setFocusPainted(false);
        backbtn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_logout (1).png"))); // NOI18N
        backbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtn2ActionPerformed(evt);
            }
        });
        bg.add(backbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Open Sans", 1, 72)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(201, 199, 199));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("0000");
        bg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 540, 210));
        try{
            Connection con = sql_connect.connectDB();
            PreparedStatement st = null;
            ResultSet rs = null;
            SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateF.format(new Date());
            String query = "SELECT * FROM carDetails";
            st = con.prepareStatement(query);

            rs = st.executeQuery();
            double sp = 0;

            while(rs.next())
            {
                if(rs.getDate("departure_date_time") == null)
                continue;

                Date date = rs.getDate("departure_date_time");
                String DDateS = dateF.format(date);
                if(DDateS.equals(dateString))
                sp += rs.getDouble("payment");
            }
            jLabel16.setText(Double.toString(sp));
            con.close();
            st.close();
            rs.close();
        }catch(Exception e)
        {
            System.out.println("Exception at loading from database" + e);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMousePressed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        addVehicle af = new addVehicle();
        af.setVisible(true);
        try {
                   af.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(addVehicle.class.getName()).log(Level.SEVERE, null, ex);
                }
        dispose();
    }//GEN-LAST:event_addMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        authorize at = new authorize(1);
        at.setVisible(true);
        
        try {
                   at.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(authorize.class.getName()).log(Level.SEVERE, null, ex);
                }
        dispose();
    }//GEN-LAST:event_updateMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        authorize at = new authorize(2);
        at.setVisible(true);
        at.setResizable(false);
        try {
                   at.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(authorize.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        dispose();
    }//GEN-LAST:event_deleteMouseClicked

    private void reportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseEntered
        Color hover = new Color(125,161,193);
        report.setBackground(hover);
    }//GEN-LAST:event_reportMouseEntered

    private void reportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseExited
        Color hoverout = new Color(240,241,242);
        report.setBackground(hoverout);
    }//GEN-LAST:event_reportMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        Color hover = new Color(125,161,193);
        add.setBackground(hover);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        Color hoverout = new Color(240,241,242);
        add.setBackground(hoverout);
    }//GEN-LAST:event_addMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        Color hover = new Color(125,161,193);
        update.setBackground(hover);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        Color hoverout = new Color(240,241,242);
        update.setBackground(hoverout);
    }//GEN-LAST:event_updateMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        Color hover = new Color(125,161,193);
        delete.setBackground(hover);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        Color hoverout = new Color(240,241,242);
        delete.setBackground(hoverout);
    }//GEN-LAST:event_deleteMouseExited

    private void viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseEntered
        Color hover = new Color(125,161,193);
        view.setBackground(hover);
    }//GEN-LAST:event_viewMouseEntered

    private void viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseExited
        Color hoverout = new Color(240,241,242);
        view.setBackground(hoverout);
    }//GEN-LAST:event_viewMouseExited

    private void paymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseEntered
        Color hover = new Color(125,161,193);
        payment.setBackground(hover);
    }//GEN-LAST:event_paymentMouseEntered

    private void paymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseExited
        Color hoverout = new Color(240,241,242);
        payment.setBackground(hoverout);
    }//GEN-LAST:event_paymentMouseExited

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        Color hover = new Color(125,161,193);
        search.setBackground(hover);
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        Color hoverout = new Color(240,241,242);
        search.setBackground(hoverout);
    }//GEN-LAST:event_searchMouseExited

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseEntered
        Color hover = new Color(125,161,193);
        profile.setBackground(hover);
    }//GEN-LAST:event_profileMouseEntered

    private void profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseExited
        Color hoverout = new Color(240,241,242);
        profile.setBackground(hoverout);
    }//GEN-LAST:event_profileMouseExited

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
       authorize at = new authorize(3);
        at.setVisible(true);
        
        try {
                   at.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(authorize.class.getName()).log(Level.SEVERE, null, ex);
                }
        dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        vehicle_search sr = new vehicle_search();
        sr.setVisible(true);
        
        try {
                   sr.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(vehicle_search.class.getName()).log(Level.SEVERE, null, ex);
                }
        dispose();
    }//GEN-LAST:event_searchMouseClicked

    private void paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseClicked
               Payment PAY = new Payment();
               PAY.setLocationRelativeTo(null);
               PAY.setSize(1100, 960);
               PAY.setResizable(false);
               PAY.setVisible(true);
               PAY.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   PAY.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
               dispose();
    }//GEN-LAST:event_paymentMouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
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
               dispose();
    }//GEN-LAST:event_viewMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        CurrentUsers VD = new CurrentUsers();
               VD.setLocationRelativeTo(null);
               VD.setSize(1100, 390);
               VD.setResizable(false);
               VD.setVisible(true);
               VD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   VD.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(CurrentUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
               dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void backbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtn2ActionPerformed
        LogInnew r = new LogInnew();
        r.setLocationRelativeTo(null);
        r.setSize(1100,960);
        r.setVisible(true);
        r.setResizable(false);
       

        try {
            r.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
        } catch (IOException ex) {
            Logger.getLogger(LogInnew.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_backbtn2ActionPerformed

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
                d = new dashboard();
                d.setVisible(true);
                d.setSize(1100, 960);
                try {
                   d.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JButton backbtn2;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel main;
    private javax.swing.JPanel payment;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel report;
    private javax.swing.JPanel search;
    private javax.swing.JPanel update;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables
}
