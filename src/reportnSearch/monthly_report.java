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
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import reportnSearch.dbConnection;

/**
 *
 * @author imani
 */
public class monthly_report extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ResultSet rs4 = null;

    /**
     * Creates new form monthly_report
     */
    public monthly_report() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void getMonthlyReport(){
        try{
            con = dbConnection.connect();
            Statement stmt = con.createStatement();
            String month = (String) combo_month.getSelectedItem();
            //get monthly income and total vehicle count 
            String query = "SELECT SUM(payment) as payment,COUNT(vehicle_type), case strftime('%m', departure_date_time) when '01' then 'January' when '02' then 'Febuary' when '03' then 'March' when '04' then 'April' when '05' then 'May' when '06' then 'June' when '07' then 'July' when '08' then 'August' when '09' then 'September' when '10' then 'October' when '11' then 'November' when '12' then 'December' else '' end"
                    + " as month FROM carDetails1 WHERE month  = '" + month+ "'";
            rs = stmt.executeQuery(query);
            
            String price = rs.getString(1);
            String vehicles = rs.getString(2);
            lbl_tot.setText(price + "/=");
            lbl_vehicleCount1.setText(vehicles);
            
            //get total car count
            Statement stmt1 = con.createStatement();
            String query1 = "SELECT COUNT(vehicle_type), case strftime('%m', departure_date_time) when '01' then 'January' when '02' then 'Febuary' when '03' then 'March' when '04' then 'April' when '05' then 'May' when '06' then 'June' when '07' then 'July' when '08' then 'August' when '09' then 'September' when '10' then 'October' when '11' then 'November' when '12' then 'December' else '' end"
                    + " as month FROM carDetails1 WHERE month = '" + month + "' AND vehicle_type = '1'";
            rs1 = stmt1.executeQuery(query1);
            
            String car = rs1.getString(1);
            lbl_carCount1.setText(car);
            
            //get total van count
            Statement stmt2 = con.createStatement();
            String query2 = "SELECT COUNT(vehicle_type), case strftime('%m', departure_date_time) when '01' then 'January' when '02' then 'Febuary' when '03' then 'March' when '04' then 'April' when '05' then 'May' when '06' then 'June' when '07' then 'July' when '08' then 'August' when '09' then 'September' when '10' then 'October' when '11' then 'November' when '12' then 'December' else '' end"
                    + " as month FROM carDetails1 WHERE month = '" + month + "' AND vehicle_type = '2'";
            rs2 = stmt2.executeQuery(query2);
            
            String van = rs2.getString(1);
            lbl_vanCount1.setText(van);
            
            //get total motor bike count
            Statement stmt3 = con.createStatement();
            String query3 = "SELECT COUNT(vehicle_type), case strftime('%m', departure_date_time) when '01' then 'January' when '02' then 'Febuary' when '03' then 'March' when '04' then 'April' when '05' then 'May' when '06' then 'June' when '07' then 'July' when '08' then 'August' when '09' then 'September' when '10' then 'October' when '11' then 'November' when '12' then 'December' else '' end"
                    + " as month FROM carDetails1 WHERE month = '" + month + "' AND vehicle_type = '3'";
            rs3 = stmt3.executeQuery(query3);
            
            String bike = rs3.getString(1);
            lbl_motorBCount1.setText(bike);
            
            //get total three wheel count
            Statement stmt4 = con.createStatement();
            String query4 = "SELECT COUNT(vehicle_type), case strftime('%m', departure_date_time) when '01' then 'January' when '02' then 'Febuary' when '03' then 'March' when '04' then 'April' when '05' then 'May' when '06' then 'June' when '07' then 'July' when '08' then 'August' when '09' then 'September' when '10' then 'October' when '11' then 'November' when '12' then 'December' else '' end"
                    + " as month FROM carDetails1 WHERE month = '" + month + "' AND vehicle_type = '4'";
            rs4 = stmt4.executeQuery(query4);
            
            String threewheel = rs4.getString(1);
            lbl_3wheelCount.setText(threewheel);
            con.close();
            
            JOptionPane.showMessageDialog(null, "Report Generated");
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
       
        
    }
    
    public void print(){
        Document document = new Document();
        String payment = lbl_tot.getText();
        String vehicleC = lbl_vehicleCount1.getText();
        String carCount = lbl_carCount1.getText();
        String van = lbl_vanCount1.getText();
        String mBike = lbl_motorBCount1.getText();
        String threeWCount = lbl_3wheelCount.getText();
    try
    {
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("reports/MonthlyReport.pdf"));
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
        
        document.add(new Paragraph("--------------------------------------------MONTHLY REPORT--------------------------------------------------\n"));
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

        jPanel7 = new javax.swing.JPanel();
        lbl_totVehicles2 = new javax.swing.JLabel();
        lbl_totIncome2 = new javax.swing.JLabel();
        lbl_numberofCars2 = new javax.swing.JLabel();
        lbl_numberofVans2 = new javax.swing.JLabel();
        lbl_numberofMotorB2 = new javax.swing.JLabel();
        lbl_numberof3wheel2 = new javax.swing.JLabel();
        lbl_vehicleCount12 = new javax.swing.JLabel();
        lbl_vehicleCount13 = new javax.swing.JLabel();
        lbl_vehicleCount14 = new javax.swing.JLabel();
        lbl_vehicleCount15 = new javax.swing.JLabel();
        lbl_vehicleCount16 = new javax.swing.JLabel();
        lbl_vehicleCount17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_selectDate1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_totVehicles1 = new javax.swing.JLabel();
        lbl_totIncome1 = new javax.swing.JLabel();
        lbl_numberofCars1 = new javax.swing.JLabel();
        lbl_numberofVans1 = new javax.swing.JLabel();
        lbl_numberofMotorB1 = new javax.swing.JLabel();
        lbl_numberof3wheel1 = new javax.swing.JLabel();
        lbl_3wheelCount = new javax.swing.JLabel();
        lbl_motorBCount1 = new javax.swing.JLabel();
        lbl_vanCount1 = new javax.swing.JLabel();
        lbl_carCount1 = new javax.swing.JLabel();
        lbl_tot = new javax.swing.JLabel();
        lbl_vehicleCount1 = new javax.swing.JLabel();
        combo_month = new javax.swing.JComboBox<>();
        lbl_monthlytopic1 = new javax.swing.JLabel();
        btn_generate = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();

        lbl_totVehicles2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_totVehicles2.setText("   Total number of vehicles parked");
        lbl_totVehicles2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_totIncome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_totIncome2.setText("   Total Income");
        lbl_totIncome2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_totIncome2.setPreferredSize(new java.awt.Dimension(209, 19));

        lbl_numberofCars2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_numberofCars2.setText("   Number of cars parked");
        lbl_numberofCars2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_numberofCars2.setPreferredSize(new java.awt.Dimension(209, 19));

        lbl_numberofVans2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_numberofVans2.setText("   Number of vans parked");
        lbl_numberofVans2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_numberofVans2.setPreferredSize(new java.awt.Dimension(209, 19));

        lbl_numberofMotorB2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_numberofMotorB2.setText("   Number of motor bikes parked");
        lbl_numberofMotorB2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_numberofMotorB2.setPreferredSize(new java.awt.Dimension(209, 19));

        lbl_numberof3wheel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_numberof3wheel2.setText("   Number of three wheelers parked");
        lbl_numberof3wheel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_numberof3wheel2.setPreferredSize(new java.awt.Dimension(209, 19));

        lbl_vehicleCount12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_vehicleCount13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_vehicleCount14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_vehicleCount15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_vehicleCount16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_vehicleCount17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(221, 221, 221)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_numberofMotorB2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(lbl_numberofVans2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_numberofCars2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_totIncome2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_totVehicles2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_numberof3wheel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount16, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount15, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount14, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount13, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount12, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(222, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_totVehicles2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_totIncome2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_numberofCars2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_numberofVans2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_vehicleCount13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_numberofMotorB2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_numberof3wheel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(lbl_vehicleCount12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 74, 95));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_selectDate1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_selectDate1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selectDate1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_selectDate1.setText("Select Month");
        lbl_selectDate1.setToolTipText("");
        jPanel5.add(lbl_selectDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 210, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Summary and Monthly Income");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 843, 60));

        jPanel6.setBackground(new java.awt.Color(51, 74, 95));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totVehicles1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totVehicles1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totVehicles1.setText("   Total number of vehicles parked");
        jPanel6.add(lbl_totVehicles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 460, 33));

        lbl_totIncome1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_totIncome1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totIncome1.setText("   Total Income");
        lbl_totIncome1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_totIncome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 460, 33));

        lbl_numberofCars1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofCars1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofCars1.setText("   Number of cars parked");
        lbl_numberofCars1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofCars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 460, 33));

        lbl_numberofVans1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofVans1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofVans1.setText("   Number of vans parked");
        lbl_numberofVans1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofVans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 460, 33));

        lbl_numberofMotorB1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberofMotorB1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberofMotorB1.setText("   Number of motor bikes parked");
        lbl_numberofMotorB1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberofMotorB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 460, 33));

        lbl_numberof3wheel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_numberof3wheel1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numberof3wheel1.setText("   Number of three wheelers parked");
        lbl_numberof3wheel1.setPreferredSize(new java.awt.Dimension(209, 19));
        jPanel6.add(lbl_numberof3wheel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 460, 33));

        lbl_3wheelCount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_3wheelCount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_3wheelCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_3wheelCount.setText("0");
        jPanel6.add(lbl_3wheelCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 180, 33));

        lbl_motorBCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_motorBCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_motorBCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_motorBCount1.setText("0");
        jPanel6.add(lbl_motorBCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 180, 33));

        lbl_vanCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vanCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vanCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vanCount1.setText("0");
        jPanel6.add(lbl_vanCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 180, 33));

        lbl_carCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_carCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_carCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_carCount1.setText("0");
        jPanel6.add(lbl_carCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 180, 33));

        lbl_tot.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_tot.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_tot.setText("0");
        jPanel6.add(lbl_tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 180, 33));

        lbl_vehicleCount1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_vehicleCount1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vehicleCount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_vehicleCount1.setText("0");
        jPanel6.add(lbl_vehicleCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 180, 33));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 830, 280));

        combo_month.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        combo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        jPanel5.add(combo_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 160, -1));

        lbl_monthlytopic1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_monthlytopic1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_monthlytopic1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_monthlytopic1.setText("Monthly Report");
        jPanel5.add(lbl_monthlytopic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 330, 60));

        btn_generate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_generate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_generate.png"))); // NOI18N
        btn_generate.setBorder(null);
        btn_generate.setBorderPainted(false);
        btn_generate.setContentAreaFilled(false);
        btn_generate.setFocusPainted(false);
        btn_generate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_generate1.png"))); // NOI18N
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });
        jPanel5.add(btn_generate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, 63));

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
        jPanel5.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 860, -1, -1));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_print (1).png"))); // NOI18N
        btn_print.setBorder(null);
        btn_print.setBorderPainted(false);
        btn_print.setContentAreaFilled(false);
        btn_print.setFocusPainted(false);
        btn_print.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/reportnResearch_Icons/button_print.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel5.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 860, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        // TODO add your handling code here:
        String month = (String) combo_month.getSelectedItem();
        
        if(month == null){
            JOptionPane.showMessageDialog(null, "Select a month");
        }
        else{
             getMonthlyReport();
        }
        
                        
    }//GEN-LAST:event_btn_generateActionPerformed

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

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
        print();        
    }//GEN-LAST:event_btn_printActionPerformed

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
            java.util.logging.Logger.getLogger(monthly_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(monthly_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(monthly_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(monthly_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                monthly_report m = new monthly_report();
                m.setVisible(true);
                m.setSize(1100,960);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> combo_month;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_3wheelCount;
    private javax.swing.JLabel lbl_carCount1;
    private javax.swing.JLabel lbl_monthlytopic1;
    private javax.swing.JLabel lbl_motorBCount1;
    private javax.swing.JLabel lbl_numberof3wheel1;
    private javax.swing.JLabel lbl_numberof3wheel2;
    private javax.swing.JLabel lbl_numberofCars1;
    private javax.swing.JLabel lbl_numberofCars2;
    private javax.swing.JLabel lbl_numberofMotorB1;
    private javax.swing.JLabel lbl_numberofMotorB2;
    private javax.swing.JLabel lbl_numberofVans1;
    private javax.swing.JLabel lbl_numberofVans2;
    private javax.swing.JLabel lbl_selectDate1;
    private javax.swing.JLabel lbl_tot;
    private javax.swing.JLabel lbl_totIncome1;
    private javax.swing.JLabel lbl_totIncome2;
    private javax.swing.JLabel lbl_totVehicles1;
    private javax.swing.JLabel lbl_totVehicles2;
    private javax.swing.JLabel lbl_vanCount1;
    private javax.swing.JLabel lbl_vehicleCount1;
    private javax.swing.JLabel lbl_vehicleCount12;
    private javax.swing.JLabel lbl_vehicleCount13;
    private javax.swing.JLabel lbl_vehicleCount14;
    private javax.swing.JLabel lbl_vehicleCount15;
    private javax.swing.JLabel lbl_vehicleCount16;
    private javax.swing.JLabel lbl_vehicleCount17;
    // End of variables declaration//GEN-END:variables
}
