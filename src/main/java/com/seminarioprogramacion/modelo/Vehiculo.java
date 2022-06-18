/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.VehiculoDAO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author Esther
 */
public class Vehiculo extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final VehiculoDAO vehiculoDao;

    public Vehiculo() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        vehiculoDao = fabricaDao.getVehiculoDao();
    }

    public VehiculoDTO buscar(String nombre) {
        VehiculoDTO vehiculo = vehiculoDao.buscar(nombre);
        return vehiculo;
    }
    
    public VehiculoDTO buscar(int id_vehiculo) {
        VehiculoDTO vehiculo = vehiculoDao.buscar(id_vehiculo);
        return vehiculo;
    }

    public List<VehiculoDTO> listar() {
        List<VehiculoDTO> listadoVehiculoes = vehiculoDao.listar();
        return listadoVehiculoes;
    }

    public boolean insertar(int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        return vehiculoDao.insertar(id_titular, id_aseguradora, patente, marca, modelo, nro_poliza);
    }

    public boolean modificar(int id_vehiculo, int id_titular, int id_aseguradora, String patente, String marca, String modelo, String nro_poliza) {
        return vehiculoDao.modificar(id_vehiculo, id_titular, id_aseguradora, patente, marca, modelo, nro_poliza);
    }

    public boolean borrar(int id_vehiculo) {
        return vehiculoDao.borrar(id_vehiculo);
    }
    
    @Override
    protected void finalize() throws Throwable {
        vehiculoDao.cerrarConexion();
    }
    
    
}

