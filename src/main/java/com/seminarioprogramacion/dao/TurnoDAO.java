/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TurnoDTO;
import java.util.List;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Esther
 */
public interface TurnoDAO {
     
     TurnoDTO buscar(int id_turno);
     
     List<TurnoDTO> listar();
     
     List<TurnoDTO> listarPorMecanico(int id_mecanico);
     
     boolean insertar(Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico);
     
     boolean modificar(int id_turno, Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico);
     
     boolean borrar(int id_turno);
     
     void cerrarConexion();
}
