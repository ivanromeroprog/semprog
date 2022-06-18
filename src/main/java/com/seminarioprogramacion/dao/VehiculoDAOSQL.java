/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esther
 */
public class VehiculoDAOSQL implements VehiculoDAO {

    private ConexionSql conexion = null;

    public VehiculoDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }

    
    
    @Override
    public VehiculoDTO buscar(String patente) {
        Connection con = null; 
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * "
                       + "from Vehiculo where patente = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, patente); //reemplaza

            rs = sentencia.executeQuery(); //resultados de la consulta SQL

            /*
            CREATE TABLE "Vehiculo" (
                "id_vehiculo"	INTEGER,
                "id_titular"	INTEGER,
                "id_aseguradora"	INTEGER,
                "patente"	VARCHAR(10) NOT NULL UNIQUE,
                "marca"	VARCHAR(200) NOT NULL,
                "modelo"	VARCHAR(100) NOT NULL,
                "nro_poliza"	VARCHAR(100) NOT NULL,

            */
            
            //inicializo variables, para luego asignar valores de la DB
            int id_vehiculo_db;
            int id_titular_db;
            int id_aseguradora_db;
            String patente_db;
            String marca_db;
            String modelo_db;
            String nro_poliza_db;
            
            while (rs.next()) {
                id_vehiculo_db = rs.getInt("id_vehiculo"); //asigno valores
                id_titular_db = rs.getInt("id_titular");
                id_aseguradora_db = rs.getInt("id_aseguradora");
                patente_db = rs.getString("patente"); 
                marca_db = rs.getString("marca");   
                modelo_db = rs.getString("modelo");   
                nro_poliza_db = rs.getString("nro_poliza");   

                vehiculo = new VehiculoDTO(id_vehiculo_db, id_titular_db, id_aseguradora_db, patente_db, marca_db, modelo_db, nro_poliza_db);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return vehiculo;
    }

    @Override
    public VehiculoDTO buscar(int id_vehiculo) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Vehiculo where id_vehiculo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_vehiculo);

            rs = sentencia.executeQuery();

            int id_vehiculo_db;
            int id_titular_db;
            int id_aseguradora_db;
            String patente_db;
            String marca_db;
            String modelo_db;
            String nro_poliza_db;
            
            while (rs.next()) {
                id_vehiculo_db = rs.getInt("id_vehiculo"); //asigno valores
                id_titular_db = rs.getInt("id_titular");
                id_aseguradora_db = rs.getInt("id_aseguradora");
                patente_db = rs.getString("patente"); 
                marca_db = rs.getString("marca");   
                modelo_db = rs.getString("modelo");   
                nro_poliza_db = rs.getString("nro_poliza");   

                vehiculo = new VehiculoDTO(id_vehiculo_db, id_titular_db, id_aseguradora_db, patente_db, marca_db, modelo_db, nro_poliza_db);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return vehiculo;
    }

    @Override
    public List<VehiculoDTO> listar() {
        return _listar(0);
    }
    
    @Override
    public List<VehiculoDTO> listar(TitularDTO titular) {
        return _listar(titular.getId_titular());
    }
    
    /*
    Metodo privado de soporte
    para no repetir código
    */
    private List<VehiculoDTO> _listar(int id_titular){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;
        List<VehiculoDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Vehiculo";
            
            if(id_titular > 0){
                sql += " where Vehiculo.id_titular = ? ";
            }
            
            sql += " order by id_vehiculo DESC";
            
            sentencia = con.prepareStatement(sql);
                        
            if(id_titular > 0){
                sentencia.setInt(1, id_titular); 
            }

            rs = sentencia.executeQuery();

            int id_vehiculo_db;
            int id_titular_db;
            int id_aseguradora_db;
            String patente_db;
            String marca_db;
            String modelo_db;
            String nro_poliza_db;
            
            while (rs.next()) {
                id_vehiculo_db = rs.getInt("id_vehiculo"); //asigno valores
                id_titular_db = rs.getInt("id_titular");
                id_aseguradora_db = rs.getInt("id_aseguradora");
                patente_db = rs.getString("patente"); 
                marca_db = rs.getString("marca");   
                modelo_db = rs.getString("modelo");   
                nro_poliza_db = rs.getString("nro_poliza");   

                vehiculo = new VehiculoDTO(id_vehiculo_db, id_titular_db, id_aseguradora_db, patente_db, marca_db, modelo_db, nro_poliza_db);
                lista.add(vehiculo);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return lista;
    }

    @Override
    public boolean insertar(int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
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
        conexion.desconectar();
    }

}
