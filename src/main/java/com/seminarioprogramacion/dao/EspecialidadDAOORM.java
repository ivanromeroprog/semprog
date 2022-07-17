package com.seminarioprogramacion.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.seminarioprogramacion.dto.EspecialidadDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel Picca
 */
public class EspecialidadDAOORM implements EspecialidadDAO {

    private Dao<EspecialidadDTO, Integer> especialidadOrm = null; //DAO de ormlite

    public EspecialidadDAOORM() {

        try {
            //Url (ubicación de la DB)
            String databaseUrl = new ConexionOrm().GetConexion();
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            especialidadOrm = DaoManager.createDao(connectionSource, EspecialidadDTO.class);

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public EspecialidadDTO buscar(String nombre) {
        EspecialidadDTO listaEspecilidad = null;
        try {
            List<EspecialidadDTO> especialidadList = especialidadOrm.queryForAll(); //ORM 
            for (EspecialidadDTO espeLocal : especialidadList) {
                if (espeLocal.getNombre().equals(nombre)) {
                    listaEspecilidad = espeLocal;
                    break;
                }
            }
            System.out.println(listaEspecilidad.getNombre());

        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaEspecilidad;
    }

    @Override
    public EspecialidadDTO buscar(int id_especialidad) {
        EspecialidadDTO listaEspecilidad = null;
        try {
            listaEspecilidad = especialidadOrm.queryForId(id_especialidad); //ORM 
            System.out.println(listaEspecilidad.getNombre());

        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaEspecilidad;
    }

    @Override
    public List<EspecialidadDTO> listar() {
        List<EspecialidadDTO> listaEspecilidad = null;

        try {
            listaEspecilidad = especialidadOrm.queryForAll(); //ORM 

        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaEspecilidad;
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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
