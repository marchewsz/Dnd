/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dnd.Models;

import dnd.Models.Gracz;
import dnd.Models.Przedmiot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author march
 */
public class Ekwipunek {

    private int ekwipunekId;

    public int getEkwipunekId() {
        return ekwipunekId;
    }

    public void setEkwipunekId(int ekwipunekId) {
        this.ekwipunekId = ekwipunekId;
    }
    private int graczId;
    private int przedmiotId;
    
    public int getGraczId() {
        return graczId;
    }

    public void setGraczId(int graczId) {
        this.graczId = graczId;
    }

    public int getPrzedmiotId() {
        return przedmiotId;
    }

    public void setPrzedmiotId(int przedmiotId) {
        this.przedmiotId = przedmiotId;
    }

    public Ekwipunek(int ekwipunekId,int graczId, int przedmiotId) {
        this.ekwipunekId = ekwipunekId;
        this.graczId = graczId;
        this.przedmiotId = przedmiotId;
    }
    
    
}
