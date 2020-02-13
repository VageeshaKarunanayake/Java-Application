/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;

/**
 *
 * @author Vageesha
 */
public class DatabaseConnection {
    
    public static Connection connect(){
        
        Connection conn = null;
        
        try{         
            SQLiteConfig sqLiteConfig = new SQLiteConfig();
            Properties properties = sqLiteConfig.toProperties();
            properties.setProperty(Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd hh:mm a");
            conn = DriverManager.getConnection("jdbc:sqlite:database.db",properties);
        }catch(Exception e){
            System.out.println(e);
        }
       return conn; 
    }
}
