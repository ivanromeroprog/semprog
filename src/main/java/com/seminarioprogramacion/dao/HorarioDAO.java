/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.HorarioDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 *    
 * @author ikukl
 */
public interface HorarioDAO {
     
     HorarioDTO buscar(String dia);
     
     HorarioDTO buscar(int id_horario);
     
     List<HorarioDTO> listar();
     
     List<HorarioDTO> listar(MecanicoDTO mecanico);
     
     boolean insertar(int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin);
     
     boolean modificar(int id_horario, int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin);
     
     boolean borrar(int id_horario);
     
     void cerrarConexion();
}

