/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Czirko
 */
public class KosarElem {
    private int db;
    private Plt termek;
    
    public double getOsszar(){
        return db*termek.getPrice();
    }
    
    public void dbNovel(){
        db++;
    }
    public void dbCsokkent(){
        db--;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public Plt getTermek() {
        return termek;
    }

    public void setTermek(Plt termek) {
        this.termek = termek;
    }

    public KosarElem(int db, Plt termek) {
        this.db = db;
        this.termek = termek;
    }

    public KosarElem() {
    }
}
