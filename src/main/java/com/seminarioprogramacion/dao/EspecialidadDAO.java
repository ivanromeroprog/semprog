/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.EspecialidadDTO;
import java.util.List;

/**
 *
 * @author Esther
 */
public interface EspecialidadDAO {
     
     EspecialidadDTO buscar(String nombre);
     
     EspecialidadDTO buscar(int id_especialidad);
     
     List<EspecialidadDTO> listar();
     
     boolean insertar(String nombre, String descripcion);
     
     boolean modificar(int id_especialidad, String nombre, String descripcion);
     
     boolean borrar(int id_especialidad);
     
     void cerrarConexion();
}
