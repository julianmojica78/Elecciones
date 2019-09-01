package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.PieChartModel;

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
    
    private UploadedFile file;
    
    ArrayList<Candidato> lista = new ArrayList();
    
    PieChartModel modelo =  new PieChartModel();
    
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
    
     public void votacion(ArrayList<Candidato> lista){
        for (Candidato lista1 : lista) {
            if(lista1.getVotos() == 10){
                lista1.setVotos(20);
            }
        }
    }//votacion
    
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

       public PieChartModel getModelo() {
        return modelo;
    }

    public void setModelo(PieChartModel modelo) {
        this.modelo = modelo;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
        public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Exito", file.getFileName() + " Esta Subido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            foto = file.getFileName();
        }
    }
}//Candidato
