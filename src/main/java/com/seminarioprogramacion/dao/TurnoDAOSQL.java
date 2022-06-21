/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TurnoDTO;
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
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TurnoDTO turno = null;
        List<TurnoDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * "
                    + "from Turno order by id_turno DESC";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();  //resultados de la consulta SQL
            
            
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
    public List<TurnoDTO> listarPorMecanico(int id_mecanico) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TurnoDTO turno = null;
        List<TurnoDTO> lista = new ArrayList<>();
        
        try {
            con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            String sql = "select * from Turno";
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

            while (rs.next()) {
                id_turno_db = rs.getInt("id_turno"); //asigno valores
                dia_atencion_db = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dia_atencion"));
                hora_atencion_db = LocalTime.parse(rs.getString("hora_atencion"));
                asistencia_db = rs.getBoolean("asistencia");
                id_vehiculo_db = rs.getInt("id_vehiculo");
                id_servicio_db = rs.getInt("id_servicio");
                id_mecanico_db = rs.getInt("id_mecanico");
                
                turno = new TurnoDTO(id_turno_db, dia_atencion_db, hora_atencion_db, asistencia_db, id_vehiculo_db, id_servicio_db, id_mecanico_db);
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

