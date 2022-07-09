package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.TurnoDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nahuel Picca
 */
public class TurnoDAOSQLTest {

    static TurnoDAOSQL turnoDao;

    public TurnoDAOSQLTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        turnoDao = new TurnoDAOSQL();
    }

    void AssertTurno(TurnoDTO turno) {
        MecanicoDTO mecanico = turno.getMecanico();
        ServicioDTO servicio = turno.getServicio();
        TitularDTO titular = turno.getTitular();
        VehiculoDTO vehiculo = turno.getVehiculo();

        ///Testea las propiedades del objeto TurnoDto
        assertNotNull(turno.getAsistencia());
        assertNotNull(turno.getDia_atencion());
        assertNotNull(turno.getHora_atencion());
        assertNotNull(mecanico);
        assertNotNull(servicio);
        assertNotNull(titular);
        assertNotNull(vehiculo);

        ///Testea las propiedades del objeto MecanicoDto
        assertTrue(!mecanico.getApellido().isEmpty());
        assertTrue(mecanico.getCargaHoraria() > 0);
        assertTrue(!mecanico.getNombre().isEmpty());
        assertNull(mecanico.getHorarios());
        assertTrue(!mecanico.getTipoDic().isEmpty());
        assertTrue(mecanico.getNroDoc() > 0);
        assertTrue(!mecanico.getLegajo().isEmpty());

        ///Testea las propiedades del objeto ServicioDto
        assertTrue(!servicio.getDescripcion().isEmpty());
        assertTrue(servicio.getTiempo() > 0);
        assertTrue(!servicio.getNombre().isEmpty());

        ///Testea las propiedades del objeto TitularDto
        assertTrue(!titular.getApellido().isEmpty());
        assertTrue(!titular.getTelefono().isEmpty());
        assertTrue(!titular.getNombre().isEmpty());
        assertTrue(!titular.getTipo_dic().isEmpty());
        assertTrue(!titular.getNro_doc().isEmpty());

        ///Testea las propiedades del objeto VehiculoDto
        assertTrue(!vehiculo.getMarca().isEmpty());
        assertTrue(!vehiculo.getModelo().isEmpty());
        assertTrue(!vehiculo.getNro_poliza().isEmpty());
        assertTrue(!vehiculo.getPatente().isEmpty());
    }

    MecanicoDTO GetMecanicoMock() {
        //Este valor es real, cambiarlo si no existe este Id 
        //por uno que existe en la DB.
        int idMecanico = 1;

        int idEspecialidadMock = 1;
        String legajoMock = "ABLP12";
        String nombreMock = "Pepe";
        String apellidoMock = "Argento";
        String tipoDicMock = "DU";
        int nroDocMock = 1522555;
        double cargaHorariaMock = 12;
        MecanicoDTO mecanico = new MecanicoDTO(idMecanico, idEspecialidadMock,
                legajoMock, nombreMock, apellidoMock, tipoDicMock, nroDocMock,
                cargaHorariaMock);
        return mecanico;
    }

    @Test
    public void TestListarTurnosAll() {
        List<TurnoDTO> listTurnos = turnoDao.listar();
        assertTrue(!listTurnos.isEmpty());

        for (TurnoDTO turno : listTurnos) {
            AssertTurno(turno);
        }
    }

    @Test
    public void TestListarTurnosPorMecanico() {
        MecanicoDTO mecanico = GetMecanicoMock();
        List<TurnoDTO> listTurnos = turnoDao.listar(mecanico);
        assertTrue(!listTurnos.isEmpty());

        for (TurnoDTO turno : listTurnos) {
            AssertTurno(turno);
        }
    }

    @Test
    public void TestListarTurnosPorFecha() {
        LocalDate fecha = LocalDate.of(2022, 01, 04);
        List<TurnoDTO> listTurnos = turnoDao.listar(fecha);
        assertTrue(!listTurnos.isEmpty());

        for (TurnoDTO turno : listTurnos) {
            AssertTurno(turno);
        }
    }

    @Test
    public void TestListarTurnosPorMecanicoYFecha() {
        LocalDate fecha = LocalDate.of(2022, 01, 04);
        MecanicoDTO mecanico = GetMecanicoMock();
        List<TurnoDTO> listTurnos = turnoDao.listar(mecanico, fecha);
        assertTrue(!listTurnos.isEmpty());

        for (TurnoDTO turno : listTurnos) {
            AssertTurno(turno);
        }
    }

    @Test
    public void TestInsertarTurno() {
        LocalDate dia_atencion = LocalDate.of(2099, 1, 8);
        LocalTime hora_atencion = LocalTime.of(14,00);
        Boolean asistencia = false;
        int id_vehiculo = 1;
        int id_servicio = 1;
        int id_mecanico = 1;
        boolean resultado = turnoDao.insertar(dia_atencion, hora_atencion,
                              asistencia, id_vehiculo, id_servicio, id_mecanico);
        assertTrue(resultado);
        
        List<TurnoDTO> listTurnos = turnoDao.listar();
        TurnoDTO turno = listTurnos.get(listTurnos.size()-1);
        AssertTurno(turno);
    }

    @Test
    public void TestModificarAsistenciaFalse() {
        TestModificarAsistencia(false);
    }

    @Test
    public void TestModificarAsistenciaTrue() {
        TestModificarAsistencia(true);
    }

    void TestModificarAsistencia(boolean asiste) {
        int id_turno = 0;
        Boolean asistencia = asiste;
        Boolean resultado = turnoDao.modificarAsistencia(id_turno, asistencia);
        assertTrue(resultado);
    }
}
