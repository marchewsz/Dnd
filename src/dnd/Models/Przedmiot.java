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
public class Przedmiot {

     private int id;
    private String nazwa;
    private int klasaPancerza;
    private int usprawnienie;
    private String rozne;
    
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

    public int getKlasaPancerza() {
        return klasaPancerza;
    }

    public void setKlasaPancerza(int klasaPancerza) {
        this.klasaPancerza = klasaPancerza;
    }

    public int getUsprawnienie() {
        return usprawnienie;
    }

    public void setUsprawnienie(int usprawnienie) {
        this.usprawnienie = usprawnienie;
    }

    public String getRozne() {
        return rozne;
    }

    public void setRozne(String rozne) {
        this.rozne = rozne;
    }

    public Przedmiot(int id, String nazwa, int klasaPancerza, int usprawnienie, String rozne) {
        this.id = id;
        this.nazwa = nazwa;
        this.klasaPancerza = klasaPancerza;
        this.usprawnienie = usprawnienie;
        this.rozne = rozne;
    }
    
   
    
}
