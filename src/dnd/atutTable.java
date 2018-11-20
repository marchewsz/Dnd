/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd;
import java.util.*;
import dnd.Models.Atut;
import javax.swing.JTable;

/**
 *
 * @author march
 */
public class atutTable extends JTable {


    String[] columnNames = {"Lp.",
                        "Nazwa atutu",
                        "Opis"};
    List<Atut> atuty; 
    public atutTable( List<Atut> atuty) {
        this.atuty = atuty;
    }
    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public List<Atut> getAtuty() {
        return atuty;
    }

    public void setAtuty(List<Atut> atuty) {
        this.atuty = atuty;
    }
    
}
