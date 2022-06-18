/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminarioprogramacion.dao;

/**
 *
 * @author agustin
 */
public class FabricaDAOSQL extends FabricaDAO {

    @Override
    public VehiculoDAO getVehiculoDao() {
        return new VehiculoDAOSQL();
    }

    @Override
    public TitularDAO getTitularDao() {
        return new TitularDAOSQL();
    }
    
    @Override
    public EspecialidadDAO getEspecialidadDao() {
        return new EspecialidadDAOSQL();
    }
    
    @Override
    public ServicioDAO getServicioDao() {
        return new ServicioDAOSQL();
    }

    @Override
    public MecanicoDAO getMecanicoDao() {
       return new MecanicoDAOSQL();
    }


}
