/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.modelo;

import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.TurnoDAO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.TurnoDTO;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Esther
 */
public class Turno extends Modelo{
     
    private final FabricaDAO fabricaDao;
    private final TurnoDAO turnoDao;

    public Turno() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        turnoDao = fabricaDao.getTurnoDao();
    }    
    
    public TurnoDTO buscar(int id_turno) {
        TurnoDTO turno = turnoDao.buscar(id_turno);        
        return turno;
    }

    public List<TurnoDTO> listar() {
        List<TurnoDTO> listadoTurnos = turnoDao.listar();
        return listadoTurnos;
    }
    
    public List<TurnoDTO> listar(MecanicoDTO mecanico) {
        List<TurnoDTO> listadoTurnos = turnoDao.listar(mecanico);
        return listadoTurnos;
    }
    
    public List<TurnoDTO> listar(LocalDate fecha) {
        List<TurnoDTO> listadoTurnos = turnoDao.listar(fecha);
        return listadoTurnos;
    }
    
    public List<TurnoDTO> listar(MecanicoDTO mecanico, LocalDate fecha) {
        List<TurnoDTO> listadoTurnos = turnoDao.listar(mecanico,fecha);
        return listadoTurnos;
    }

    public boolean insertar(Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico) {
        return turnoDao.insertar(dia_atencion, hora_atencion, asistencia, id_vehiculo, id_servicio, id_mecanico);
    }

    public boolean modificar(int id_turno, Date dia_atencion, LocalTime hora_atencion, Boolean asistencia, int id_vehiculo, int id_servicio, int id_mecanico) {
        return turnoDao.modificar(id_turno, dia_atencion, hora_atencion, asistencia, id_vehiculo, id_servicio, id_mecanico);
    }

    public boolean borrar(int id_turno) {
        return turnoDao.borrar(id_turno);
    }
    /*
    @Override
    protected void finalize() throws Throwable {
        turnoDao.cerrarConexion();
    }
    */
    
}

