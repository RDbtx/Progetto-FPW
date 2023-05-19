/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unica.dieetech.factory;
import it.unica.dieetech.model.Utente;
import it.unica.dieetech.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricle
 */
public class UtenteFactory {
    
    private static UtenteFactory instance;
    
    private UtenteFactory(){}
    
    public static UtenteFactory getInstance(){
        if(instance == null){//se non è stata creata allora creo una nuova istanza
            instance = new UtenteFactory();    
        }
        return instance; //esisterà solo questa istanza 
    }
    
    //metodo per recuperare un oggetto utente in base alle sue credenziali
    public Utente getUtenteByUsernamePassword(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet set = null;
        
        try{
            conn = DatabaseManager.getInstance().getDbConnection();
            
            String query = "SELECT * FROM utenti WHERE username = ? AND password = ?";
            
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            set = stmt.executeQuery();
            
            if(set.next()){
                Utente utente = new Utente();
                //leggiamo il risultato della query utilizzando il nome delle colonne anzichè l'indice
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setE_Mail(set.getString("e_mail"));
                //utente.setFoto(set.getString("foto"));
                return utente;
            }else{
                return null;
            }
   
        }catch(SQLException e){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE,null,e);
        }
        finally
        {
            //chiusura delle risorse per evitare dei memory leak
        try{set.close();}catch(Exception e){}
        try{stmt.close();}catch(Exception e){}
        try{conn.close();}catch(Exception e){}
        }
        return null;
    }
    
}

