package dnd;

import database.database;
import dnd.MainLayout;
import dnd.Models.Atut;
import dnd.Models.Gracz;
import java.util.*;
/**
 *
 * @author Marek_nowy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        database db = new database();
//        Gracz albert = new Gracz(1, "Albert","Elf","Paladyn");
//        db.insertGracz(albert);
//        
//        List<Gracz> gracze = db.selectGracze();
//        System.out.println("Lista graczy: ");
//        try{
//        for(Gracz g: gracze)
//            System.out.println("Gracz: "+g.getDane());
//        }catch(Exception e){
//            e.getMessage();
//        }
//System.out.println(""+db.selectGracz(1).getDane());

//        Atut atut1 = new Atut(1, "Obrona przed żywiołakami", "Bohater otrzymuje +6 do walki z żywiołakami");
//        Atut atut2 = new Atut(2, "Obrona przed smokami", "Bohater otrzymuje +6 do walki ze smokami");
//        db.insertAtut(atut1);
//        db.insertAtut(atut2);
//        db.deleteDb("gracze");

//        List<Atut> atuty = db.selectAtuty();
//        try{
//        for(Atut a: atuty)
//            System.out.println("Atut: "+a.getNazwa()+" "+a.getOpis());
//        }catch(Exception e){
//            e.getMessage();
//        }
//        
        
        MainLayout layout = new MainLayout();
    }
    
}
