/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dto;

/**
 *
 * @author ikukl
 */
public class VehiculoDTO {

    
    private int id_vehiculo;
    private int id_titular;
    private int id_aseguradora;
    private String patente;
    private String marca;
    private String modelo;
    private String nro_poliza;

    public VehiculoDTO(int id_vehiculo, int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        this.id_vehiculo = id_vehiculo;
        this.id_titular = id_titular;
        this.id_aseguradora = id_aseguradora;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.nro_poliza = nro_poliza;
    }

    public VehiculoDTO(int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        this.id_titular = id_titular;
        this.id_aseguradora = id_aseguradora;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.nro_poliza = nro_poliza;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_titular() {
        return id_titular;
    }

    public void setId_titular(int id_titular) {
        this.id_titular = id_titular;
    }

    public int getId_aseguradora() {
        return id_aseguradora;
    }

    public void setId_aseguradora(int id_aseguradora) {
        this.id_aseguradora = id_aseguradora;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNro_poliza() {
        return nro_poliza;
    }

    public void setNro_poliza(String nro_poliza) {
        this.nro_poliza = nro_poliza;
    }

    @Override
    public String toString() {
        return patente + " (" + marca + " " + modelo +")";
    }
    
    
}
