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
 * Clase ManagedBean para Candidato
 */
@ManagedBean
@ApplicationScoped
public class Candidato implements Serializable {
    /**
     * atributo String donde declaramos el nombre
     */
    private String nombre;
    /**
     * atributo String donde declaramos la foto
     */
    private String foto;
    /**
     * atributo String donde declaramos el nombre del partido
     */
    private String partido;
    /**
     * atributo Date donde declaramos la fecha de nacimiento 
     */
    private Date fechaNacimiento;
    /**
     * atributo String donde declaramos la descripcion
     */
    private String descripcion;
    /**
     * atributo entero donde declaramos los votos
     */
    private int votos;
    /**
     * atributo UploadFile para capturar el nombre de la imagen
     */
    private UploadedFile file;
    /**
     * atributo ArrayList para listar los candidatos
     */
    ArrayList<Candidato> lista = new ArrayList();
    /**
     * atributo PieChartModel para la grafica
     */
    PieChartModel modelo =  new PieChartModel();
    
    /**
     * constructor de candidato
     */
    public Candidato() {
    }//constructor
    /**
     * Constructor de la clase candidato donde inicialiamos las variables
     * @param nombre
     * @param foto
     * @param partido
     * @param fecha
     * @param descripcion 
     */
    public void GuardarCandidato(String nombre,String foto, String partido,Date fecha,String descripcion){
        Candidato candidato = new Candidato();
        candidato.nombre = nombre;
        candidato.foto = foto;
        candidato.partido = partido;
        candidato.fechaNacimiento = fecha;
        candidato.descripcion = descripcion;
        lista.add(candidato);
    }
    /**
     * funcion para graficar los votos
     * @param lista 
     */
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
    /**
     * funcion para sumar los puntos
     * @param lista 
     */
     public void votacion(ArrayList<Candidato> lista){
        for (Candidato lista1 : lista) {
            if(lista1.getVotos() == 10){
                lista1.setVotos(20);
            }
        }
    }//votacion
    /**
     *  metodo para obtener el nombre del candidato
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * metodo para modificar el nombre del candidato
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo para obtener la foto del candidato
     * @return foto
     */
    public String getFoto() {
        return foto;
    }
    /**
     * metodo para modificar la foto del candidato
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
    /**
     * metodo para obtener el nombre del partido del candidato
     * @return partido
     */
    public String getPartido() {
        return partido;
    }
    /**
     * metodo para actualizar el nombre del partido del candidato
     * @param partido 
     */
    public void setPartido(String partido) {
        this.partido = partido;
    }
    /**
     * metodo para obtener la fecha de nacimiento del candidato
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * metodo para modificar la fecha de nacimiento del candidato
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * metodo para obtener la descripcion del candidato
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * metodo para modificar la descripcion del candidato
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * metodo para obtener los votos del candidato
     * @return votos
     */
    public int getVotos() {
        return votos;
    }
    /**
     * metodo para modificar los votos del candidato
     * @param votos 
     */
    public void setVotos(int votos) {
        this.votos = votos;
    }
    /**
     * metodo para obtener la lista de candidatos
     * @return ArrayList<Candidato>
     */
    public ArrayList<Candidato> getLista() {
        return lista;
    }
    /**
     * metodo para modificar la lista de candidatos
     * @param lista 
     */
    public void setLista(ArrayList<Candidato> lista) {
        this.lista = lista;
    }
    /**
     * metodo para obtener el modelo para la grafica
     * @return modelo
     */
       public PieChartModel getModelo() {
        return modelo;
    }
    /**
     * metodo para modificar el modelo para la grafica
     * @param modelo 
     */
    public void setModelo(PieChartModel modelo) {
        this.modelo = modelo;
    }
    /**
     * metodo para obtener la ruta de la imagen
     * @return file
     */
    public UploadedFile getFile() {
        return file;
    }
    /**
     * metodo para modificar la ruta de la imagen
     * @param file 
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    /**
     * metodo para subir la imagen
     */
        public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Exito", file.getFileName() + " Esta Subido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            foto = file.getFileName();
        }
    }
}//Candidato
