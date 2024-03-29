package com.seminarioprogramacion.modelo;
import com.seminarioprogramacion.dao.FabricaDAO;
import com.seminarioprogramacion.dao.HorarioDAO;
import com.seminarioprogramacion.dao.MecanicoDAO;
import com.seminarioprogramacion.dto.EspecialidadDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import java.util.List;

/**
 *
 * @author Nahue
 */
public class Mecanico extends Modelo{
    
    private final FabricaDAO fabricaDao;
    private final MecanicoDAO mecanicoDao;
    private final HorarioDAO horarioDao;

    public Mecanico() {
        fabricaDao = FabricaDAO.getFactory("FabricaDAOSQL");
        mecanicoDao = fabricaDao.getMecanicoDao();
        horarioDao = fabricaDao.getHorarioDao();
    }
    
    public MecanicoDTO Buscar(int idMecanico
                            , int idEspecialidad) {
        
        //Establecer lista de horarios del mecanico al cargar solo uno
        MecanicoDTO mecanico = mecanicoDao.Buscar(idMecanico, idEspecialidad);
        mecanico.setHorarios(horarioDao.listar(mecanico));
        
        return mecanico;
    }

    public List<MecanicoDTO> listar() {
        return mecanicoDao.listar();
    }

    public List<MecanicoDTO> listar(EspecialidadDTO especialidad) {
        return mecanicoDao.listar(especialidad);
    }
    
    public boolean Insertar(int idEspecialidad, String legajo, String nombre
                    , String apellido, String tipoDoc, String nroDoc
                    , double cargaHoraria) {
        return mecanicoDao.Insertar(idEspecialidad, legajo, nombre
                                  , apellido, tipoDoc, nroDoc
                                  , cargaHoraria);
    }

    public boolean Modificar(int idMecanico, int idEspecilidad, String legajo, String nombre
                           , String apellido, String tipoDoc, String nroDoc
                           , double cargaHoraria) {
        return mecanicoDao.Modificar(idMecanico, idEspecilidad, legajo, nombre
                                   , apellido, tipoDoc, nroDoc
                                   , cargaHoraria);
    }

    public boolean Borrar(int idMecanico) {
        return mecanicoDao.Borrar(idMecanico);
    }
    
    /*
    @Override
    protected void finalize() throws Throwable {
        turnoDao.cerrarConexion();
    }
    */

}
