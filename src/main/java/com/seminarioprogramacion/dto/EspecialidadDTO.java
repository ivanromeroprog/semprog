/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.List;

/**
 *
 * @author Esther
 */
@DatabaseTable(tableName = "Especialidad")
public class EspecialidadDTO {

    @DatabaseField(id = true)
    private int id_especialidad;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String descripcion;

    //Esta propiedad está al pedo, ya que no se usa y no se va a mapear al ORM.
    private List<ServicioDTO> servicios;

    public EspecialidadDTO() {
        // ORMLite needs a no-arg constructor 
    }

    public EspecialidadDTO(int id_especialidad, String nombre, String descripcion) {
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
