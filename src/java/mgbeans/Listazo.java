/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import model.Plt;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Czirko
 */
@ManagedBean
@SessionScoped
public class Listazo {

   public List<Plt> getPlts() {
        return plts;
    }

    public void setPlts(List<Plt> plts) {
        this.plts = plts;
    }
    
    private List<Plt> plts;
    
    
 

    public Listazo() {
        
         SAXBuilder sb = new SAXBuilder();
         String s = Kosar.class.getProtectionDomain().getCodeSource().getLocation().getPath();
         
         System.out.println(s);
        File f = new File(s+"../../../../res/plant.xml");
        plts = new ArrayList();
        
        Document doc;
        try {
            doc = sb.build(f);
            Element root = doc.getRootElement();
            List<Element> pElements = root.getChildren();
            
            for (Element pe : pElements) {
                String common = pe.getChildText("COMMON");
                String botanical = pe.getChildText("BOTANICAL");
                String zone = pe.getChildText("ZONE");
                String light = pe.getChildText("LIGHT");
                String p=pe.getChildText("PRICE");
                double price = Double.parseDouble(p.substring(1));
                Plt plant = new Plt(common, botanical, zone, light, price);
                plts.add(plant);
            }
            
        } catch (JDOMException ex) {
             System.out.println(ex);
        } catch (IOException ex) {
             System.out.println(ex);
        }
    }   
}
