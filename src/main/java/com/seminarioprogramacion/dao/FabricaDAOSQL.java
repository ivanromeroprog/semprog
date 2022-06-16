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
    public TitularDAO getTitularDao() {
        return new TitularDAOSQL();
    }

}
