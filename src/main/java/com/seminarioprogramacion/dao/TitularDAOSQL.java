/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TitularDTO;
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
 * @author ikukl
 */
public class TitularDAOSQL implements TitularDAO {

    private ConexionSql conexion = null;

    public TitularDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public TitularDTO buscar(String nombre, String apellido) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TitularDTO titular = null;

        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Titular where nombre = ? and apellido = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);

            rs = sentencia.executeQuery();

            String nombre_db;
            String apellido_db;
            String tipo_doc;
            String telefono;
            int id_titular;
            String nro_doc;

            while (rs.next()) {
                nombre_db = rs.getString("nombre");
                apellido_db = rs.getString("apellido");
                tipo_doc = rs.getString("tipo_doc");
                telefono = rs.getString("telefono");
                id_titular = rs.getInt("id_titular");
                nro_doc = rs.getString("nro_doc");

                titular = new TitularDTO(id_titular, nombre_db, apellido_db, tipo_doc, nro_doc, telefono);
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
        return titular;
    }

    @Override
    public TitularDTO buscar(int id_titular) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TitularDTO titular = null;

        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Titular where id_titular = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_titular);

            rs = sentencia.executeQuery();

            String nombre_db;
            String apellido_db;
            String tipo_doc;
            String telefono;
            int id_titular_db;
            String nro_doc;

            while (rs.next()) {
                nombre_db = rs.getString("nombre");
                apellido_db = rs.getString("apellido");
                tipo_doc = rs.getString("tipo_doc");
                telefono = rs.getString("telefono");
                id_titular_db = rs.getInt("id_titular");
                nro_doc = rs.getString("nro_doc");

                titular = new TitularDTO(id_titular_db, nombre_db, apellido_db, tipo_doc, nro_doc, telefono);
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
        return titular;
    }

    @Override
    public List<TitularDTO> listar() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TitularDTO titular = null;
        List<TitularDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection();
            String sql = "select * "
                    + "from Titular order by id_titular DESC";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();

            String nombre;
            String apellido;
            String tipo_doc;
            String telefono;
            int id_titular;
            String nro_doc;

            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                tipo_doc = rs.getString("tipo_doc");
                telefono = rs.getString("telefono");
                id_titular = rs.getInt("id_titular");
                nro_doc = rs.getString("nro_doc");

                titular = new TitularDTO(id_titular, nombre, apellido, tipo_doc, nro_doc, telefono);
                lista.add(titular);
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
    public boolean insertar(String nombre, String apellido, String tipo_dic, String nro_doc, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(int id_titular, String nombre, String apellido, String tipo_dic, String nro_doc, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(int id_titular) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
}
