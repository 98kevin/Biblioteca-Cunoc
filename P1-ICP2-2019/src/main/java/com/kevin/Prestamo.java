/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author kevin
 */
public class Prestamo implements Serializable{
    
    private final static long serialVersionUID=1002L;
    
    private String codigoLibro;
    private int carnet;
    private int idCarrera;
    private Date fecha;
    private int diasEnMora;
    private double total;
    private double totalDeMora;
    private boolean cancelado;

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDiasEnMora() {
        return diasEnMora;
    }

    public void setDiasEnMora(int diasEnMora) {
        this.diasEnMora = diasEnMora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDeMora() {
        return totalDeMora;
    }

    public void setTotalDeMora(double totalDeMora) {
        this.totalDeMora = totalDeMora;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    /**
     * Crea un nuevo prestamo en base al formulario de ingreso
     * @param codigoLibro Codigo del libro que se desea prestar
     * @param carnet El carnet del estudiante que solicita el prestamo
     */
    public Prestamo(String codigoLibro, int carnet) {
        this(codigoLibro,carnet,null);
    }
 
    /**
     * Devuleve la fecha actual
     * @return Una fecha del paquete sql.date
     */
    private Date getFechaActual(){
        Calendar tiempoEnMillis = Calendar.getInstance();
        Date fechaActual = new Date(tiempoEnMillis.getTimeInMillis());
        return fechaActual;
    }
    
    /**
     * Crea un nuevo prestamo en base al archivo de entrada
     * @param codigoLibro codigo del libro en prestamo
     * @param carnet El carnet del estudiante en prestamo
     * @param fecha La fecha inicial del prestamo
     */
    public Prestamo(String codigoLibro, int carnet, Date fecha) {
        this.codigoLibro = codigoLibro;
        this.carnet = carnet;
        this.fecha = (fecha==null)?getFechaActual():fecha;
    }
}
