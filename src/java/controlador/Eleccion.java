/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.StreamedContent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.chart.PieChartModel;

/**
 * clase ManagedBean para la vista eleccion 
 * @author Jonathan
 */
@ManagedBean(name = "ele")
@RequestScoped
public class Eleccion implements Serializable {

    /**
     * atributo PieChartModel para la grafica
     */
    PieChartModel modelo = new PieChartModel();
    /**
     * constructor de eleccion
     */
    public Eleccion() {
    }
    /**
     * metodo para graficar los votos
     * @param lista 
     */
    public void graficar(ArrayList<Candidato> lista) {

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
     * metodo para calcular los votos de los candidatos 
     * @param lista
     * @param nombre 
     */
    public void votacion(ArrayList<Candidato> lista, String nombre) {
        for (Candidato lista1 : lista) {
            if (lista1.getNombre().equals(nombre)) {
                lista1.setVotos(lista1.getVotos() + 1);
            }
        }
        graficar(lista);
    }//votacion
    /**
     * funcion para mostrar la imagen
     * @param nombreArchivo
     * @return
     * @throws IOException 
     */
    public StreamedContent mostrarImagen(String nombreArchivo) throws IOException {
        ByteArrayOutputStream out = null;
        if (nombreArchivo == null) {
            out = traerArchivo("~\\Elecciones\\src\\java\\resources\\", "prueba.jpg");
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);
        }
        if (nombreArchivo.length() > 0) {
            File fichero = new File(nombreArchivo);
            out = traerArchivo("C:\\Users\\Jonathan\\Documents\\2019-ll\\Linea de profundizacion ll\\Elecciones\\src\\java\\resources\\", nombreArchivo);
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);

        } else {
            out = traerArchivo("C:\\Users\\Jonathan\\Documents\\2019-ll\\Linea de profundizacion ll\\Elecciones\\src\\java\\resources\\", "prueba.jpg");
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);
        }
    }
    /**
     * funcion para convertir la imagen
     * @param ruta
     * @param nombre_archivo
     * @return 
     */
    public ByteArrayOutputStream traerArchivo(String ruta, String nombre_archivo) {

        ByteArrayOutputStream out = null;
        String path = ruta + nombre_archivo;
        InputStream in = null;

        try {
            File remoteFile = new File(path);
            in = new BufferedInputStream(new FileInputStream(remoteFile));
            out = new ByteArrayOutputStream((int) remoteFile.length());
            byte[] buffer = new byte[1024];
            int len = 0; //Read length
            while ((len = in.read(buffer, 0, buffer.length)) != - 1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            String msg = "ERROR DESCARGANDO ARCHIVO " + e.getMessage();
            System.out.println(msg);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            }
        }

        return out;
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

}
