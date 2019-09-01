/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ASUS-PC
 */
@ManagedBean(name = "inter")
@RequestScoped
public class Internacionalizacion implements Serializable{

    private String localidad;

    private static final Map<String, Object> listaPaises;
       
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }  

    public  Map<String, Object> getListaPaises() {
        return listaPaises;
    }
  
    
    static {
        listaPaises = new LinkedHashMap<>();        
        Locale espanol = new Locale("ES");
        listaPaises.put("Español", espanol);
        listaPaises.put("English", Locale.ENGLISH);
        listaPaises.put("Français", Locale.FRENCH);        
    }    
        
    public void  localidadChanged(ValueChangeEvent e) {
        String newLanguage = e.getNewValue().toString();
        
        
        for (Map.Entry<String, Object> entrySet : listaPaises.entrySet()) {
            if(entrySet.getValue().toString().equals(newLanguage)) {
                FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale)entrySet.getValue());
            }
            
        }
    }
    
}
