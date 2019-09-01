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
 *
 * @author Jonathan
 */
@ManagedBean
@RequestScoped
public class Resultado {

    ArrayList<Candidato> ganador = new ArrayList();
    
    
    public Resultado() {
    }
    
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

    public ArrayList<Candidato> getGanador() {
        return ganador;
    }

    public void setGanador(ArrayList<Candidato> ganador) {
        this.ganador = ganador;
    }
    
    
}
