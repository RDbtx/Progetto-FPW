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
public class Immagine {
    private long id;
    private String descrizione;
    private String nomeFile;
    private String percorso;
    
    public Immagine(){}
    public Immagine(String descrizione, String nomeFile, String percorso){
        this.descrizione = descrizione;
        this.nomeFile = nomeFile;
        this.percorso = percorso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 29 * hash + (int)(this.id^(this.id >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Immagine other = (Immagine) obj;
        if(!Objects.equals(this.id, other.id)){
            return false;
        }
        return true;
    }
}
