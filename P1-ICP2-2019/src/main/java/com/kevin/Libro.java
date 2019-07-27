/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author kevin
 */
public class Libro implements Serializable{

    private static final long serialVersionUID=1000L;
    private String codigo;
    private String autor;
    private String titulo;
    private int cantidadDeCopias;
    private Date fechaDePublicacion;
    private String editorial;
    
    public final String PATH_COUNT="Contadores/ContadorDeLibros.cnt";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadDeCopias() {
        return cantidadDeCopias;
    }

    public void setCantidadDeCopias(int cantidadDeCopias) {
        this.cantidadDeCopias = cantidadDeCopias;
    }

    public Date getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(Date fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    /**
     * Constructor creado para la lectura del archivo de entrada
     * @param codigo Codigo del libro
     * @param autor Autor del libro
     * @param titulo Titulo del libro
     * @param cantidadDeCopias  Cantidad de copias iniciales del libro
     */
    public Libro(String codigo,String autor, String titulo,  int cantidadDeCopias) {
           this(codigo,autor,titulo,cantidadDeCopias,null,"");
    }
    
    
    /**
     * Constructor creado para el formulario de nuevos libros, y escritura en archivos binarios
     * @param codigo Codigo del libro 
     * @param autor Autor del libro
     * @param titulo Titulo del libro
     * @param cantidadDeCopias Cantidad de copias a ingresar 
     * @param fechaDePublicacion Fecha de publicacion del libro
     * @param editorial La editorial encargada de la la publicacion
     */
    public Libro(String codigo, String autor, String titulo, int cantidadDeCopias, Date fechaDePublicacion, String editorial) {
           super();   
           this.codigo=codigo;
           this.autor=autor;
           this.titulo=titulo;
           this.cantidadDeCopias=cantidadDeCopias;
           this.fechaDePublicacion=fechaDePublicacion;
           this.editorial= editorial;
           Archivo.actualizarContador(PATH_COUNT);
          Archivo.escribirArchivoBinario(getPathOfFile(codigo), this);
    }

    /**
     * Metodo encargado de retornar una direccion para libros en base a su codigo
     * @param codigo El codigo del libro
     * @return Una direccion relativa donde se guardara el libro
     */
    private String getPathOfFile(String codigo){
        return "Libros/"+codigo+".book";
    }

    
    /**
     * Edita la cantidad de copias existentes de un libro
     * @param codigo El codigo de referencia del libro
     * @param cantidadDeNuevasCopias  La cantidad a agregar de copias
     */
    public void asingarNuevasCopias(String codigo,int cantidadDeNuevasCopias){
        Libro libro =(Libro) Archivo.leerArchivo(getPathOfFile(codigo));
        libro.setCantidadDeCopias(libro.getCantidadDeCopias()+cantidadDeNuevasCopias);
        Archivo.escribirArchivoBinario(getPathOfFile(codigo), libro);
    }
}