/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.KosarElem;
import model.Plt;

/**
 *
 * @author Czirko
 */
@ManagedBean
@SessionScoped
public class Kosar {

    private List<KosarElem> keList;

    public double getTotalkosar() {
        double sum = 0;
        for (KosarElem ke : keList) {
            sum += ke.getOsszar();
        }
        return sum;
    }

    public void hozzaAd(Plt plt) {
        KosarElem elem = null;
        for (KosarElem ke : keList) {
            if (ke.getTermek() == plt) {
                elem = ke;
            }
        }
        if (elem != null) {
            elem.dbNovel();
        } else {
            elem = new KosarElem(1, plt);
            keList.add(elem);
        }

    }

    public int getTotalDb() {
        int sum = 0;
        for (KosarElem ke : keList) {
            sum += ke.getDb();
        }
        return sum;
    }

    public void torol(KosarElem ke) {
        keList.remove(ke);
    }

    public void keDbNovel(KosarElem ke) {
        ke.dbNovel();
    }

    public void keDbCsokkent(KosarElem ke) {
        if(ke.getDb()==1){
            torol(ke);
        }else{
            ke.dbCsokkent();
        }
    }

    public Kosar() {
        keList = new ArrayList<>();

    }

    public List<KosarElem> getKeList() {
        return keList;
    }

    public void setKeList(List<KosarElem> keList) {
        this.keList = keList;
    }

    public Kosar(List<KosarElem> keList) {
        this.keList = keList;
    }
    /**
     * Creates a new instance of Kosar
     */

}
