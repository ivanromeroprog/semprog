/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dto;

/**
 *
 * @author ikukl
 */
public class TitularDTO {
    private int id_titular;
    private String nombre;
    private String apellido;
    private String tipo_dic;
    private int nro_doc;
    private String telefono;

    public TitularDTO(int id_titular, String nombre, String apellido, String tipo_dic, int nro_doc, String telefono) {
        this.id_titular = id_titular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dic = tipo_dic;
        this.nro_doc = nro_doc;
        this.telefono = telefono;
    }

    public int getId_titular() {
        return id_titular;
    }

    public void setId_titular(int id_titular) {
        this.id_titular = id_titular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_dic() {
        return tipo_dic;
    }

    public void setTipo_dic(String tipo_dic) {
        this.tipo_dic = tipo_dic;
    }

    public int getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(int nro_doc) {
        this.nro_doc = nro_doc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
