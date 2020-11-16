/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Acer
 */
public class Cliente {
    private int idcliente;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String dataaniversario; 
   
    public Cliente(){
        
    }
    
    public int getIdcliente() {
        return idcliente;
    }
    
     public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dataAniversario
     */
    public String getDataaniversario() {
        return dataaniversario;
    }

    /**
     * @param dataAniversario the dataAniversario to set
     */
    public void setDataaniversario(String dataaniversario) {
        this.dataaniversario = dataaniversario;
    }
    
    
}
