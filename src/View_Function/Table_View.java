/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Function;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Vageesha
 */
public class Table_View extends javax.swing.JFrame {

    /**
     * Creates new form View_Divide
     */
    public Table_View() {
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
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Arial", Font.BOLD, 15));
        header.setPreferredSize(new Dimension(100, 40));
        jTable1.setRowHeight(30);
        searchtext = new javax.swing.JTextField();
        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {

            }
            public void insertUpdate(DocumentEvent documentEvent) {

                TableRowSorter <TableModel> sorter = new TableRowSorter <TableModel>(((DefaultTableModel) jTable1.getModel())); 
                sorter.setRowFilter(RowFilter.regexFilter(searchtext.getText()));

                jTable1.setRowSorter(sorter);

            }
            public void removeUpdate(DocumentEvent documentEvent) {

                TableRowSorter <TableModel> sorter = new TableRowSorter <TableModel>(((DefaultTableModel) jTable1.getModel())); 
                sorter.setRowFilter(RowFilter.regexFilter(searchtext.getText()));

                jTable1.setRowSorter(sorter);

            }
        };

        searchtext.getDocument().addDocumentListener(documentListener);
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 74, 95));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Car Park Table View");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 20, 520, 100);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back_rollover.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(880, 810, 190, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/table.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(760, 50, 70, 60);

        jTable1.setBackground(new java.awt.Color(219, 242, 255));
        jTable1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 116));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle Plate", "Vehicle Type", "Arrival Date/Time", "Departure Date/Time", "Total Hours Parked", "Total Payment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement DBOUTPUT7 = conn.prepareStatement("SELECT * FROM carDetails");
            ResultSet RS6 = DBOUTPUT7.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

            while(RS6.next())
            {
                if(RS6.getDate("departure_date_time") == null)
                {
                    model.addRow(new Object[]{RS6.getString("vehicle_plate"),RS6.getInt("vehicle_type"),dateFormat.format(RS6.getDate("arrival_date_time")),"",0,0.0});
                    continue;
                }
                model.addRow(new Object[]{RS6.getString("vehicle_plate"),RS6.getInt("vehicle_type"),dateFormat.format(RS6.getDate("arrival_date_time")),dateFormat.format(RS6.getDate("departure_date_time")),RS6.getInt("hours_parked"),RS6.getDouble("payment")});
            }
            RS6.close();
            DBOUTPUT7.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,0);
        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,1);
        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,2);
        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,3);
        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,4);
        JTableUtilities.setCellsAlignment(jTable1, SwingConstants.CENTER,5);

        JTableUtilities.setRowWidth(jTable1, 1, 10);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 1020, 570);

        searchtext.setBackground(new java.awt.Color(219, 242, 255));
        searchtext.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        searchtext.setForeground(new java.awt.Color(0, 0, 116));
        searchtext.setMaximumSize(new java.awt.Dimension(50, 36));
        searchtext.setPreferredSize(new java.awt.Dimension(50, 36));
        jPanel1.add(searchtext);
        searchtext.setBounds(120, 140, 280, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 140, 80, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
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
               this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               Table_View TD = new Table_View();
               TD.setLocationRelativeTo(null);
               TD.setSize(1100, 960);
               TD.setResizable(false);
               TD.setVisible(true);
               TD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               try {
                   TD.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(Table_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchtext;
    // End of variables declaration//GEN-END:variables
}
