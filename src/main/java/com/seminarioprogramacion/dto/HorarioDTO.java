/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author ikukl
 */
public class HorarioDTO {

    
    int id_horario;
    int id_mecanico;
    String dia;
    LocalTime hora_inicio;
    LocalTime hora_fin;

    public HorarioDTO(int id_horario, int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin) {
        this.id_horario = id_horario;
        this.id_mecanico = id_mecanico;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public HorarioDTO(int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin) {
        this.id_mecanico = id_mecanico;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_mecanico() {
        return id_mecanico;
    }

    public void setId_mecanico(int id_mecanico) {
        this.id_mecanico = id_mecanico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + '}';
    }
    
}
