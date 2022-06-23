/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.TurnoDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Esther
 */
public class TurnoDAOSQL implements TurnoDAO {

    private ConexionSql conexion = null;

    public TurnoDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }    

    @Override
    public TurnoDTO buscar(int id_turno) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TurnoDTO turno = null;

        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * "
                    + "from Turno where id_turno = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_turno); //reemplaza

            rs = sentencia.executeQuery(); //resultados de la consulta SQL
            
            //inicializo variables, para luego asignar valores de la DB
            int id_turno_db;
            Date dia_atencion_db;
            LocalTime hora_atencion_db;
            Boolean asistencia_db;
            int id_vehiculo_db;
            int id_servicio_db;
            int id_mecanico_db;
            

            while (rs.next()) {
                id_turno_db = rs.getInt("id_turno"); //asigno valores               
                dia_atencion_db = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dia_atencion"));
                hora_atencion_db = LocalTime.parse(rs.getString("hora_atencion"));
                asistencia_db = rs.getBoolean("asistencia");
                id_vehiculo_db = rs.getInt("id_vehiculo");
                id_servicio_db = rs.getInt("id_servicio");
                id_mecanico_db = rs.getInt("id_mecanico");

                turno = new TurnoDTO(id_turno_db, dia_atencion_db, hora_atencion_db, asistencia_db, id_vehiculo_db, id_servicio_db, id_mecanico_db);
                                               
            }

        } catch (SQLException | ParseException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            } catch (NullPointerException ex){
                System.err.println(ex);
            }
        }
        return turno;
    }

    
    @Override
    public List<TurnoDTO> listar() {
        return _listar(0);
    }

    @Override
    public List<TurnoDTO> listar(MecanicoDTO mecanico) {
        return _listar(mecanico.getIdMecanico());
    }
    
    //Metodo de soporte para no repetir código
    //TODO cargar datos de objetos servicio, etc.
    private List<TurnoDTO> _listar(int id_mecanico){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        
        TurnoDTO turno = null;
        ServicioDTO servicio = null;
        VehiculoDTO vehiculo = null;
        MecanicoDTO mecanico = null;
        TitularDTO titular = null;
        
        List<TurnoDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "SELECT "+
"Turno.*," +
"Servicio.id_especialidad, Servicio.tiempo AS servicio_tiempo, " +
"Servicio.nombre AS servicio_nombre, Servicio.descripcion AS servicio_descripcion," +
"Vehiculo.id_aseguradora, Vehiculo.id_titular, Vehiculo.marca AS vehiculo_marca, Vehiculo.modelo as vehiculo_modelo," +
"Vehiculo.nro_poliza AS vehiculo_nro_poliza, Vehiculo.patente AS vehiculo_patente," +
"Mecanico.id_mecanico," +
"Mecanico.apellido AS mecanico_apellido, Mecanico.nombre AS mecanico_nombre, Mecanico.carga_horaria AS mecanico_carga_horaria," +
"Mecanico.legajo AS mecanico_legajo, Mecanico.nro_doc AS mecanico_nro_doc, Mecanico.tipo_doc AS mecanico_tipo_doc," +
"Titular.apellido AS titular_apellido, Titular.nombre AS titular_nombre, Titular.id_titular, Titular.nro_doc as titular_nro_doc," +
"Titular.tipo_doc AS titular_tipo_doc, Titular.telefono AS titular_telefono " +
"FROM " +
"Turno,Servicio,Vehiculo,Titular,Mecanico " +
"WHERE " +
"Turno.id_servicio = Servicio.id_servicio AND  " +
"Turno.id_mecanico = Mecanico.id_mecanico AND " +
"Turno.id_vehiculo = Vehiculo.id_vehiculo AND " +
"Vehiculo.id_titular = Titular.id_titular";
            
            if(id_mecanico > 0){
                sql+= " WHERE id_mecanico = ? ";
            }
            sql+= " order by id_turno DESC";
            
            sentencia = con.prepareStatement(sql);
            
            if(id_mecanico > 0){
                sentencia.setInt(1, id_mecanico);
            }
            
            rs = sentencia.executeQuery();  //resultados de la consulta SQL
                        
            //inicializo variables, para luego asignar valores de la DB
            int id_turno_db;
            Date dia_atencion_db;
            LocalTime hora_atencion_db;
            Boolean asistencia_db;
            int id_vehiculo_db;
            int id_servicio_db;
            int id_mecanico_db;
            
            //Servicio
            int id_especialidad_db;
            String servicio_nombre_db;
            String servicio_descripcion_db;
            int servicio_tiempo_db;
            
            //Vehiculo
            int id_titular_db;
            int id_aseguradora_db;
            String vehiculo_patente_db;
            String vehiculo_marca_db;
            String vehiculo_modelo_db;
            String vehiculo_nro_poliza_db;
 
            //Titular
            String titular_nombre_db;
            String titular_apellido_db;
            String titular_tipo_doc_db;
            String titular_telefono_db;
            String titular_nro_doc_db;
            
            //Mecanico

            while (rs.next()) {
                //Turno
                id_turno_db = rs.getInt("id_turno"); //asigno valores
                dia_atencion_db = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dia_atencion"));
                hora_atencion_db = LocalTime.parse(rs.getString("hora_atencion"));
                asistencia_db = rs.getBoolean("asistencia");
                id_vehiculo_db = rs.getInt("id_vehiculo");
                id_servicio_db = rs.getInt("id_servicio");
                id_mecanico_db = rs.getInt("id_mecanico");
                turno = new TurnoDTO(id_turno_db, dia_atencion_db, hora_atencion_db, asistencia_db, id_vehiculo_db, id_servicio_db, id_mecanico_db);
                
                //Servicio
                id_servicio_db = rs.getInt("id_servicio"); //asigno valores
                id_especialidad_db = rs.getInt("id_especialidad");
                servicio_nombre_db = rs.getString("servicio_nombre");
                servicio_descripcion_db = rs.getString("servicio_descripcion"); 
                servicio_tiempo_db = rs.getInt("servicio_tiempo");

                servicio = new ServicioDTO(id_servicio_db, id_especialidad_db, servicio_nombre_db,
                        servicio_descripcion_db, servicio_tiempo_db);
                turno.setServicio(servicio);
                
                //Vehiculo
                id_titular_db = rs.getInt("id_titular");
                id_aseguradora_db = rs.getInt("id_aseguradora");
                vehiculo_patente_db = rs.getString("vehiculo_patente"); 
                vehiculo_marca_db = rs.getString("vehiculo_marca");   
                vehiculo_modelo_db = rs.getString("vehiculo_modelo");   
                vehiculo_nro_poliza_db = rs.getString("vehiculo_nro_poliza");
                
                vehiculo = new VehiculoDTO(id_vehiculo_db, id_titular_db,
                        id_aseguradora_db,vehiculo_patente_db,vehiculo_marca_db,
                        vehiculo_modelo_db,vehiculo_nro_poliza_db);
                turno.setVehiculo(vehiculo);
                
                //Titular
                titular_nombre_db = rs.getString("titular_nombre");
                titular_apellido_db = rs.getString("titular_apellido");
                titular_tipo_doc_db = rs.getString("titular_tipo_doc");
                titular_telefono_db = rs.getString("titular_telefono");
                titular_nro_doc_db = rs.getString("titular_nro_doc");
                 
                titular = new TitularDTO(id_titular_db, titular_nombre_db,
                        titular_apellido_db, titular_tipo_doc_db,
                        titular_nro_doc_db,titular_telefono_db);
                turno.setTitular(titular);
                
                //Mecanico
                mecanico = new MecanicoDTO(
                        rs.getInt("id_mecanico"),
                        rs.getInt("id_especialidad"),
                        rs.getString("mecanico_legajo"),
                        rs.getString("mecanico_nombre"),
                        rs.getString("mecanico_apellido"),
                        rs.getString("mecanico_tipo_doc"),
                        rs.getInt("mecanico_nro_doc"),
                        rs.getDouble("mecanico_carga_horaria")
                );
                turno.setMecanico(mecanico);

                
                lista.add(turno);
            }

        } catch (SQLException | ParseException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            } catch (NullPointerException ex){
                System.err.println(ex);
            }
        }
        return lista;

    }
    
    @Override
    public boolean insertar(Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico) {
        
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into turnos (dia_atencion, hora_atencion, asistencia, id_vehiculo, id_servicio, id_mecanico) "
                    + "values(?,?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            
            sentencia.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(dia_atencion));
            sentencia.setString (2, new SimpleDateFormat("hh:mm:ss").format(hora_atencion));
            sentencia.setInt(3, id_vehiculo);
            sentencia.setInt(4, id_servicio);
            sentencia.setInt(5, id_mecanico);

            int resultado = sentencia.executeUpdate();

            return (resultado > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public boolean modificar(int id_turno, Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico) {
        
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "update turnos set dia_atencion=?,hora_atencion=?,asistencia=?,id_vehiculo=?,id_servicio=?,id_mecanico=? where id_turno=?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(dia_atencion));
            sentencia.setString(2, new SimpleDateFormat("hh:mm:ss").format(hora_atencion));
            sentencia.setInt(3, id_vehiculo);
            sentencia.setInt(4, id_servicio);
            sentencia.setInt(5, id_mecanico);
            sentencia.setInt(6, id_turno);

            int resultado = sentencia.executeUpdate();

            return (resultado > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public boolean borrar(int id_turno) {
        
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "delete from turnos where id_turno = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_turno);

            int resultado = sentencia.executeUpdate();

            return (resultado > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

}

