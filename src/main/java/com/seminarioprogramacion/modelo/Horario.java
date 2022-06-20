/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.HorarioDAO;
import com.seminarioprogramacion.dto.HorarioDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ikukl
 */
public class Horario extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final HorarioDAO horarioDao;

    public Horario() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        horarioDao = fabricaDao.getHorarioDao();
    }

    public HorarioDTO buscar(String dia) {
        HorarioDTO horario = horarioDao.buscar(dia);
        return horario;
    }
    
    public HorarioDTO buscar(int id_horario) {
        HorarioDTO horario = horarioDao.buscar(id_horario);
        return horario;
    }

    public List<HorarioDTO> listar() {
        List<HorarioDTO> listadoHorarioes = horarioDao.listar();
        return listadoHorarioes;
    }
    
    public List<HorarioDTO> listar(MecanicoDTO mecanico) {
        List<HorarioDTO> listadoHorarioes = horarioDao.listar(mecanico);
        return listadoHorarioes;
    }

    public boolean insertar(int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin) {
        return horarioDao.insertar(id_mecanico, dia, hora_inicio, hora_fin);
    }

    public boolean modificar(int id_horario, int id_mecanico, String dia, LocalTime hora_inicio, LocalTime hora_fin){
        return horarioDao.modificar(id_horario, id_mecanico, dia, hora_inicio, hora_fin);
    }

    public boolean borrar(int id_horario) {
        return horarioDao.borrar(id_horario);
    }
    
    @Override
    protected void finalize() throws Throwable {
        horarioDao.cerrarConexion();
    }
    
    
}

