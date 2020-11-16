/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author Acer
 */
public class ClienteDAO {
    
    public void create (Cliente cliente){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement ("INSERT INTO cliente (nome, email, cpf, telefone, dataaniversario) VALUES (?,?,?,?,?)");
            stmt.setString (1, cliente.getNome());
            stmt.setString (2, cliente.getEmail());
            stmt.setString (3, cliente.getCpf());
            stmt.setString (4, cliente.getTelefone());
            stmt.setString (5, cliente.getDataaniversario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public ArrayList<Cliente> read(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY idcliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setIdcliente(rs.getInt("idcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setCpf(rs.getString("cpf"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setDataaniversario(rs.getString("dataaniversario"));
                
                listaCliente.add(cli);
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,ex );
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return listaCliente;
         
    }
    
    public void update (Cliente cliente){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement ("UPDATE cliente SET nome=?,  email=?, cpf=? telefone=? dataaniversario=? WHERE idcliente=?");
            stmt.setString (1, cliente.getNome());
            stmt.setString (2, cliente.getEmail());
            stmt.setString (3, cliente.getCpf());
            stmt.setString (4, cliente.getTelefone());
            stmt.setString (5, cliente.getDataaniversario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
    
     public void delete (Cliente cliente){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement ("DELETE FROM cliente WHERE idcliente=?");
            stmt.setInt (1, cliente.getIdcliente());
        
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar ");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
    
    
    
}
