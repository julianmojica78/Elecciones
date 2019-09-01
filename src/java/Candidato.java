/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ASUS-PC
 */
@ManagedBean
@ApplicationScoped
public class Candidato implements Serializable {

    private String nombre;
    
    private String foto;
    
    private String partido;
    
    private Date fechaNacimiento;
    
    private String descripcion;
    
    private int votos;
    
    ArrayList<Candidato> lista = new ArrayList();
    
    public Candidato() {
    }//constructor

    public void GuardarCandidato(String nombre,String foto, String partido,Date fecha,String descripcion){
        Candidato candidato = new Candidato();
        candidato.nombre = nombre;
        candidato.foto = foto;
        candidato.partido = partido;
        candidato.fechaNacimiento = fecha;
        candidato.descripcion = descripcion;
        lista.add(candidato);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public ArrayList<Candidato> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Candidato> lista) {
        this.lista = lista;
    }

   
    
}//Candidato
