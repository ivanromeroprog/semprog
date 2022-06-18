/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.EspecialidadDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esther
 */
public interface ServicioDAO {
     
     ServicioDTO buscar(String nombre);
     
     ServicioDTO buscar(int id_servicio);
     
     List<ServicioDTO> listar(EspecialidadDTO especialidad);
     
     List<ServicioDTO> listar();
     
     boolean insertar(int id_especialidad, String nombre, String descripcion, int tiempo);
     
     boolean modificar(int id_servicio, int id_especialidad, String nombre, String descripcion, int tiempo);
     
     boolean borrar(int id_servicio);
     
     void cerrarConexion();
}
