/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.EspecialidadDAO;
import com.seminarioprogramacion.dao.ServicioDAO;
import com.seminarioprogramacion.dto.EspecialidadDTO;
import java.util.List;

/**
 *
 * @author Esther
 */
public class Especialidad extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final EspecialidadDAO especialidadDao;
    private final ServicioDAO servicioDao;

    public Especialidad() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        especialidadDao = fabricaDao.getEspecialidadDao();
        servicioDao = fabricaDao.getServicioDao();
    }

    public EspecialidadDTO buscar(String nombre) {
        EspecialidadDTO especialidad = especialidadDao.buscar(nombre);
        return especialidad;
    }
    
    public EspecialidadDTO buscar(int id_especialidad) {
        EspecialidadDTO especialidad = especialidadDao.buscar(id_especialidad);
        //Establecer lista de servicios de la especialidad al cargar solo una
        especialidad.setServicios(servicioDao.listar(especialidad));
        return especialidad;
    }

    public List<EspecialidadDTO> listar() {
        List<EspecialidadDTO> listadoEspecialidades = especialidadDao.listar();
        return listadoEspecialidades;
    }

    public boolean insertar(String nombre, String descripcion) {
        return especialidadDao.insertar(nombre, descripcion);
    }

    public boolean modificar(int id_especialidad, String nombre, String descripcion) {
        return especialidadDao.modificar(id_especialidad, nombre, descripcion);
    }

    public boolean borrar(int id_especialidad) {
        return especialidadDao.borrar(id_especialidad);
    }
    
    @Override
    protected void finalize() throws Throwable {
        especialidadDao.cerrarConexion();
    }
    
    
}

