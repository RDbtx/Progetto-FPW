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
public class Prodotto {
    private long id;
    private String nome;
    private String descrizione;
    private String software;
    private float prezzo;
    private int quantita;
    private String utente_id;
    private String foto;
    
    public Prodotto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(String utente_id) {
        this.utente_id = utente_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(this == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Prodotto other = (Prodotto) obj;
        if(!Objects.equals(this.id, other.id)){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
