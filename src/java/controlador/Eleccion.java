/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Jonathan
 */
@ManagedBean(name = "ele")
@RequestScoped
public class Eleccion implements Serializable{

    PieChartModel modelo =  new PieChartModel();
   
    public Eleccion(){
    }
    public void graficar(ArrayList<Candidato> lista){
        
        
        for (Candidato lista1 : lista) {
            modelo.set(lista1.getNombre(), lista1.getVotos());
        }//for
        modelo.setTitle("Votacion");
        modelo.setLegendPosition("e");
        modelo.setFill(false);
        modelo.setShowDataLabels(true);
        modelo.setDiameter(150);
    }//graficar
    
    public void votacion(ArrayList<Candidato> lista,String nombre){
        for (Candidato lista1 : lista) {
            if(lista1.getNombre().equals(nombre)){
                lista1.setVotos(lista1.getVotos()+1);
            }
        }
        graficar(lista);
    }//votacion

    public PieChartModel getModelo() {
        return modelo;
    }

    public void setModelo(PieChartModel modelo) {
        this.modelo = modelo;
    }
    
    
}
