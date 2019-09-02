/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Clase MangedBean para mostrar el ganador de las elecciones
 * @author Jonathan
 */
@ManagedBean
@RequestScoped
public class Resultado {
    /**
     * atributo ArrayList para agregar los datos del ganador
     */
    ArrayList<Candidato> ganador = new ArrayList();
    
    /**
     * constructor del resultado
     */
    public Resultado() {
    }
    /**
     * metodo para elegir quien fue el ganador de las elecciones
     * @param lista 
     */
    public void ganador(ArrayList<Candidato> lista){
        int votos=0;
        Candidato candidato = new Candidato();
        for (Candidato lista1 : lista) {
            votos=lista1.getVotos();
            for (Candidato lista2 : lista) {
                if(lista2.getVotos() > votos ){
                    candidato = lista2;
                }//if
            }//for
        }//for
        ganador.add(candidato);
    }
    /**
     * metodo para obtener la lista del ganador
     * @return ganador
     */
    public ArrayList<Candidato> getGanador() {
        return ganador;
    }
    /**
     * modelo para modificar la lista de ganadores
     * @param ganador 
     */
    public void setGanador(ArrayList<Candidato> ganador) {
        this.ganador = ganador;
    }
    
    
}
