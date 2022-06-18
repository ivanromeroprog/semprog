package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.MecanicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nahue
 */
public class MecanicoDAOSQL implements MecanicoDAO {

    ConexionSql conexion = null;

    public MecanicoDAOSQL() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public MecanicoDTO Buscar(int idMecanico,
            int idEspecialidad) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        MecanicoDTO mecanico = null;
        String sql = "select * from Mecanico";
        try {
            Connection con = conexion.getConnection(); //instancia de una conexion SQL (Java)
            if (idEspecialidad > 0) {
                sql = sql + " where id_mecanico = ? && id_especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, idMecanico); //reemplaza
                sentencia.setInt(2, idEspecialidad); //reemplaza
            } else {
                sql = sql + " where id_mecanico = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, idMecanico); //reemplaza
            }
            rs = sentencia.executeQuery(); //resultados de la consulta SQL

            while (rs.next()) {
                mecanico = new MecanicoDTO(rs.getInt("id_mecanico"),
                        rs.getInt("id_especialidad"),
                        rs.getString("legajo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("tipo_Doc"),
                        rs.getInt("nro_Doc"),
                        rs.getDouble("carga_horaria"));
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
        return mecanico;
    }

    @Override
    public List<MecanicoDTO> listar() {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<MecanicoDTO> lista = new ArrayList<>();

        try {
            Connection con = conexion.getConnection();
            String sql = "select * from Mecanico order by id_mecanico DESC";
            sentencia = con.prepareStatement(sql);
            rs = sentencia.executeQuery();

            while (rs.next()) {
                lista.add(new MecanicoDTO(rs.getInt("id_mecanico"),
                        rs.getInt("id_especialidad"),
                        rs.getString("legajo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("tipo_doc"),
                        rs.getInt("nro_Doc"),
                        rs.getDouble("carga_horaria")));
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
    public boolean Insertar(int idEspecilidad, String legajo, String nombre, String apellido, String tipoDoc, String nroDoc, double cargaHoraria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Modificar(int idMecanico, int idEspecilidad, String legajo, String nombre, String apellido, String tipoDoc, String nroDoc, double cargaHoraria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Borrar(int idMecanico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
