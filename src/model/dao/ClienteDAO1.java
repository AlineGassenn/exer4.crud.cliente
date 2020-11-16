/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class ClienteDAO1 {
    public void create(){
        Connection con =ConnectionFactory.getConnection();
        Statement stmt = null;
        
       
        try {
            String sql1="INSERT INTO cliente (nome, email, cpf, telefone, dataaniversario) VALUES ('Bianca','bianca@email.com','112.321.456-45','(55) 32204759','06/06')";
            String sql2="INSERT INTO cliente (nome, email, cpf, telefone, dataaniversario) VALUES ('Bruno','bruno@email.com','654.789.125-78','(55) 32207896','31/01')";
            String sql3="INSERT INTO cliente (nome, email, cpf, telefone, dataaniversario) VALUES ('Bernardo','bernardo@email.com','654.123.761-14','(55) 32201763','02/02')";
        
            con.setAutoCommit(false);
            stmt= con.createStatement();
            
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            if(true){
                throw new SQLException();
                
            }
            stmt.executeUpdate(sql3);
            con.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO1.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDAO1.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
         
         
   
   
    }
}
