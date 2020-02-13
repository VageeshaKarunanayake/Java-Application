package dashboard;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteConfig;
/**
 *
 * @author Rukshan
 */
public class sql_connect {
    Connection con=null;
    public static Connection connectDB(){
        try{
                Connection con;
                SQLiteConfig sqLiteConfig = new SQLiteConfig();
                Properties properties = sqLiteConfig.toProperties();
                properties.setProperty(SQLiteConfig.Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd hh:mm a");
                con = DriverManager.getConnection("jdbc:sqlite:database.db",properties);   
            //JOptionPane.showMessageDialog(null, "Connection established");
            return con; 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
            
}
