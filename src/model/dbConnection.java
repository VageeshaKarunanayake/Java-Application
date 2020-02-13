/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;
/**
 *
 * @author imani
 */
public class dbConnection {
    
    public static Connection connect(){
        
        Connection conn = null;
        
        try{         
            SQLiteConfig sqLiteConfig = new SQLiteConfig();
            Properties properties = sqLiteConfig.toProperties();
            properties.setProperty(Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd hh:mm a");
            conn = DriverManager.getConnection("jdbc:sqlite:J:/database/database.db",properties);
            System.out.println("Connection has been established");
        }catch(Exception e){
            System.out.println(e);
        }
       return conn; 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
    
}
