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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ProdottoFactory {
    private static ProdottoFactory instance;
    
    private ProdottoFactory(){}
    
    public static ProdottoFactory getInstance(){
        if(instance == null){
            instance = new ProdottoFactory();
        }
        return instance;
    }
    
    public List<Prodotto> getAllProdotti(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        List<Prodotto> prodotti = new ArrayList<>();
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM prodotti";
            stmt = conn.prepareStatement(query);
            set = stmt.executeQuery();
            
            while(set.next()){
                Prodotto prodotto = new Prodotto();
                prodotto.setId(set.getLong("id"));
                prodotto.setNome(set.getString("nome"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setSoftware(set.getString("software"));
                prodotto.setPrezzo(set.getFloat("prezzo"));
                prodotto.setQuantita(set.getInt("quantita"));
                prodotto.setUtente_id(set.getString("utente_id"));
                prodotto.setFoto(set.getString("foto"));
                prodotti.add(prodotto);  
            }
            return prodotti;
            
            
            
        }catch(SQLException e){
            Logger.getLogger(ProdottoFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally{
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    }
    
    
    public void setProdotto(String prodotto,int quantita, String software, float prezzo, String immagine){
          Connection conn = null;
          PreparedStatement stmt = null;
          
          try{
              conn = DatabaseManager.getInstance().getDbConnection();
              String query = "INSERT INTO utenti (prodotto, quantita, software, prezzo, immagine) "
                      + "VALUES (?,?,?,?,?);";
                  
              stmt = conn.prepareStatement(query);
              stmt.setString(1,prodotto);
              stmt.setInt(2,quantita);
              stmt.setString(3,software);
              stmt.setFloat(4,prezzo);
              stmt.setString(5,immagine);

              stmt.executeQuery();
                     
          }catch(SQLException e){
              Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
         
          }finally{
              try{stmt.close();}catch(Exception e){}
              try{conn.close();}catch(Exception e){}
          }
                     
}
}
