/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unica.dieetech.model;

import it.unica.dieetech.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class UtenteFactory {
    private static UtenteFactory instance;
    
    private UtenteFactory(){}
    
    public static UtenteFactory getInstance(){
        if(instance == null){
            instance = new UtenteFactory();
        }
        return instance;
    }
    public Utente getUtentebyUsernamePassword(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM utenti WHERE username = ? AND pass = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            set = stmt.executeQuery();
            
            if(set.next()){
                Utente utente = new Utente();
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("pass"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                utente.setCitta(set.getString("citta"));
                utente.setFoto(set.getString("foto"));
                return utente;
            }else{
                return null;
            }
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    }
    public void setUtente(String username, String nome, String cognome, String email, String password, String citta, String foto){
          Connection conn = null;
          PreparedStatement stmt = null;
          
          try{
              conn = DatabaseManager.getInstance().getDbConnection();
              String query = "INSERT INTO utenti (username,pass,nome,cognome,email,citta,foto) "
                      + "VALUES ( ? , ? , ? , ? , ? , ? , ? );";
                  
              stmt = conn.prepareStatement(query);
              stmt.setString(1,username);
              stmt.setString(2,password);
              stmt.setString(3,nome);
              stmt.setString(4,cognome);
              stmt.setString(5,email);
              stmt.setString(6,citta);
              stmt.setString(7,foto);
              stmt.executeQuery();
                     
          }catch(SQLException e){
              Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
         
          }finally{
              try{stmt.close();}catch(Exception e){}
              try{conn.close();}catch(Exception e){}
          }
    }
}


