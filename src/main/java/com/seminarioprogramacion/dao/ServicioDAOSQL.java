/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.ServicioDTO;
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
public class ServicioDAOSQL implements ServicioDAO {

    private ConexionSql conexion = null;

    public ServicioDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public ServicioDTO buscar(String nombre) {
        Connection con = null; 
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ServicioDTO servicio = null;

        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * "
                       + "from Servicio where nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre); //reemplaza

            rs = sentencia.executeQuery(); //resultados de la consulta SQL

            //inicializo variables, para luego asignar valores de la DB
            int id_servicio_db;
            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;
            int tiempo_db;

            while (rs.next()) {
                id_servicio_db = rs.getInt("id_servicio"); //asigno valores
                id_especialidad_db = rs.getInt("id_especialidad");
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion"); 
                tiempo_db = rs.getInt("tiempo");

                servicio = new ServicioDTO(id_servicio_db, id_especialidad_db, nombre_db, descripcion_db, tiempo_db);
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
        return servicio;
    }

    @Override
    public ServicioDTO buscar(int id_servicio) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ServicioDTO servicio = null;

        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Servicio where id_servicio = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_servicio);

            rs = sentencia.executeQuery();

            int id_servicio_db;
            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;
            int tiempo_db;

            while (rs.next()) {
                id_servicio_db = rs.getInt("id_servicio");
                id_especialidad_db = rs.getInt("id_especialidad");
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion");
                tiempo_db = rs.getInt("id_tiempo");

                servicio = new ServicioDTO(id_servicio_db, id_especialidad_db, nombre_db, descripcion_db, tiempo_db);
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
        return servicio;
    }

    @Override
    public List<ServicioDTO> listar() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ServicioDTO servicio = null;
        List<ServicioDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Servicio order by id_servicio DESC";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();

            int id_servicio_db;
            int id_especialidad_db;
            String nombre_db;
            String descripcion_db;
            int tiempo_db;

            while (rs.next()) {
                id_servicio_db = rs.getInt("id_servicio");
                id_especialidad_db = rs.getInt("id_especialidad");
                nombre_db = rs.getString("nombre");
                descripcion_db = rs.getString("descripcion");
                tiempo_db = rs.getInt("tiempo");

                servicio = new ServicioDTO(id_servicio_db, id_especialidad_db, nombre_db, descripcion_db, tiempo_db);
                lista.add(servicio);
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
    public boolean insertar(int id_especialidad, String nombre, String descripcion, int tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(int id_servicio, int id_especialidad, String nombre, String descripcion, int tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(int id_servicio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
