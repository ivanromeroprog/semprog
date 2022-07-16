/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Esther
 */
public class VehiculoDAOORM implements VehiculoDAO {

    private Dao<VehiculoDTO, Integer> vehiculoOrm = null; //DAO de ormlite
    //https://ormlite.com/javadoc/ormlite-core/com/j256/ormlite/dao/Dao.html

    public VehiculoDAOORM() {
        try {
            
             //Url (ubicación de la DB)
            String databaseUrl = new ConexionOrm().GetConexion();
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        
            vehiculoOrm = DaoManager.createDao(connectionSource, VehiculoDTO.class);

        } catch (SQLException e) {
            System.err.println(e);
        }  
    }

    @Override
    public VehiculoDTO buscar(String patente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VehiculoDTO buscar(int id_vehiculo) {
        VehiculoDTO vehiculo = null;
        
        try {
             vehiculo = vehiculoOrm.queryForId(id_vehiculo); //ORM 
             System.out.println(vehiculo.toString());

        } catch (SQLException e) {
            System.err.println(e);
        }  
        return vehiculo;
    }

    @Override
    public List<VehiculoDTO> listar() {
        List<VehiculoDTO> vehiculos = null;
        
        try {
             vehiculos = vehiculoOrm.queryForAll(); //ORM 

        } catch (SQLException e) {
            System.err.println(e);
        }  
        return vehiculos;
    }

    @Override
    public List<VehiculoDTO> listar(TitularDTO titular) {
        List<VehiculoDTO> vehiculos = null;
        
        try {
             vehiculos = vehiculoOrm.queryForEq("id_titular", titular.getId_titular()); //ORM 

        } catch (SQLException e) {
            System.err.println(e);
        }  
        
        return vehiculos;
    }

    @Override
    public boolean insertar(int id_vehiculo, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(int id_vehiculo, int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(int id_vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
