/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.ServicioDAO;
import com.seminarioprogramacion.dto.ServicioDTO;
import java.util.List;

/**
 *
 * @author Esther
 */
public class Servicio extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final ServicioDAO servicioDao;

    public Servicio() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        servicioDao = fabricaDao.getServicioDao();
    }

    public ServicioDTO buscar(String nombre) {
        ServicioDTO servicio = servicioDao.buscar(nombre);
        return servicio;
    }
    
    public ServicioDTO buscar(int id_servicio) {
        ServicioDTO servicio = servicioDao.buscar(id_servicio);
        return servicio;
    }

    public List<ServicioDTO> listar() {
        List<ServicioDTO> listadoServicios = servicioDao.listar();
        return listadoServicios;
    }

    public boolean insertar(int id_especialidad, String nombre, String descripcion, int tiempo) {
        return servicioDao.insertar(id_especialidad, nombre, descripcion, tiempo);
    }

    public boolean modificar(int id_servicio, int id_especialidad, String nombre, String descripcion, int tiempo) {
        return servicioDao.modificar(id_servicio, id_especialidad, nombre, descripcion, tiempo);
    }

    public boolean borrar(int id_servicio) {
        return servicioDao.borrar(id_servicio);
    }
    
    @Override
    protected void finalize() throws Throwable {
        servicioDao.cerrarConexion();
    }
    
    
}

