/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unica.dieetech.model;

import java.util.Objects;

/**
 *
 * @author andre
 */
public class Utente {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private String citta;
    private String foto;

    
    //costruttore vuoto
    public Utente(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
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