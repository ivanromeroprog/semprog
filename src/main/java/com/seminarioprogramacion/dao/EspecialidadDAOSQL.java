/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.EspecialidadDTO;
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
public class EspecialidadDAOSQL implements EspecialidadDAO {

    private ConexionSql conexion = null;

    public EspecialidadDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public EspecialidadDTO buscar(String nombre) {
        Connection con = null; 
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        EspecialidadDTO especialidad = null;

        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * "
                       + "from Especialidad where nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre); //reemplaza

            rs = sentencia.executeQuery(); //resultados de la consulta SQL

            //inicializo variables, para luego asignar valores de la DB
            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;

            while (rs.next()) {
                id_especialidad_db = rs.getInt("id_especialidad"); //asigno valores
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion");                

                especialidad = new EspecialidadDTO(id_especialidad_db, nombre_db, descripcion_db);
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
        return especialidad;
    }

    @Override
    public EspecialidadDTO buscar(int id_especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        EspecialidadDTO especialidad = null;

        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Especialidad where id_especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_especialidad);

            rs = sentencia.executeQuery();

            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;

            while (rs.next()) {
                id_especialidad_db = rs.getInt("id_especialidad");
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion");

                especialidad = new EspecialidadDTO(id_especialidad_db, nombre_db, descripcion_db);
                
                //Asignar Servicios de la especialidad
                
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
        return especialidad;
    }

    
    @Override
    public List<EspecialidadDTO> listar() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        EspecialidadDTO especialidad = null;
        List<EspecialidadDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Especialidad order by id_especialidad DESC";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();

            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;

            while (rs.next()) {
                id_especialidad_db = rs.getInt("id_especialidad");
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion");

                especialidad = new EspecialidadDTO(id_especialidad_db, nombre_db, descripcion_db);
                lista.add(especialidad);
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
    public boolean insertar(String nombre, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(int id_especialidad, String nombre, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(int id_especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

}
