/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.TitularDAO;
import com.seminarioprogramacion.dto.TitularDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author agustin
 */
public class Titular extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final TitularDAO titularDao;

    public Titular() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        titularDao = fabricaDao.getTitularDao();
    }

    public TitularDTO buscar(String nombre, String apellido) {
        TitularDTO titular = titularDao.buscar(nombre, apellido);
        return titular;
    }
    
    public TitularDTO buscar(int id_titular) {
        TitularDTO titular = titularDao.buscar(id_titular);
        return titular;
    }

    public List<TitularDTO> listar() {
        List<TitularDTO> listadoTitulares = titularDao.listar();
        return listadoTitulares;
    }

    public boolean insertar(String nombre, String apellido, String tipo_dic, String nro_doc, String telefono) {
        return titularDao.insertar(nombre, apellido, tipo_dic, nro_doc, telefono);
    }

    public boolean modificar(int id_titular, String nombre, String apellido, String tipo_dic, String nro_doc, String telefono) {
        return titularDao.modificar(id_titular, nombre, apellido, tipo_dic, nro_doc, telefono);
    }

    public boolean borrar(int id_titular) {
        return titularDao.borrar(id_titular);
    }
    
    @Override
    protected void finalize() throws Throwable {
        titularDao.cerrarConexion();
    }
    
    
}
