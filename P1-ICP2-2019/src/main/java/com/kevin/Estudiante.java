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
public class Estudiante implements Serializable{
    
    private static final long serialVersionUID=1001L;
    
    private int carnet;
    private String nombre;
    private int idCarrera;
    private String carrera;
    private Date fechaDeNacimiento;
    private int cantidadDeLibrosEnPrestamo;

     public final String PATH_COUNT="Contadores/ContadorDeEstudiantes.cnt";
    public final int INGENIERIA=1;
    public final int MEDICINA=2;
    public final int DERECHO=3;
    public final int ARQUITECTURA=4;
    public final int ADMINISTRACION=5;
    
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getCantidadDeLibrosEnPrestamo() {
        return cantidadDeLibrosEnPrestamo;
    }

    public void setCantidadDeLibrosEnPrestamo(int cantidadDeLibrosEnPrestamo) {
        this.cantidadDeLibrosEnPrestamo = cantidadDeLibrosEnPrestamo;
    }
    
    public Estudiante(int carnet, String nombre, int idCarrera){
        this(carnet,nombre,idCarrera,"",null);
    }
    
    public Estudiante(int carnet, String nombre, int idCarrera, String carrera, Date fechaDeNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.idCarrera = idCarrera;
        this.carrera = getNombreCarrera(idCarrera);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.cantidadDeLibrosEnPrestamo = 0;
        Archivo.actualizarContador(PATH_COUNT);
        Archivo.escribirArchivoBinario(getPathOfFile(carnet), this);
    }
    
    private String getNombreCarrera(int idCarrera){
            switch(idCarrera){
                case INGENIERIA:
                    return "Ingenieria";
                case MEDICINA:
                    return "Ingenieria";
                case DERECHO:
                    return "Ingenieria";
                case ARQUITECTURA:
                    return "Ingenieria";
                case ADMINISTRACION:
                    return "Ingenieria";
                default:
                    return null;
            }
    }
    
    private String getPathOfFile(int carnet){
        return "Estudiantes/"+String.valueOf(carnet)+".std";
    }    
            
}
