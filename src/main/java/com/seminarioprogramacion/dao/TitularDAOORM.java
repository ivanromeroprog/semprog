/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.TitularDTO;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ikukl
 */
public class TitularDAOORM implements TitularDAO {
    
    private Dao<TitularDTO, Integer> titularOrm = null; //DAO de ormlite
    //https://ormlite.com/javadoc/ormlite-core/com/j256/ormlite/dao/Dao.html
    
    public TitularDAOORM(){
        
        try {
             //Url (ubicación de la DB)
            String databaseUrl = new ConexionOrm().GetConexion();
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        
            titularOrm = DaoManager.createDao(connectionSource, TitularDTO.class);

        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }

    @Override
    public TitularDTO buscar(String nombre, String apellido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TitularDTO buscar(int id_titular) {
        TitularDTO titular = null;
        
        try {
             titular = titularOrm.queryForId(id_titular); //ORM 
             System.out.println(titular.getNombre());

        } catch (SQLException e) {
            System.err.println(e);
        }  
        return titular;
    }

    @Override
    public List<TitularDTO> listar() {
        List<TitularDTO> titulares = null;
        
        try {
             titulares = titularOrm.queryForAll(); //ORM 

        } catch (SQLException e) {
            System.err.println(e);
        }  
        return titulares;
    }

    @Override
    public boolean insertar(String nombre, String apellido, String tipo_doc, String nro_doc, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(int id_titular, String nombre, String apellido, String tipo_doc, String nro_doc, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(int id_titular) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        //connectionSource.close();
    }
}
