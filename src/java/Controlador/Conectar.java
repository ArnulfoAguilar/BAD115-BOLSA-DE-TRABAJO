/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



/**
 *
 * @author Arnulfo
 */
public class Conectar {
   public OracleDataSource conectar()
 {
     try {
         OracleDataSource ods = new OracleDataSource();
         
         ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
         ods.setUser("BOLSA_TRABAJO");
         ods.setPassword("bolsa_trabajo");
         //Connection cn= ods.getConnection();
        return ods;
         
     } catch (SQLException ex) {
         Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
         return null;
     }
     
     
 }
    
    
    
    /* 
 public void conectar()
 {
     try {
         OracleDataSource ods = new OracleDataSource();
         
         ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
         ods.setUser("BOLSA_TRABAJO");
         ods.setPassword("bolsa_trabajo");
         Connection cn= ods.getConnection();
        
         
     } catch (SQLException ex) {
         Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
     }
 }*/
}
