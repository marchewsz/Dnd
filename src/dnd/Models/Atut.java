/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.Models;

/**
 *
 * @author march
 */
public class Atut {

        
    private int id;
    private String nazwa;
    private String opis;
    
    
    public Atut(int id, String nazwa, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    
}
