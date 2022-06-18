/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminarioprogramacion.dao;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author agustin
 */
public abstract class FabricaDAO {

    public abstract TitularDAO getTitularDao();
    public abstract EspecialidadDAO getEspecialidadDao();
    public abstract ServicioDAO getServicioDao();
    public abstract VehiculoDAO getVehiculoDao();

    public static FabricaDAO getFactory(String nombreClase){
        try {            
            return (FabricaDAO) Class.forName(FabricaDAO.class.getPackage().getName() + "." + nombreClase).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            System.err.println(e);
            throw new IllegalArgumentException();
        }
    }
}
