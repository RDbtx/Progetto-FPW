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
    public void setProdotto(String nome, String descrizione, int quantita, String software, float prezzo, String utente_id, String foto){
          Connection conn = null;
          PreparedStatement stmt = null;
          
          try{
              conn = DatabaseManager.getInstance().getDbConnection();
              String query = "INSERT INTO prodotti (id, nome, descrizione, software, prezzo, quantita, utente_id, foto) "
                      + "VALUES (default, ? , ? , ? , ? , ? , ? , ?);";
                  
              stmt = conn.prepareStatement(query);
              stmt.setString(1,nome);
              stmt.setString(2, descrizione);
              stmt.setString(3,software);
              stmt.setFloat(4,prezzo);
              stmt.setInt(5,quantita);
              stmt.setString(6, utente_id);
              stmt.setString(7,foto);

              stmt.executeQuery();
                     
          }catch(SQLException e){
              Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
         
          }finally{
              try{stmt.close();}catch(Exception e){}
              try{conn.close();}catch(Exception e){}
          }
    }
    public Prodotto getProdotto(String offset){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        Prodotto prodotto = new Prodotto();
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            String query = "SELECT * FROM prodotti LIMIT 1 OFFSET ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(offset));
            set = stmt.executeQuery();
            while(set.next()){
                prodotto.setId(set.getLong("id"));
                prodotto.setNome(set.getString("nome"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setSoftware(set.getString("software"));
                prodotto.setPrezzo(set.getFloat("prezzo"));
                prodotto.setQuantita(set.getInt("quantita"));
                prodotto.setUtente_id(set.getString("utente_id"));
                prodotto.setFoto(set.getString("foto"));
            }
            return prodotto;
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    }
}
