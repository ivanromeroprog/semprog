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
        //return new VehiculoDAOSQL();
        return new VehiculoDAOORM(); // Usar el Dao ORM
    }

    @Override
    public TitularDAO getTitularDao() {
        //return new TitularDAOSQL();
        return new TitularDAOORM(); //Usa el Dao Orm
    }
    
    @Override
    public EspecialidadDAO getEspecialidadDao() {
        return new EspecialidadDAOORM();
    }
    
    @Override
    public ServicioDAO getServicioDao() {
        return new ServicioDAOORM();
    }

    @Override
    public MecanicoDAO getMecanicoDao() {
       return new MecanicoDAOSQL();
    }

    @Override
    public HorarioDAO getHorarioDao() {
        return new HorarioDAOSQL();
    }
    
    @Override
    public TurnoDAO getTurnoDao() {
        return new TurnoDAOSQL();
    }
}
