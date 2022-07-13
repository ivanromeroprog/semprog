/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dto;
        
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author ikukl
 */

@DatabaseTable(tableName = "Titular")
public class TitularDTO {
    
    @DatabaseField(id = true)
    private int id_titular;
    
    @DatabaseField
    private String nombre;
    
    @DatabaseField
    private String apellido;
    
    @DatabaseField
    private String tipo_doc;
    
    @DatabaseField
    private String nro_doc;
    
    @DatabaseField
    private String telefono;

    public TitularDTO() {
        // ORMLite needs a no-arg constructor 
    }
    
    public TitularDTO(String nombre, String apellido, String tipo_doc, String nro_doc, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_doc = tipo_doc;
        this.nro_doc = nro_doc;
        this.telefono = telefono;
    }

    public TitularDTO(int id_titular, String nombre, String apellido, String tipo_doc, String nro_doc, String telefono) {
        this.id_titular = id_titular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_doc = tipo_doc;
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

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(String nro_doc) {
        this.nro_doc = nro_doc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " - " + this.nro_doc;
    }    
}
