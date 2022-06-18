/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TitularDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ikukl
 */
public interface TitularDAO {
     
     TitularDTO buscar(String nombre, String apellido);
     
     TitularDTO buscar(int legajo);
     
     List<TitularDTO> listar();
     
     boolean insertar(String nombre, String apellido, String tipo_dic, String nro_doc, String telefono);
     
     boolean modificar(int id_titular, String nombre, String apellido, String tipo_dic, String nro_doc, String telefono);
     
     boolean borrar(int id_titular);
     
     void cerrarConexion();
}
