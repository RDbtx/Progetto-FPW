/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unica.dieetech.model;
import java.util.Objects;

/**
 *
 * @author ricle
 */
public class Utente {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String e_mail;
    private String foto;
    private String foto;
    
    //costruttore vuoto
    public Utente(){}
    
    
    //metodi Getter e Setter per tutti gli attributi del db
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getE_Mail() {
        return e_mail;
    }

    public void setE_Mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    @Override
    public boolean equals(Object obj){
        if(this == obj){//se questa classe è uguale all'oggetto, allora vuol dire che l'oggetto è uguale all'utente
            return true;
        }
        if(this == null){
            return false;
        }
        
        if(getClass()!= obj.getClass()){
            return false;
        }
        
        final Utente other = (Utente) obj;
        if(!Objects.equals(this.username, other.username)){
        return false;
        }return true;
    }
    
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 79 *hash + Objects.hashCode(this.username);
        return hash;
    }

    
}

