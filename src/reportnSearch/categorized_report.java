/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportnSearch;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import reportnSearch.dbConnection;

/**
 *
 * @author imani
 */
public class categorized_report extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2  = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;
    java.util.Date toDate;
    java.sql.Date toSqlDate;
    java.util.Date fromDate;
    java.sql.Date fromSqlDate;
    

    /**
     * Creates new form categorized_report
     */
    public categorized_report() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void getCustomizedReport(){
        try{
            con = dbConnection.connect();
           
            PreparedStatement st = null;
            ResultSet rs = null;
            SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateF.format(new Date());

            toDate = datepicker_to.getDate(); 
            fromDate = datepicker_from.getDate();
            toSqlDate = new java.sql.Date(toDate.getTime());
            String toSqlDateS = dateF.format(toSqlDate);
               System.out.println("Date = " +toSqlDateS);

            fromSqlDate = new java.sql.Date(fromDate.getTime());
            String fromSqlDateS = dateF.format(fromSqlDate);
                System.out.println("Date =" + fromSqlDate);

            String query = "SELECT * FROM carDetails";
            st = con.prepareStatement(query);

            rs = st.executeQuery();
            double sp = 0;
            int count = 0;
            int carc = 0;
            int vanc = 0;
            int motorc = 0;
            int threewc = 0;
            while(rs.next())
             {
                 Date date = rs.getDate("departure_date_time"); 
                 String DDateS = dateF.format(date);

                 if(DDateS.equals(fromSqlDateS) || DDateS.equals(toSqlDateS)){
                     sp += rs.getDouble("payment");
                     count++;


                     if(rs.getInt("vehicle_type")==1){
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
    //System.out.println("Payment = " +Double.toString(rs.getDouble("payment")));

             }

            lbl_income1.setText(Double.toString(sp) + "/=");
            lbl_vehicleCount1.setText(Integer.toString(count));
            lbl_car1.setText(Integer.toString(carc));
            lbl_van1.setText(Integer.toString(vanc));
            lbl_bike1.setText(Integer.toString(motorc));
            lbl_3wheel1.setText(Integer.toString(threewc));

            con.close();
            st.close();
            rs.close();


                JOptionPane.showMessageDialog(null, "Report Generated");


            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }

        
    }
    
    public void print(){
        Document document = new Document();
        String payment = lbl_income1.getText();
        String vehicleC = lbl_vehicleCount1.getText();
        String carCount = lbl_car1.getText();
        String van = lbl_van1.getText();
        String mBike = lbl_bike1.getText();
        String threeWCount = lbl_3wheel1.getText();
    try
    {
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("reports/CustomizedReport.pdf"));
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
        
        document.add(new Paragraph("--------------------------------------------CUSTOMIZED REPORT--------------------------------------------------\n"));
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

        lbl_monthlytopic1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_selectDate1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_selectDate2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_totVehicles1 = new javax.swing.JLabel();
        lbl_totIncome1 = new javax.swing.JLabel();
        lbl_numberofCars1 = new javax.swing.JLabel();
        lbl_numberofVans1 = new javax.swing.JLabel();
        lbl_numberofMotorB1 = new javax.swing.JLabel();
        lbl_numberof3wheel1 = new javax.swing.JLabel();
        lbl_3wheel1 = new javax.swing.JLabel();
        lbl_bike1 = new javax.swing.JLabel();
        lbl_van1 = new javax.swing.JLabel();
        lbl_car1 = new javax.swing.JLabel();
        lbl_income1 = new javax.swing.JLabel();
        lbl_vehicleCount1 = new javax.swing.JLabel();
        datepicker_from = new org.jdesktop.swingx.JXDatePicker();
        datepicker_to = new org.jdesktop.swingx.JXDatePicker();
        btn_generate1 = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        btn_print1 = new javax.swing.JButton();
        lbl_monthlytopic2 = new javax.swing.JLabel();

        lbl_monthlytopic1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_monthlytopic1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_monthlytopic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_monthlytopic1.setText("Car Park Management - Monthly Report");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 74, 95));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 74, 95));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectDate1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_selectDate1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectDate1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_selectDate1.setText("From :");
        lbl_selectDate1.setToolTipText("");
        jPanel5.add(lbl_selectDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 120, 208, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Summary and Monthly Income");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 250, 845, 60));

        lbl_selectDate2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_selectDate2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectDate2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_selectDate2.setText("To :");
        lbl_selectDate2.setToolTipText("");
        jPanel5.add(lbl_selectDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 85, 27));

        jPanel6.setBackground(new java.awt.Color(51, 74, 95));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totVehicles1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totVehicles1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totVehicles1.setText("   Total number of vehicles parked");
        jPanel6.add(lbl_totVehicles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, 33));

        lbl_totIncome1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totIncome1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totIncome1.setText("   Total Income");
        lbl_totIncome1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_totIncome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 440, 33));

        lbl_numberofCars1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofCars1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofCars1.setText("   Number of cars parked");
        lbl_numberofCars1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofCars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 440, 33));

        lbl_numberofVans1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofVans1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofVans1.setText("   Number of vans parked");
        lbl_numberofVans1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofVans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 440, 33));

        lbl_numberofMotorB1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofMotorB1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofMotorB1.setText("   Number of motor bikes parked");
        lbl_numberofMotorB1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofMotorB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 440, 33));

        lbl_numberof3wheel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberof3wheel1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberof3wheel1.setText("   Number of three wheelers parked");
        lbl_numberof3wheel1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberof3wheel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 440, 33));

        lbl_3wheel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_3wheel1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_3wheel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_3wheel1.setText("0");
        jPanel6.add(lbl_3wheel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 240, 33));

        lbl_bike1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_bike1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bike1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_bike1.setText("0");
        jPanel6.add(lbl_bike1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 240, 33));

        lbl_van1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_van1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_van1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_van1.setText("0");
        jPanel6.add(lbl_van1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 240, 33));

        lbl_car1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_car1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_car1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_car1.setText("0");
        jPanel6.add(lbl_car1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 240, 33));

        lbl_income1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_income1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_income1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_income1.setText("0");
        jPanel6.add(lbl_income1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 240, 33));

        lbl_vehicleCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vehicleCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vehicleCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vehicleCount1.setText("0");
        jPanel6.add(lbl_vehicleCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 240, 33));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 790, 300));

        datepicker_from.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel5.add(datepicker_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 260, -1));

        datepicker_to.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel5.add(datepicker_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 260, -1));

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
        jPanel5.add(btn_generate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, -1, 63));

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
        jPanel5.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 700, -1, -1));

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
        jPanel5.add(btn_print1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 700, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 1020, 890));

        lbl_monthlytopic2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_monthlytopic2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_monthlytopic2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_monthlytopic2.setText("Customized Report");
        jPanel3.add(lbl_monthlytopic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 460, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate1ActionPerformed
        // TODO add your handling code here:
        
        java.util.Date date1 = datepicker_to.getDate(); 
        java.util.Date date2 = datepicker_from.getDate();
        if(date1 == null || date2 == null){
            JOptionPane.showMessageDialog(null, "Select a date");
        }
        else{
            getCustomizedReport();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(categorized_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categorized_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categorized_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categorized_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                categorized_report c = new categorized_report();
                c.setVisible(true);
                c.setSize(1100,960);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btn_generate1;
    private javax.swing.JButton btn_print1;
    private org.jdesktop.swingx.JXDatePicker datepicker_from;
    private org.jdesktop.swingx.JXDatePicker datepicker_to;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_3wheel1;
    private javax.swing.JLabel lbl_bike1;
    private javax.swing.JLabel lbl_car1;
    private javax.swing.JLabel lbl_income1;
    private javax.swing.JLabel lbl_monthlytopic1;
    private javax.swing.JLabel lbl_monthlytopic2;
    private javax.swing.JLabel lbl_numberof3wheel1;
    private javax.swing.JLabel lbl_numberofCars1;
    private javax.swing.JLabel lbl_numberofMotorB1;
    private javax.swing.JLabel lbl_numberofVans1;
    private javax.swing.JLabel lbl_selectDate1;
    private javax.swing.JLabel lbl_selectDate2;
    private javax.swing.JLabel lbl_totIncome1;
    private javax.swing.JLabel lbl_totVehicles1;
    private javax.swing.JLabel lbl_van1;
    private javax.swing.JLabel lbl_vehicleCount1;
    // End of variables declaration//GEN-END:variables
}
