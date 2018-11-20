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
public class Gracz {

    public Gracz(int id, String imie, String rasa, String klasa) {
        this.id = id;
        this.imie = imie;
        this.rasa = rasa;
        this.klasa = klasa;
        this.sciezkaArchetypu = "brak";
        this.rozmiar = "nieznany";
        this.wiek = 0;
        this.plec = "nieznana";
        this.wzrost = 0.0;
        this.waga = 0.0;        
        this.charakter = "neutralny";
        this.bostwo = "brak";
        this.poziom = 1;
        this.epickiePrzeznaczenie = "nieznane";
        this.druzyna = "brak";
        this.pktAkcji = 1;
        sila = 1;
        kondycja = 1;
        zrecznosc = 1;
        inteligencja = 1;
        rozsadek = 1;
        charyzma = 1;
        
        
    }
    
    private int id;
    private String imie;
    private String rasa;
    private String klasa;
    private String sciezkaArchetypu;
    private String rozmiar;
    private int wiek;
    private String plec;
    private double wzrost;
    private double waga;
    private String charakter;
    private String bostwo;
    private int poziom;
    private String epickiePrzeznaczenie;
    private String druzyna;
    private double pktAkcji;
    private int sila, kondycja, zrecznosc, inteligencja,rozsadek,charyzma;

    /**
     * 
     * @param atrybuty
     * tablica 6elementów odpowiadających wartościom sily,kondycji,zrecznosci,inteligencji,rozsadkowi, charyzmie
     * @return 
     */
    public boolean setAtrybuty(int[] atrybuty){
        try{
        sila = atrybuty[0];
        kondycja = atrybuty[1];
        zrecznosc = atrybuty[2];
        inteligencja = atrybuty[3];
        rozsadek = atrybuty[4];
        charyzma = atrybuty[5];
        }catch(Exception e){
            System.out.println("Bład przy ustawianiu wielu atrybutów");
            return false;
        }
        return true;
    }
    
    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getKondycja() {
        return kondycja;
    }

    public void setKondycja(int kondycja) {
        this.kondycja = kondycja;
    }

    public int getZrecznosc() {
        return zrecznosc;
    }

    public void setZrecznosc(int zrecznosc) {
        this.zrecznosc = zrecznosc;
    }

    public int getInteligencja() {
        return inteligencja;
    }

    public void setInteligencja(int inteligencja) {
        this.inteligencja = inteligencja;
    }

    public int getRozsadek() {
        return rozsadek;
    }

    public void setRozsadek(int rozsadek) {
        this.rozsadek = rozsadek;
    }

    public int getCharyzma() {
        return charyzma;
    }

    public void setCharyzma(int charyzma) {
        this.charyzma = charyzma;
    }

    public Gracz() {        
    }
    
    public String getDane(){
        return id+" "+imie+" "+rasa+" "+plec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getSciezkaArchetypu() {
        return sciezkaArchetypu;
    }

    public void setSciezkaArchetypu(String sciezkaArchetypu) {
        this.sciezkaArchetypu = sciezkaArchetypu;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public double getWzrost() {
        return wzrost;
    }

    public void setWzrost(double wzrost) {
        this.wzrost = wzrost;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public String getCharakter() {
        return charakter;
    }

    public void setCharakter(String charakter) {
        this.charakter = charakter;
    }

    public String getBostwo() {
        return bostwo;
    }

    public void setBostwo(String bostwo) {
        this.bostwo = bostwo;
    }

    public int getPoziom() {
        return poziom;
    }

    public void setPoziom(int poziom) {
        this.poziom = poziom;
    }

    public String getEpickiePrzeznaczenie() {
        return epickiePrzeznaczenie;
    }

    public void setEpickiePrzeznaczenie(String epickiePrzeznaczenie) {
        this.epickiePrzeznaczenie = epickiePrzeznaczenie;
    }

    public String getDruzyna() {
        return druzyna;
    }

    public void setDruzyna(String druzyna) {
        this.druzyna = druzyna;
    }

    public double getPktAkcji() {
        return pktAkcji;
    }

    public void setPktAkcji(double pktAkcji) {
        this.pktAkcji = pktAkcji;
    }
    
}
