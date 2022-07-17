package com.seminarioprogramacion.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.seminarioprogramacion.dto.EspecialidadDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel Picca
 */
public class ServicioDAOORM implements ServicioDAO{
 private Dao<ServicioDTO, Integer> servicioOrm = null; //DAO de ormlite
   
  public ServicioDAOORM() {

        try {
            //Url (ubicación de la DB)
            String databaseUrl = new ConexionOrm().GetConexion();
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            servicioOrm = DaoManager.createDao(connectionSource, ServicioDTO.class);

        } catch (SQLException e) {
            System.err.println(e);
        }

    }
 @Override
    public ServicioDTO buscar(String nombre) {
       ServicioDTO servicio = null;
        try {
           servicio = servicioOrm.queryBuilder().where().eq("nombre",nombre).queryForFirst();
           System.out.println(servicio.getNombre());

        } catch (SQLException e) {
            System.err.println(e);
        }
        return servicio;
    }

    @Override
    public ServicioDTO buscar(int id_servicio) {
        ServicioDTO servicio = null;
        try {
            servicio = servicioOrm.queryForId(id_servicio); //ORM 
            System.out.println(servicio.getNombre());

        } catch (SQLException e) {
            System.err.println(e);
        }
        return servicio;
    }

    @Override
    public List<ServicioDTO> listar(EspecialidadDTO especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServicioDTO> listar() {
         List<ServicioDTO> listaServicio = null;

        try {
            listaServicio = servicioOrm.queryForAll(); //ORM 

        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaServicio;
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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
