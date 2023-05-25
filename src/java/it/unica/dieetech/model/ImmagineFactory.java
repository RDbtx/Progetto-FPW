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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ImmagineFactory {
    private static ImmagineFactory instance;
    
    private ImmagineFactory(){}
    
    public static ImmagineFactory getInstance(){
        if(instance == null){
            instance = new ImmagineFactory();
        }
        return instance;
    }
    public boolean addImmagine(Immagine immagine){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "INSERT INTO immagini VALUES (default, ? , ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, immagine.getDescrizione());
            stmt.setString(2, immagine.getNomeFile());
            stmt.setString(3, immagine.getPercorso());
            int rows = stmt.executeUpdate();
            return rows == 1;
            
        }catch(SQLException e){
            Logger.getLogger(ImmagineFactory.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return false;
    }
    public ArrayList<Immagine> getImmagini(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        ArrayList <Immagine> risultato = new ArrayList<>();
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM immagini";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();
            
            while(set.next()){
                Immagine elemento = new Immagine();
                elemento.setId(set.getInt("id"));
                elemento.setDescrizione(set.getString("descrizione"));
                elemento.setNomeFile(set.getString("nome_file"));
                elemento.setPercorso(set.getString("percorso"));
                risultato.add(elemento);
            }
            return risultato;
        }catch(SQLException e){
            Logger.getLogger(ImmagineFactory.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    }
}
