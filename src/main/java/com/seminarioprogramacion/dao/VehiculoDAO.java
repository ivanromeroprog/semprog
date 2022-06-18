/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;
import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author ikukl
 */
public interface VehiculoDAO {
   
     VehiculoDTO buscar(String patente);
     
     VehiculoDTO buscar(int id_vehiculo);
     
     List<VehiculoDTO> listar();
     
     List<VehiculoDTO> listar(TitularDTO titular);
     
     boolean insertar(int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza);
     
     boolean modificar(int id_vehiculo, int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza);
     
     boolean borrar(int id_vehiculo);
     
     void cerrarConexion();
}