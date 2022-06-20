package com.seminarioprogramacion.dto;

import java.util.List;

/**
 *
 * @author Nahue
 */
public class MecanicoDTO {
    private int idMecanico;
    private int idEspecialidad;
    private String legajo;
    private String nombre;
    private String apellido;
    private String tipoDic;
    private int nroDoc;
    private double cargaHoraria;
    List<HorarioDTO> horarios;

    public MecanicoDTO(int idMecanico, int idEspecialidad, String legajo
            , String nombre, String apellido, String tipoDic, int nroDoc
            , double cargaHoraria) {
        this.idMecanico = idMecanico;
        this.idEspecialidad = idEspecialidad;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDic = tipoDic;
        this.nroDoc = nroDoc;
        this.cargaHoraria = cargaHoraria;
    }
    
    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
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

    public String getTipoDic() {
        return tipoDic;
    }

    public void setTipoDic(String tipoDic) {
        this.tipoDic = tipoDic;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return this.nombre+" "+this.apellido;
    } 

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }

    
}
