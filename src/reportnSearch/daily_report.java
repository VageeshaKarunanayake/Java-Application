/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportnSearch;
import com.itextpdf.text.BaseColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import reportnSearch.dbConnection;
import java.util.Date;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import java.io.FilterOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import dashboard.sql_connect;
import java.io.*;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





/**
 *
 * @author imani
 */
public class daily_report extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;
    java.util.Date date;
    java.sql.Date sqlDate;
    
    /**
     * Creates new form daily_report
     */
    public daily_report() {
        initComponents();
        this.setLocationRelativeTo(null);//center of screen
    }
    
   public void getDailyReport(){
       try{
            Connection c = sql_connect.connectDB();
            PreparedStatement st = null;
            ResultSet rs = null;
            SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
            date = datePicker_date.getDate(); 
            sqlDate = new java.sql.Date(date.getTime());
            String SqlDateS = dateF.format(sqlDate);
                System.out.println("Date = " +SqlDateS);

            String query = "SELECT * FROM carDetails";
            st = c.prepareStatement(query);
        
            rs = st.executeQuery(); 
            double sp = 0;
            int count = 0;
            int carc = 0;
            int vanc = 0;
            int motorc = 0;
            int threewc = 0;
            while(rs.next())
             {
                 if(rs.getDate("departure_date_time") == null)
                     continue;
                 
                 Date date = rs.getDate("departure_date_time"); 
                 String DDateS = dateF.format(date);

                 if(DDateS.equals(SqlDateS)){
                     sp += rs.getDouble("payment");
                     count++;

                     if(rs.getInt("vehicle_type")== 1){
                         carc++;
                     }
                     else if(rs.getInt("vehicle_type") == 2){
                         vanc++;
                     }
                     else if(rs.getInt("vehicle_type") == 3){
                         motorc++;
                     }
                     else if(rs.getInt("vehicle_type") == 4){
                         threewc++;
                     }
                }
            }
                System.out.println("Payment = " +sp);
                
            lbl_income1.setText(Double.toString(sp) + "/=");
            lbl_vehicleCount1.setText(Integer.toString(count));
            lbl_carCount1.setText(Integer.toString(carc));
            lbl_vanCount1.setText(Integer.toString(vanc));
            lbl_motorBikeCount1.setText(Integer.toString(motorc));
            lbl_3wheelCount.setText(Integer.toString(threewc));

            c.close();
            st.close();
            rs.close();

           
           
        JOptionPane.showMessageDialog(null, "Report Generated");
           
       }catch(SQLException ex){
          // System.out.println(ex.getMessage());
          JOptionPane.showMessageDialog(null, ex);
       }
    
    }
   
   public void print(){
        Document document = new Document();
        String payment = lbl_income1.getText();
        String vehicleC = lbl_vehicleCount1.getText();
        String carCount = lbl_carCount1.getText();
        String van = lbl_vanCount1.getText();
        String mBike = lbl_motorBikeCount1.getText();
        String threeWCount = lbl_3wheelCount.getText();
    try
    {
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("reports/DailyReport.pdf"));
        document.open();
 
        PdfPTable table = new PdfPTable(2); // 2 columns.
        PdfPTable table1 = new PdfPTable(2);
        PdfPTable table2 = new PdfPTable(2);
        PdfPTable table3 = new PdfPTable(2);
        PdfPTable table4 = new PdfPTable(2);
        PdfPTable table5 = new PdfPTable(2);
        
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f);
        //Space after table
        
        table1.setWidthPercentage(100); //Width 100%
        table1.setSpacingBefore(10f); //Space before table
        table1.setSpacingAfter(10f);
        
        table2.setWidthPercentage(100); //Width 100%
        table2.setSpacingBefore(10f); //Space before table
        table2.setSpacingAfter(10f);
        
        table3.setWidthPercentage(100); //Width 100%
        table3.setSpacingBefore(10f); //Space before table
        table3.setSpacingAfter(10f);
        
        table4.setWidthPercentage(100); //Width 100%
        table4.setSpacingBefore(10f); //Space before table
        table4.setSpacingAfter(10f);
        
        table5.setWidthPercentage(100); //Width 100%
        table5.setSpacingBefore(10f); //Space before table
        table5.setSpacingAfter(10f);
 
        //Set Column widths
        float[] columnWidths = {1f, 1f};
        table.setWidths(columnWidths);
        table1.setWidths(columnWidths);
        table2.setWidths(columnWidths);
        table3.setWidths(columnWidths);
        table4.setWidths(columnWidths);
        table5.setWidths(columnWidths);
        
        document.add(new Paragraph("--------------------------------------------DAILY REPORT---------------------------------------------------------------\n"));
        document.add(new Paragraph("-------------------------------------------------------------------------------------------------------------------------------\n"));
        PdfPCell cell1 = new PdfPCell(new Paragraph("Total number of vehicles parked"));
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph(vehicleC));
        cell2.setBorderColor(BaseColor.BLACK);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell3 = new PdfPCell(new Paragraph("Total income"));
        cell3.setBorderColor(BaseColor.BLACK);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell4 = new PdfPCell(new Paragraph(payment));
        cell4.setBorderColor(BaseColor.BLACK);
        cell4.setPaddingLeft(10);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell5 = new PdfPCell(new Paragraph("Total number of motor cars"));
        cell5.setBorderColor(BaseColor.BLACK);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell6 = new PdfPCell(new Paragraph(carCount));
        cell6.setBorderColor(BaseColor.BLACK);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell7 = new PdfPCell(new Paragraph("Total number of vans"));
        cell7.setBorderColor(BaseColor.BLACK);
        cell7.setPaddingLeft(10);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell8 = new PdfPCell(new Paragraph(van));
        cell8.setBorderColor(BaseColor.BLACK);
        cell8.setPaddingLeft(10);
        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell9 = new PdfPCell(new Paragraph("Total number of motor bikes"));
        cell9.setBorderColor(BaseColor.BLACK);
        cell9.setPaddingLeft(10);
        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell10 = new PdfPCell(new Paragraph(mBike));
        cell10.setBorderColor(BaseColor.BLACK);
        cell10.setPaddingLeft(10);
        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell11 = new PdfPCell(new Paragraph("Total number of three wheelers"));
        cell11.setBorderColor(BaseColor.BLACK);
        cell11.setPaddingLeft(10);
        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell12 = new PdfPCell(new Paragraph(threeWCount));
        cell12.setBorderColor(BaseColor.BLACK);
        cell12.setPaddingLeft(10);
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        
 
        table.addCell(cell1);
        table.addCell(cell2);
        table1.addCell(cell3);
        table1.addCell(cell4);
        table2.addCell(cell5);
        table2.addCell(cell6);
        table3.addCell(cell7);
        table3.addCell(cell8);
        table4.addCell(cell9);
        table4.addCell(cell10);
        table5.addCell(cell11);
        table5.addCell(cell12);
        
        
       // table.addCell(cell3);
 
        document.add(table);
        document.add(table1);
        document.add(table2);
        document.add(table3);
        document.add(table4);
        document.add(table5);
        
 
        document.close();
        writer.close();
        
        JOptionPane.showMessageDialog(null, "PDF file created");
    } catch (Exception e)
    {
        e.printStackTrace();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_selectDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_totVehicles1 = new javax.swing.JLabel();
        lbl_totIncome1 = new javax.swing.JLabel();
        lbl_numberofCars1 = new javax.swing.JLabel();
        lbl_numberofVans1 = new javax.swing.JLabel();
        lbl_numberofMotorB1 = new javax.swing.JLabel();
        lbl_numberof3wheel1 = new javax.swing.JLabel();
        lbl_3wheelCount = new javax.swing.JLabel();
        lbl_motorBikeCount1 = new javax.swing.JLabel();
        lbl_vanCount1 = new javax.swing.JLabel();
        lbl_carCount1 = new javax.swing.JLabel();
        lbl_income1 = new javax.swing.JLabel();
        lbl_vehicleCount1 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        btn_generate1 = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        btn_print1 = new javax.swing.JButton();
        datePicker_date = new org.jdesktop.swingx.JXDatePicker();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 74, 95));
        setForeground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 74, 95));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        jPanel2.setBackground(new java.awt.Color(51, 74, 95));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_selectDate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_selectDate.setText("Select Day");
        lbl_selectDate.setToolTipText("");
        jPanel2.add(lbl_selectDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 310, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Summary and Daily Income");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 867, 100));

        jPanel6.setBackground(new java.awt.Color(51, 74, 95));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totVehicles1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totVehicles1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totVehicles1.setText("   Total number of vehicles parked");
        jPanel6.add(lbl_totVehicles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 400, 33));

        lbl_totIncome1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totIncome1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totIncome1.setText("   Total Income");
        lbl_totIncome1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_totIncome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 400, 33));

        lbl_numberofCars1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofCars1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofCars1.setText("   Number of cars parked");
        lbl_numberofCars1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofCars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 400, 33));

        lbl_numberofVans1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofVans1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofVans1.setText("   Number of vans parked");
        lbl_numberofVans1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofVans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 400, 33));

        lbl_numberofMotorB1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofMotorB1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofMotorB1.setText("   Number of motor bikes parked");
        lbl_numberofMotorB1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofMotorB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 400, 33));

        lbl_numberof3wheel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberof3wheel1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberof3wheel1.setText("   Number of three wheelers parked");
        lbl_numberof3wheel1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberof3wheel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 400, 33));

        lbl_3wheelCount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_3wheelCount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_3wheelCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_3wheelCount.setText("0");
        jPanel6.add(lbl_3wheelCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 170, 33));

        lbl_motorBikeCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_motorBikeCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_motorBikeCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_motorBikeCount1.setText("0");
        jPanel6.add(lbl_motorBikeCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 170, 33));

        lbl_vanCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vanCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vanCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vanCount1.setText("0");
        jPanel6.add(lbl_vanCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 170, 33));

        lbl_carCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_carCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_carCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_carCount1.setText("0");
        jPanel6.add(lbl_carCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 170, 33));

        lbl_income1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_income1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_income1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_income1.setText("0");
        jPanel6.add(lbl_income1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 170, 33));

        lbl_vehicleCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vehicleCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vehicleCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vehicleCount1.setText("0");
        jPanel6.add(lbl_vehicleCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 170, 33));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 920, 330));

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_title.setText("Daily Report");
        jPanel2.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 290, 60));

        btn_generate1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_generate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_generate.png"))); // NOI18N
        btn_generate1.setBorder(null);
        btn_generate1.setBorderPainted(false);
        btn_generate1.setContentAreaFilled(false);
        btn_generate1.setFocusPainted(false);
        btn_generate1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_generate1.png"))); // NOI18N
        btn_generate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_generate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, 63));

        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/button_back.png"))); // NOI18N
        backbtn.setBorder(null);
        backbtn.setBorderPainted(false);
        backbtn.setContentAreaFilled(false);
        backbtn.setFocusPainted(false);
        backbtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/button_back (1).png"))); // NOI18N
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        jPanel2.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 830, -1, -1));

        btn_print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_print (1).png"))); // NOI18N
        btn_print1.setBorder(null);
        btn_print1.setBorderPainted(false);
        btn_print1.setContentAreaFilled(false);
        btn_print1.setFocusPainted(false);
        btn_print1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_print.png"))); // NOI18N
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 830, -1, -1));

        datePicker_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel2.add(datePicker_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 260, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate1ActionPerformed
        // TODO add your handling code here:

        java.util.Date date1 = datePicker_date.getDate(); 
        
        if(date1 == null){
            JOptionPane.showMessageDialog(null, "Select a date");
        }
        else{
            getDailyReport();
        }   

    }//GEN-LAST:event_btn_generate1ActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        main_report mr = new main_report();
        mr.setVisible(true);
        this.setVisible(false);
        try {
                   mr.setIconImage(ImageIO.read(getResourceAsStream("Images/frameIcon.png")));
                } catch (IOException ex) {
                    Logger.getLogger(main_report.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_backbtnActionPerformed

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed
        // TODO add your handling code here:
        print();
      
    }//GEN-LAST:event_btn_print1ActionPerformed

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
                daily_report d = new daily_report();
                d.setVisible(true);
                d.setSize(1100, 960);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btn_generate1;
    private javax.swing.JButton btn_print1;
    private org.jdesktop.swingx.JXDatePicker datePicker_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_3wheelCount;
    private javax.swing.JLabel lbl_carCount1;
    private javax.swing.JLabel lbl_income1;
    private javax.swing.JLabel lbl_motorBikeCount1;
    private javax.swing.JLabel lbl_numberof3wheel1;
    private javax.swing.JLabel lbl_numberofCars1;
    private javax.swing.JLabel lbl_numberofMotorB1;
    private javax.swing.JLabel lbl_numberofVans1;
    private javax.swing.JLabel lbl_selectDate;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_totIncome1;
    private javax.swing.JLabel lbl_totVehicles1;
    private javax.swing.JLabel lbl_vanCount1;
    private javax.swing.JLabel lbl_vehicleCount1;
    // End of variables declaration//GEN-END:variables
}
